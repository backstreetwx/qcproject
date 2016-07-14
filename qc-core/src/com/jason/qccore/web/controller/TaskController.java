package com.jason.qccore.web.controller;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.utils.Md5Util;
import com.jason.qccore.utils.Md5Util.EncodeStrategy;
import com.jason.qccore.web.resolver.annotation.RequestIP;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.po.TaskContent;
import com.jason.qcdao.domain.po.TaskTmp;
import com.jason.qcdao.domain.vo.HotTaskItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.ReadTaskContent;
import com.jason.qcdao.domain.vo.TaskItem;
import com.jason.qcdao.domain.vo.TaskShare;
import com.jason.qcdao.domain.vo.UserTaskItem;
import com.jason.qcdao.domain.vo.WatchTaskContent;
/**
* @ClassName: TaskController
* @Description: TODO(任务大厅控制器)
* @author jason.peng
* @date 2016年1月8日 上午10:55:12
 */
@Controller 
@RequestMapping("/public/task")
public class TaskController extends BaseServiceSupport{

	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Result list(@CookieValue("hashId")String hashId, Integer index, Integer size) {
		index = index == null || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		Page<TaskItem> page = taskService.getTaskPage(hashId, index, size);
		DataResult<Page<TaskItem>> result = new DataResult<Page<TaskItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/list2", method=RequestMethod.GET)
	public Result list2(@CookieValue("hashId")String hashId, Integer index, Integer size,
			@RequestHeader("User-Agent")String userAgent) {
		index = index == null || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		if(userAgent.toLowerCase().contains("android")) {
			Page<TaskItem> page = taskService.getTaskPage2(hashId, index, size);
			DataResult<Page<TaskItem>> result = new DataResult<Page<TaskItem>>();
			result.setData(page);
			result.setCode(DataResult.CODE_SUCCESS);
			return result;
		}
		
		Page<TaskItem> page = taskService.getTaskPage3(hashId, index, size);
		DataResult<Page<TaskItem>> result = new DataResult<Page<TaskItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/record", method=RequestMethod.GET)
	public Result record(@CookieValue("hashId")String hashId, Integer index, Integer size) {
		index = index == null || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		Page<UserTaskItem> page = taskService.getUserTaskPage(hashId, index, size);
		DataResult<Page<UserTaskItem>> result = new DataResult<Page<UserTaskItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/hot", method=RequestMethod.GET)
	public Result hot(@CookieValue("hashId")String hashId, Integer index, Integer size) {
		index = 1;
		size = 10;// 保留字段
		
		Page<HotTaskItem> page = taskService.getHotTaskPage(hashId, index, size);
		DataResult<Page<HotTaskItem>> result = new DataResult<Page<HotTaskItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/hot2", method=RequestMethod.GET)
	public Result hot2(@CookieValue("hashId")String hashId, Integer index, Integer size) {
		index = 1;
		size = 10;// 保留字段
		
		Page<HotTaskItem> page = taskService.getHotTaskPage2(hashId, index, size);
		DataResult<Page<HotTaskItem>> result = new DataResult<Page<HotTaskItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/watch", method=RequestMethod.GET)
	public Result watch(@CookieValue("hashId")String hashId, Integer taskId) {
		WatchTaskContent watchTaskContent = taskService.getWatchTaskContent(hashId, taskId);
		
		if(watchTaskContent.getType().equals(TaskContent.WEIXIN_URL_TYPE)) {
			watchTaskContent.setType(TaskContent.URL_TYPE);
			watchTaskContent.setUrl("http://121.196.232.104/qc-core/public/task/weixin");
		}
		
		DataResult<WatchTaskContent> result = new DataResult<WatchTaskContent>();
		result.setData(watchTaskContent);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/share", method=RequestMethod.GET)
	public Result share(@CookieValue("hashId")String hashId, Integer taskId) {
		if(taskId == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		TaskShare taskShare = taskService.getTaskShare(hashId, taskId);
		DataResult<TaskShare> result = new DataResult<TaskShare>();
		result.setData(taskShare);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/callback", method=RequestMethod.GET)
	public Result callback(@CookieValue("hashId")String hashId, Integer taskId, 
			String sign, Long timestamp) {
		if(taskId == null
				|| StringUtils.isBlank(sign)
				|| timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		// 1.校验签名
		StringBuffer sb = new StringBuffer("task")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("hashId=")
								.append(hashId)
								.append(":")
								.append("taskId=")
								.append(taskId)
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
		// 判断分享是否完成
		taskService.doCallback(hashId, taskId);
		return new DataResult<>(DataResult.CODE_SUCCESS, "回调成功");
	}
	
	
	@ResponseBody
	@RequestMapping(value="/callback2", method=RequestMethod.GET)
	public Result callback2(@CookieValue("hashId")String hashId, Integer taskId, 
			String sign, Long timestamp) {
		if(taskId == null
				|| StringUtils.isBlank(sign)
				|| timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		// 1.校验签名
		StringBuffer sb = new StringBuffer("task")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("hashId=")
								.append(hashId)
								.append(":")
								.append("taskId=")
								.append(taskId)
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
		// 判断分享是否完成
		taskService.doCallback2(hashId, taskId);
		return new DataResult<>(DataResult.CODE_SUCCESS, "回调成功");
	}
	
	
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String content(Integer taskId, Integer id, String sign, Long timestamp, 
			@RequestHeader ("User-Agent") String userAgent, Model model) {
		
		if(taskId == null || id == null || StringUtils.isBlank(sign) || timestamp == null) {
			return "redirect:/public/system/error403";
		}
	
		if(!getSign(taskId, id, timestamp).equals(sign)) {
			return "redirect:/public/system/error403";
		}
		
		ReadTaskContent readTaskContent = taskService.getReadTaskContent(taskId);
		
		model.addAttribute("readTaskContent", readTaskContent);
		model.addAttribute("taskId", taskId);
		model.addAttribute("id", id);
		model.addAttribute("sign", sign);
		model.addAttribute("timestamp", timestamp);
		
		// *如果是微信地址，就变成地址
		if(readTaskContent.getType().equals(TaskContent.WEIXIN_URL_TYPE)) {
			readTaskContent.setType(TaskContent.URL_TYPE);
		}
		
		// 非微信浏览器，并且是URL类型
		if(userAgent.contains("MicroMessenger")) { // 微信
			if(TaskContent.URL_TYPE.equals(readTaskContent.getType())) {
				return "task_script";
			} else {
				return "task_content";
			}
		} else { // 非微信
			if(TaskContent.URL_TYPE.equals(readTaskContent.getType())) { 
				// 临时处理
				return "redirect:" + readTaskContent.getUrl();
			} else {
				
				return "task_content";
			}
		}
	}
	
	@RequestMapping(value="/weixin", method=RequestMethod.GET)
	public String weixin() {
		return "task_weixin";
	}
	
	@ResponseBody
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public Result read(String finger, Integer taskId, Integer id, String sign, Long timestamp,@RequestIP String ip,
			@RequestHeader("User-Agent")String userAgent) {
		// --------------hashIP限制-----------------------------
		String hashIp = getHashIp(taskId, id, ip);
		long inc = ipCache.boundValueOps(hashIp).increment(1);
		if(inc > 5) {
			logger.info("hashIP限制：hashIp={}, inc={}", hashIp, inc);
			return new DataResult<>(DataResult.CODE_FAILED, "请求失败");
		}
		
		// --------------指纹限制-----------------------------
		long inc2 = fingerCache.boundValueOps(finger).increment(1);
		if(inc2 > 5) {
			logger.info("指纹限制：finger={}, inc2={}", finger, inc2);
			return new DataResult<>(DataResult.CODE_FAILED, "请求失败");
		}
		

		if(taskId == null || id == null || StringUtils.isBlank(sign) || timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		if(!getSign(taskId, id, timestamp).equals(sign)) {
			return new DataResult<>(DataResult.CODE_FAILED, "请求失败");
		}
		// 校验指纹
		String hashFinger = getHashFinger(finger,taskId);
		if(taskService.isExistTaskTmp(hashFinger)) {
			return new DataResult<>(DataResult.CODE_FAILED, "请求失败");
		}
		
		TaskTmp taskTmp = new TaskTmp();
		taskTmp.setHashFinger(hashFinger);
		taskTmp.setUserId(id);
		taskTmp.setTaskId(taskId);
		taskTmp.setFinger(finger);
		taskTmp.setIp(ip);
		taskTmp.setCreateTime(new Date());
		
		taskService.doRead(taskTmp);
		return new DataResult<>(DataResult.CODE_SUCCESS, "请求成功");
	}
	
	/**
	* @Title: getHashFinger
	* @Description: TODO(获取指纹hash)
	* @param finger
	* @param userId
	* @param taskId
	* @param ip
	* @return
	* @author jason.peng
	* @date 2016年2月22日 下午4:48:27
	 */
	private String getHashFinger(String finger,Integer taskId) {
		String[] arr = {finger, taskId + ""};
		String str = StringUtils.join(arr, "::");
		return Md5Util.encrypt(str, EncodeStrategy.ENCODE_HEX);
	}
	/**
	* @Title: getHashIp
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param taskId
	* @param id
	* @param ip
	* @return
	* @author jason.peng
	* @date 2016年2月21日 上午9:00:32
	 */
	private String getHashIp(Integer taskId, Integer id, String ip) {
		String[] arr = {taskId + "", id + "", ip};
		String str = StringUtils.join(arr, "::");
		return Md5Util.encrypt(str, EncodeStrategy.ENCODE_HEX);
	}
	/**
	* @Title: getSign
	* @Description: TODO(获取签名)
	* @param taskId
	* @param id
	* @param timestamp
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午4:31:31
	 */
	private String getSign(Integer taskId, Integer id, Long timestamp) {
		StringBuffer sb = new StringBuffer("task")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("taskId=")
								.append(taskId)
								.append(":")
								.append("id=")
								.append(id)
								.append(":")
								.append("timestamp=")
								.append(timestamp);
		
		return Md5Util.encrypt(sb.toString(), EncodeStrategy.ENCODE_HEX);
	}
}
