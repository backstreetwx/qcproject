package com.jason.qccore.web.controller;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.utils.Md5Util;
import com.jason.qccore.utils.Md5Util.EncodeStrategy;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.vo.DetailItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.RankingItem;
import com.jason.qcdao.domain.vo.UserInfo;
/**
* @ClassName: UserController
* @Description: TODO(用户中心控制器)
* @author jason.peng
* @date 2016年1月7日 上午9:53:06
 */
@Controller 
@RequestMapping("/public/user")
public class UserController extends BaseServiceSupport{
	
	@ResponseBody
	@RequestMapping(value="/mayPoint", method=RequestMethod.GET)
	public Result mayPoint(@CookieValue("hashId")String hashId) {
		Integer mayPoint = userService.getMayPoint(hashId);
		DataResult<Integer> result = new DataResult<Integer>();
		result.setData(mayPoint);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public Result info(@CookieValue("hashId")String hashId) {
		User user = userService.getUserByHashId(hashId);
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setType(user.getType());
		userInfo.setAccount(user.getAccount());
		userInfo.setInviteId(user.getInviteId());
		userInfo.setHeadimg(user.getHeadimg());
		userInfo.setNickname(user.getNickname());
		userInfo.setSex(user.getSex());
		DataResult<UserInfo> result = new DataResult<UserInfo>();
		result.setData(userInfo);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/token", method=RequestMethod.GET)
	public Result token() {
		DataResult<String> result = new DataResult<>();
		result.setCode(DataResult.CODE_SUCCESS);
		result.setData(com.jason.qccore.utils.QiNiuUtil.getToken());
		result.setMsg("获取成功");
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateInfo", method=RequestMethod.POST)
	public Result updateInfo(@CookieValue("hashId")String hashId, User user) {
		// 判断用户是否是更新邀请码,是进行校验
		if(user.getInviteId() != null) {
			User currentUser = userService.getUserByHashId(hashId);
			// 判断用户是否绑定过
			if(currentUser.getInviteId() != null) {
				return new DataResult<>(DataResult.CODE_FAILED, "非法操作");
			}
			//--------------
			if(currentUser.getId().equals(user.getInviteId())) {
				return new DataResult<>(DataResult.CODE_FAILED, "不能绑定自己的邀请ID");
			}
			//判断邀请是否存在
			String byHashId = userService.getHashIdById(user.getInviteId());
			if(StringUtils.isBlank(byHashId)) {
				return new DataResult<>(DataResult.CODE_FAILED, "邀请ID不存在");
			}
			// 绑定邀请ID，并给上线积分
			userService.doInvite(byHashId, hashId);
		}
		user.setHashId(hashId);
		userService.asyncUpdateInfo(user);
		return new DataResult<>(DataResult.CODE_SUCCESS, "更新成功");
	}
	
	@ResponseBody
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public Result detail(@CookieValue("hashId")String hashId, Integer index, Integer size) {
		index = index == null || index < 1 || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		Page<DetailItem> page = userService.getDetailPage(hashId, index, size);
		DataResult<Page<DetailItem>> result = new DataResult<Page<DetailItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/ranking", method=RequestMethod.GET)
	public Result ranking(Integer index, Integer size) {
		index = index == null || index < 1 || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		// 最多只能拉取5页数据
		Page<RankingItem> page = userService.getRankingPage(index, size);
		
		if(index > 5) {
			page.setRecordList(null);
		}
		
		DataResult<Page<RankingItem>> result = new DataResult<Page<RankingItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/ranking2", method=RequestMethod.GET)
	public Result ranking2() {
		
		return null;
	}

	@ResponseBody
	@RequestMapping(value="/packetStatus", method=RequestMethod.GET)
	public Result packetStatus(@CookieValue("hashId")String hashId) {
		if(otherCache.opsForSet().isMember("packet", hashId)) { // 缓存中命中
			return new DataResult<>(DataResult.CODE_PACKET_STATUS_YES, "今日已经领取红包");
		} else {
			return new DataResult<>(DataResult.CODE_PACKET_STATUS_NO, "今日没有领取红包");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/packet", method=RequestMethod.GET)
	public Result packet(@CookieValue("hashId")String hashId, String sign, Long timestamp) {
		if(StringUtils.isBlank(sign)
				|| timestamp == null
				|| otherCache.opsForSet().isMember("packet", hashId)) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		// 1.校验签名
		StringBuffer sb = new StringBuffer("packet")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("hashId=")
								.append(hashId)
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
		
		Integer point = userService.doPacket(hashId);
		
		DataResult<Integer> result = new DataResult<Integer>();
		result.setData(point);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
}
