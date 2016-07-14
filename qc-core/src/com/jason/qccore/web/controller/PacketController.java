package com.jason.qccore.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.utils.DateUtil;
import com.jason.qccore.utils.Md5Util;
import com.jason.qccore.utils.Md5Util.EncodeStrategy;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.co.SystemConstant;
import com.jason.qcdao.domain.po.UserPacket2;
import com.jason.qcdao.domain.vo.PacketInfo;
import com.jason.qcdao.domain.vo.PacketItem;

@Controller 
@RequestMapping("/public/packet")
public class PacketController extends BaseServiceSupport{

	@ResponseBody
	@RequestMapping(value="/status", method=RequestMethod.GET)
	public Result status(@CookieValue("hashId")String hashId,String sign, Long timestamp) {
		// 校验参数正确性
		if(StringUtils.isBlank(sign)) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		if(timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		// 校验签名
		StringBuffer sb = new StringBuffer("packetStatus")
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
		
		// 校验时间合法性
		Date current = new Date();
		if(current.getTime() - timestamp > 7200000) {
			return new DataResult<>(DataResult.CODE_SYSTEM_TIME_ERROR, "系统繁忙，请稍后在试");
		}
		
		Integer[] times = {12, 17, 20};
		// 判断是否在抢红包时间
		if(DateUtil.timeScope("12:00:00", "12:10:00", current) ||
				   DateUtil.timeScope("17:00:00", "17:10:00", current) || 
				   DateUtil.timeScope("20:00:00", "20:10:00", current)){
			// 判断用户是否抢过红包
			return new DataResult<>(DataResult.CODE_PACKET_TIME_YES, null, times);
		}
		
		return new DataResult<>(DataResult.CODE_PACKET_TIME_NO, null, times);
	}
	
	@ResponseBody
	@RequestMapping(value="/pick", method=RequestMethod.GET)
	public Result pick(@CookieValue("hashId")String hashId,String sign, Long timestamp) {
		// 校验参数正确性
		if(StringUtils.isBlank(sign)) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		if(timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		// 校验签名
		StringBuffer sb = new StringBuffer("packetPick")
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
		
		// 校验时间合法性
		Date current = new Date();
		if(current.getTime() - timestamp > 7200000) {
			return new DataResult<>(DataResult.CODE_SYSTEM_TIME_ERROR, "非法请求");
		}
		
		// 判断是否在抢红包时间
		if(DateUtil.timeScope("12:00:00", "12:10:00", current) ||
				   DateUtil.timeScope("17:00:00", "17:10:00", current) || 
				   DateUtil.timeScope("20:00:00", "20:10:00", current)){
			
			// 判断用户是否抢过红包
			if(otherCache.opsForSet().isMember("packet2", hashId)) {
				return new DataResult<>(DataResult.CODE_PACKET_YES, "抢过红包了");
			} else {
				// 记录用户抢过红包了
				otherCache.opsForSet().add("packet2", new String[]{hashId });
				// 获取积分
				Integer point = getPacketPoint(hashId);
				// -----------------------------------
				// 去抢红包
				UserPacket2 userPacket2 = new UserPacket2();
				userPacket2.setHashId(hashId);
				String orderId = getOrderId(hashId, current);
				userPacket2.setOrderId(orderId);
				userPacket2.setPoint(point);
				userPacket2.setCreateTime(current);
				userService.doPacket(userPacket2);
				
				// 获取红包总个数
				Integer totalCount = (Integer) otherCache.opsForValue().get("packet-totalCount");
				// 获取红包总积分
				Integer totalPoint = (Integer) otherCache.opsForValue().get("packet-totalPoint");
				// 获取红包列表
				Set<? super Serializable> items = otherCache.opsForZSet().range("packet-packetItem", 0, PacketItem.DEFAULT_SIZE);
				List<PacketItem> packetItems = new ArrayList<PacketItem>();
				for (Object obj : items) {
					packetItems.add((PacketItem) obj);
				}
				Collections.sort(packetItems, new Comparator<PacketItem>() {
					@Override
					public int compare(PacketItem o1, PacketItem o2) {
						return o2.getPickTime().compareTo(o1.getPickTime());
					}
				});
				// 设置返回信息
				PacketInfo packetInfo = new PacketInfo();
				packetInfo.setPoint(point);
				packetInfo.setTotalCount(totalCount);
				packetInfo.setTotalPoint(totalPoint);
				packetInfo.setPacketItems(packetItems);
				return new DataResult<>(DataResult.CODE_SUCCESS, null, packetInfo);
			}
		}
		
		return new DataResult<>(DataResult.CODE_PACKET_TIME_NO, "还没到抢红包的时间");
	}
	/**
	* @Title: getPacketPoint
	* @Description: TODO(获取用户抢红包的积分)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年3月14日 下午2:35:45
	 */
	private Integer getPacketPoint(String  hashId) {
		// 获取用户抢红包的次数
		Random random = new Random();
		Integer packet2Count = userService.getPacket2Count(hashId);
		if(packet2Count == 0) { // 6.6
			return 666;
		} else if(packet2Count == 1) { //0.5-3.0  
			return random.nextInt(251) + 50;
		} else if(packet2Count == 2) { // 0.1-1.0
			return random.nextInt(91) + 10;
		} else if(packet2Count == 3) { // 2.0-3.0
			return random.nextInt(101) + 200;
		} else if(packet2Count == 4) { // 0.1-1.0
			return random.nextInt(91) + 10;
		} else if(packet2Count == 5) { // 1.0-2.0
			return random.nextInt(101) + 100;
		} else if(packet2Count == 6) { // 2.0-3.0
			return random.nextInt(101) + 200;
		} else if(packet2Count == 7) { // 1.0-2.0；
			return random.nextInt(101) + 100;
		} else if(packet2Count == 8) { // 0.01-0.5
			return random.nextInt(51) + 1;
		} else if(packet2Count == 9) { // 1.0-5.0
			return random.nextInt(401) + 100;
		} else { // 0.01-0.5（80%），0.5-1.0（20%）从此以后
			if(random.nextInt(100) < 80) {
				return random.nextInt(51) + 1;
			} else {
				return random.nextInt(51) + 50;
			}
		}
	}
	/**
	* @Title: getOrderId
	* @Description: TODO(获取订单ID)
	* @param hashId
	* @param current
	* @return
	* @author jason.peng
	* @date 2016年3月15日 上午8:06:46
	 */
	private String getOrderId(String hashId, Date current) {
		String timestamp = DateUtil.DateToString(current, "yyyy-MM-dd HH");
		String [] arr = {SystemConstant.SYS_KEY, SystemConstant.SYS_SECRET, hashId, timestamp};
		String str = StringUtils.join(arr, SystemConstant.SEPARATOR);
		return Md5Util.encrypt(str, EncodeStrategy.ENCODE_HEX);
	}
	
}
