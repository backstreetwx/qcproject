package com.jason.qccore.web.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.utils.CCPUtils;
import com.jason.qccore.utils.CCPUtils.CCPResult;
import com.jason.qccore.utils.Md5Util;
import com.jason.qccore.utils.Md5Util.EncodeStrategy;
import com.jason.qccore.utils.RandomUtil;
import com.jason.qccore.web.resolver.annotation.RequestIP;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.vo.UserStatus;
import com.jason.qcdao.domain.vo.VersionInfo;

/**
* @ClassName: SystemController
* @Description: TODO(系统控制器)
* @author jason.peng
* @date 2015年9月3日 下午2:46:26
 */
@Controller 
@RequestMapping("/public/system")
public class SystemController extends BaseServiceSupport{

	@ResponseBody
	@RequestMapping(value="/error401", method=RequestMethod.GET)
	public Result error401(){
		return new DataResult<>(DataResult.CODE_UNAUTHORIZED, "用户未授权");
	}
	
	@ResponseBody
	@RequestMapping(value="/error402", method=RequestMethod.GET)
	public Result error402(){
		return new DataResult<>(DataResult.CODE_LOCKED, "用户被锁定");
	}
	
	@ResponseBody
	@RequestMapping(value="/error403", method=RequestMethod.GET)
	public Result error403(){
		return new DataResult<>(DataResult.CODE_FORBIDDEN, "系统禁止");
	}
	
	@ResponseBody
	@RequestMapping(value="/error404", method=RequestMethod.GET)
	public Result error404(){
		return new DataResult<>(DataResult.CODE_NOT_FOUND, "资源未找到");
	}
	
	@ResponseBody
	@RequestMapping(value="/error500", method=RequestMethod.GET)
	public Result error500(){
		return new DataResult<>(DataResult.CODE_SYSTEM_ERROR, "系统错误");
	}
	
	@ResponseBody
	@RequestMapping(value="/error503", method=RequestMethod.GET)
	public Result error503(){
		return new DataResult<>(DataResult.CODE_SYSTEM_MAINTENANCE, "系统维护中...");
	}
	
	@ResponseBody
	@RequestMapping(value="/dateTime", method=RequestMethod.GET)
	public Result dateTime(){
		DataResult<Date> result = new DataResult<Date>();
		result.setData(new Date());
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/version", method=RequestMethod.GET)
	public Result version(Integer type) {
		if(type == null || type > 2 || type < 1) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		VersionInfo versionInfo = systemService.getVersionInfo(type);
		DataResult<VersionInfo> result = new DataResult<VersionInfo>();
		result.setData(versionInfo);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@Deprecated
	@ResponseBody
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public Result code(String account, Integer type, @RequestIP String ip) { // type 1、注册 2、忘记密码
		
		//-------------IP限制
		String key = "code_" + ip;
		long inc = ipCache.boundValueOps(key).increment(1);
		if(inc > 20) {
			logger.info("IP限制（code）：ip={}", ip);
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		
		if(StringUtils.isBlank(account)
				|| (!Pattern.matches("1[3|4|5|7|8][0-9]\\d{4,8}", account))
				|| type == null 
				|| type > 2
				|| type < 1) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		Long expire = codeCache.getExpire(account, TimeUnit.SECONDS);
		if(expire != -2 && expire > 240) {
			return new DataResult<>(DataResult.CODE_FAILED, "60秒后，重新获取");
		}
		
		if(type == 1 && userService.isExistUser(account)) {
			return new DataResult<>(DataResult.CODE_FAILED, "手机号已注册");
		}
		
		CCPResult ccpResult = CCPUtils.sendSMS(account);
		DataResult<?> result = new DataResult<>();
		if(ccpResult.isStatus()) {
			// 保存验证码到缓存，缓存10分钟
			codeCache.opsForValue().set(account, ccpResult.getMsg(), 10, TimeUnit.MINUTES);
			result.setCode(DataResult.CODE_SUCCESS);
			result.setMsg("获取验证码成功");
		} else {
			result.setCode(DataResult.CODE_FAILED);
			result.setMsg(ccpResult.getMsg());
		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/code2", method=RequestMethod.POST)
	public Result code2(String account, Integer type, String sign, Long timestamp,
			@RequestIP String ip) { // type 1、注册 2、忘记密码
		
		//-------------IP限制
		String key = "code2_" + ip;
		long inc = ipCache.boundValueOps(key).increment(1);
		if(inc > 20) {
			logger.info("IP限制（code2）：ip={}", ip);
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		if(StringUtils.isBlank(sign)
				|| timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		// 1.校验签名
		StringBuffer sb = new StringBuffer("code2")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("account=")
								.append(account)
								.append(":")
								.append("type=")
								.append(type)
								.append(":")
								.append("timestamp=")
								.append(timestamp);
		String md5 = Md5Util.encrypt(sb.toString(), EncodeStrategy.ENCODE_HEX);
		if(!md5.equals(sign)) {
			return new DataResult<>(DataResult.CODE_FAILED, "签名错误");
		}
		
		Date current = new Date();
		if(current.getTime() - timestamp > 7200000) {
			return new DataResult<>(DataResult.CODE_SYSTEM_TIME_ERROR, "系统繁忙，请稍后在试");
		}
		
		if(StringUtils.isBlank(account)
				|| (!Pattern.matches("1[3|4|5|7|8][0-9]\\d{4,8}", account))
				|| type == null 
				|| type > 2
				|| type < 1) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		Long expire = codeCache.getExpire(account, TimeUnit.SECONDS);
		if(expire != -2 && expire > 240) {
			return new DataResult<>(DataResult.CODE_FAILED, "60秒后，重新获取");
		}
		
		if(type == 1 && userService.isExistUser(account)) {
			return new DataResult<>(DataResult.CODE_FAILED, "手机号已注册");
		}
		
		CCPResult ccpResult = CCPUtils.sendSMS(account);
		DataResult<?> result = new DataResult<>();
		if(ccpResult.isStatus()) {
			// 保存验证码到缓存，缓存10分钟
			codeCache.opsForValue().set(account, ccpResult.getMsg(), 10, TimeUnit.MINUTES);
			result.setCode(DataResult.CODE_SUCCESS);
			result.setMsg("获取验证码成功");
		} else {
			result.setCode(DataResult.CODE_FAILED);
			result.setMsg(ccpResult.getMsg());
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/reg", method=RequestMethod.POST)
	public Result reg(String account, String password, String code, Integer inviteId, 
			HttpServletResponse response, @RequestIP String ip) {
		
		//-------------IP限制
		String key = "reg_" + ip;
		long inc = ipCache.boundValueOps(key).increment(1);
		if(inc > 20) {
			logger.info("IP限制（reg）：ip={}", ip);
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		if(StringUtils.isBlank(account) 
				|| StringUtils.isBlank(password) 
				|| StringUtils.isBlank(code)
				|| (!Pattern.matches("1[3|4|5|7|8][0-9]\\d{4,8}", account))
				|| (password.length() < 6 || password.length() > 32)
				|| code.length() != 6) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		String localCode = (String) codeCache.opsForValue().get(account);
		
		if(StringUtils.isBlank(localCode)) {
			return new DataResult<>(DataResult.CODE_FAILED, "验证码已经过期");
		}
		
		if(!localCode.equals(code)) {
			return new DataResult<>(DataResult.CODE_FAILED, "验证码不正确");
		}
		
		if(inviteId != null && (!userService.isExistUser(inviteId))) {
			return new DataResult<>(DataResult.CODE_FAILED, "邀请ID不存在");
		}
	
		if(userService.isExistUser(account)) {
			return new DataResult<>(DataResult.CODE_FAILED, "手机号已注册");
		}
		
		Date current = new Date();
		// 生成hashId
		String hashId = getHashId(account, "", current);
		// 生成密码
		String salt = RandomUtil.createCharacterSerial(12);
		password = Md5Util.encrypt(password + salt, EncodeStrategy.ENCODE_HEX);
		
		User user = new User();
		user.setType(User.UNKNOWN_TYPE);
		user.setHashId(hashId);
		user.setAccount(account);
		user.setPassword(password);
		user.setSalt(salt);
		user.setInviteId(inviteId);
		user.setNickname("");
		user.setHeadimg(User.HEADIMG_DEFAULT);
		user.setCreateTime(current);
		
		userService.saveUser(user);
		// 返回结果
		DataResult<UserStatus> result = new DataResult<UserStatus>();
		
		UserStatus userStatus = new UserStatus();
		userStatus.setHashId(hashId);
		userStatus.setAccount(account);
		
		result.setData(userStatus);
		result.setCode(DataResult.CODE_SUCCESS);
		
		// 设置用户的hashId到cookie
		setUserCookie(hashId, response);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/reg2", method=RequestMethod.POST)
	public Result reg2(String account, String password, String code, Integer inviteId, 
			HttpServletResponse response, @RequestIP String ip) {
		
		//-------------IP限制
		String key = "reg2_" + ip;
		long inc = ipCache.boundValueOps(key).increment(1);
		if(inc > 20) {
			logger.info("IP限制（reg2）：ip={}", ip);
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		if(StringUtils.isBlank(account) 
				|| StringUtils.isBlank(password) 
				|| StringUtils.isBlank(code)
				|| (!Pattern.matches("1[3|4|5|7|8][0-9]\\d{4,8}", account))
				|| (password.length() < 6 || password.length() > 32)
				|| code.length() != 6) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		String localCode = (String) codeCache.opsForValue().get(account);
		
		if(StringUtils.isBlank(localCode)) {
			return new DataResult<>(DataResult.CODE_FAILED, "验证码已经过期");
		}
		
		if(!localCode.equals(code)) {
			return new DataResult<>(DataResult.CODE_FAILED, "验证码不正确");
		}
		
		if(inviteId != null && (!userService.isExistUser(inviteId))) {
			return new DataResult<>(DataResult.CODE_FAILED, "邀请ID不存在");
		}
	
		if(userService.isExistUser(account)) {
			return new DataResult<>(DataResult.CODE_FAILED, "手机号已注册");
		}
		
		Date current = new Date();
		// 生成hashId
		String hashId = getHashId2(account, "", current);
		// 生成密码
		String salt = RandomUtil.createCharacterSerial(12);
		password = Md5Util.encrypt(password + salt, EncodeStrategy.ENCODE_HEX);
		
		User user = new User();
		user.setType(User.UNKNOWN_TYPE);
		user.setHashId(hashId);
		user.setAccount(account);
		user.setPassword(password);
		user.setSalt(salt);
		user.setInviteId(inviteId);
		user.setNickname("");
		user.setHeadimg(User.HEADIMG_DEFAULT);
		user.setCreateTime(current);
		
		userService.saveUser(user);
		// 返回结果
		DataResult<UserStatus> result = new DataResult<UserStatus>();
		
		UserStatus userStatus = new UserStatus();
		userStatus.setHashId(hashId);
		userStatus.setAccount(account);
		
		result.setData(userStatus);
		result.setCode(DataResult.CODE_SUCCESS);
		
		// 设置用户的hashId到cookie
		setUserCookie(hashId, response);
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/auth", method=RequestMethod.POST)
	public Result auth(String openId, String headimg, String nickname, Integer sex,
			HttpServletResponse response, @RequestIP String ip) {
		
		//-------------IP限制
		String key = "auth_" + ip;
		long inc = ipCache.boundValueOps(key).increment(1);
		if(inc > 20) {
			logger.info("IP限制（auth）：ip={}", ip);
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		
		if(StringUtils.isBlank(openId) 
				|| sex == null 
				|| sex > 2 
				|| sex < 0) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		Date current = new Date();
		User user = userService.getUserByOpenId(openId);
		if(user == null) { // 1.用户不存在
			// 生成hashId
			String hashId = getHashId("", openId, current);
			
			
			user = new User();
			user.setType(User.WX_TYPE);
			user.setHashId(hashId);
			user.setOpenId(openId);
			user.setHeadimg(headimg);
			user.setNickname(nickname);
			user.setSex(sex);
			user.setCreateTime(current);
			
			userService.saveUser(user);
			
		} else if(User.UNLOCKED_STATUS.equals(user.getStatus())){ // 用户存在并且用户非锁定状态
			user.setHeadimg(headimg);
			user.setNickname(nickname);
			user.setSex(sex);
			
			userService.asyncUpdateUser(user);
		} else { // 用户存在但是用户被锁定
			return new DataResult<>(DataResult.CODE_FAILED, "用户被锁定");
		}
		
		// 返回结果
		DataResult<UserStatus> result = new DataResult<UserStatus>();
		
		UserStatus userStatus = new UserStatus();
		userStatus.setHashId(user.getHashId());
		userStatus.setAccount(user.getAccount());
		
		result.setData(userStatus);
		result.setCode(DataResult.CODE_SUCCESS);
		
		// 设置用户的hashId到cookie
		setUserCookie(user.getHashId(), response);
		return result;	
	}
	
	@ResponseBody
	@RequestMapping(value="/auth2", method=RequestMethod.POST)
	public Result auth2(String openId, String headimg, String nickname, Integer sex,
			HttpServletResponse response, @RequestIP String ip) {
		
		//-------------IP限制
		String key = "auth2_" + ip;
		long inc = ipCache.boundValueOps(key).increment(1);
		if(inc > 20) {
			logger.info("IP限制（auth2）：ip={}", ip);
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		if(StringUtils.isBlank(openId) 
				|| sex == null 
				|| sex > 2 
				|| sex < 0) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		Date current = new Date();
		User user = userService.getUserByOpenId(openId);
		if(user == null) { // 1.用户不存在
			// 生成hashId
			String hashId = getHashId2("", openId, current);
			
			
			user = new User();
			user.setType(User.WX_TYPE);
			user.setHashId(hashId);
			user.setOpenId(openId);
			user.setHeadimg(headimg);
			user.setNickname(nickname);
			user.setSex(sex);
			user.setCreateTime(current);
			
			userService.saveUser(user);
			
		} else if(User.UNLOCKED_STATUS.equals(user.getStatus())){ // 用户存在并且用户非锁定状态
			user.setHeadimg(headimg);
			user.setNickname(nickname);
			user.setSex(sex);
			
			userService.asyncUpdateUser(user);
		} else { // 用户存在但是用户被锁定
			return new DataResult<>(DataResult.CODE_FAILED, "用户被锁定");
		}
		
		// 返回结果
		DataResult<UserStatus> result = new DataResult<UserStatus>();
		
		UserStatus userStatus = new UserStatus();
		userStatus.setHashId(user.getHashId());
		userStatus.setAccount(user.getAccount());
		
		result.setData(userStatus);
		result.setCode(DataResult.CODE_SUCCESS);
		
		// 设置用户的hashId到cookie
		setUserCookie(user.getHashId(), response);
		return result;	
	}
	
	@ResponseBody
	@RequestMapping(value="/lgn", method=RequestMethod.POST)
	public Result lgn(String account, String password, HttpServletResponse response) {
		if(StringUtils.isBlank(account) 
				|| StringUtils.isBlank(password) 
				|| (!Pattern.matches("1[3|4|5|7|8][0-9]\\d{4,8}", account))
				|| (password.length() < 6 || password.length() > 32)) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		User user = userService.getUserByAccount(account);
		if(user == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "用户不存在或密码错误");
		}
		
		if(User.LOCKED_STATUS.equals(user.getStatus())) {
			return new DataResult<>(DataResult.CODE_FAILED, "用户被锁定");
		}
		
		if(!user.getPassword().equals(Md5Util.encrypt(password + user.getSalt(), EncodeStrategy.ENCODE_HEX))) {
			return new DataResult<>(DataResult.CODE_FAILED, "用户不存在或密码错误");
		}
		
		// 返回结果
		DataResult<UserStatus> result = new DataResult<UserStatus>();
		
		UserStatus userStatus = new UserStatus();
		userStatus.setHashId(user.getHashId());
		userStatus.setAccount(user.getAccount());
		
		result.setData(userStatus);
		result.setCode(DataResult.CODE_SUCCESS);
		
		// 设置用户的hashId到cookie
		setUserCookie(user.getHashId(), response);
		return result;	
	}
	
	
	@ResponseBody
	@RequestMapping(value="/password", method=RequestMethod.POST)
	public Result password(String account, String password, String code) {
		if(StringUtils.isBlank(account) 
				|| StringUtils.isBlank(password) 
				|| StringUtils.isBlank(code)
				|| (!Pattern.matches("1[3|4|5|7|8][0-9]\\d{4,8}", account))
				|| (password.length() < 6 || password.length() > 32)
				|| code.length() != 6) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		String localCode = (String) codeCache.opsForValue().get(account);
		
		if(StringUtils.isBlank(localCode)) {
			return new DataResult<>(DataResult.CODE_FAILED, "验证码已经过期");
		}
		
		if(!localCode.equals(code)) {
			return new DataResult<>(DataResult.CODE_FAILED, "验证码不正确");
		}
		
		
		if(!userService.isExistUser(account)) {
			return new DataResult<>(DataResult.CODE_FAILED, "手机号没有注册");
		}
		
		// 生成密码
		String salt = RandomUtil.createCharacterSerial(12);
		password = Md5Util.encrypt(password + salt, EncodeStrategy.ENCODE_HEX);
		
		userService.updatePassword(account, password, salt);
		
		return new DataResult<>(DataResult.CODE_SUCCESS, "修改成功");
	}
	
	@RequestMapping(value="/helper", method=RequestMethod.GET)
	public String helper() {
		return "system_helper";
	}
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public String intro() {
		return "system_intro";
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about() {
		return "system_about";
	}
	
	/**
	* @Title: setUserCookie
	* @Description: TODO(保存hashId到cookie 30天)
	* @param hashId
	* @param response
	* @author jason.peng
	* @date 2016年1月6日 下午5:45:49
	 */
	private void setUserCookie(String hashId, HttpServletResponse response){
		Cookie userCookie = new Cookie("hashId", hashId);
		userCookie.setMaxAge(31104000);
		userCookie.setPath("/");
		response.addCookie(userCookie);
	}
	
	/**
	* @Title: getHashId
	* @Description: TODO(生成hashId的策略)
	* @param account
	* @param openId
	* @param createTime
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午5:38:21
	 */
	private String getHashId(String account, String openId, Date createTime) {
		StringBuffer sb = new StringBuffer("reg")
									.append(":")
									.append("account=")
									.append(account)
									.append(":")
									.append("openId=")
									.append(":")
									.append("createTime=")
									.append(createTime);
		return Md5Util.encrypt(sb.toString(), EncodeStrategy.ENCODE_HEX);
	}
	
	/**
	* @Title: getHashId2
	* @Description: TODO(获取hash算法2)
	* @param account
	* @param openId
	* @param createTime
	* @return
	* @author jason.peng
	* @date 2016年2月26日 上午9:15:57
	 */
	private String getHashId2(String account, String openId, Date createTime) {
		StringBuffer sb = new StringBuffer("reg")
									.append(":")
									.append("account=")
									.append(account)
									.append(":")
									.append("openId=")
									.append(":")
									.append(openId)
									.append("createTime=")
									.append(createTime.getTime());
		return Md5Util.encrypt(sb.toString(), EncodeStrategy.ENCODE_HEX);
	}
}
