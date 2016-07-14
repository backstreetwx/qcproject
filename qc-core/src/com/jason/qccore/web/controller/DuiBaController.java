package com.jason.qccore.web.controller;

import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.utils.DuibaUtil;
import com.jason.qccore.utils.Md5Util;
import com.jason.qccore.utils.Md5Util.EncodeStrategy;
import com.jason.qcdao.domain.po.UserAccount;
import com.jason.qcdao.domain.po.UserOrder;
import com.jason.qcdao.domain.vo.DuiBaDeducted;
import com.jason.qcdao.domain.vo.DuiBaNotice;


@Controller 
@RequestMapping("/public/duiba")
public class DuiBaController extends BaseServiceSupport{

	@ResponseBody
	@RequestMapping(value="/deducted", method=RequestMethod.GET)
	public String deducted(HttpServletRequest request) {
		DuiBaDeducted duiBaDeducted = DuibaUtil.getDuiBaDeducted(request);
		if(duiBaDeducted == null) {
			return DuibaUtil.getFailed("非法请求");
		}
		
		logger.info(duiBaDeducted.toString());
		try {
			Integer id = Integer.parseInt(duiBaDeducted.getUid());
			String hashId = userService.getHashIdById(id);
			if(StringUtils.isEmpty(hashId)) {
				return DuibaUtil.getFailed("非法请求");
			}
			
			// 获取用户积分信息
			Integer mayPoint = userService.getMayPoint(hashId);
			Integer point = (int) (duiBaDeducted.getCredits() * UserAccount.RATE);
			if(mayPoint < point) {
				return DuibaUtil.getFailed("余额不足");
			}
			
			String[] arr = {"duiba", hashId, duiBaDeducted.getOrderNum()};
			String md5 = Md5Util.encrypt(StringUtils.join(arr, "::"), EncodeStrategy.ENCODE_HEX);
			//将兑换信息提交到队列
			UserOrder userOrder = new UserOrder();
			userOrder.setHashId(hashId);
			userOrder.setOrderId(md5); // md5作为订单ID
			userOrder.setType("alipay(支付宝)");
			userOrder.setIcon("http://7xo77v.com2.z0.glb.qiniucdn.com/spread_icon_icon180.png");
			try {
				userOrder.setTitle(URLDecoder.decode(duiBaDeducted.getDescription(), "UTF-8"));
			} catch (Exception e) {
				userOrder.setTitle("兑吧兑换商品");
			}
			userOrder.setParams(duiBaDeducted.getParams());
			userOrder.setPoint(point);
			userOrder.setCreateTime(new Date());
			
			orderService.doExchange(userOrder);
			
			return DuibaUtil.getSuccess(StringUtils.join(new String[]{id + "", md5}, "::"));
		} catch (NumberFormatException e) {
			
		}
		return DuibaUtil.getFailed("非法请求");
	}
	
	@ResponseBody
	@RequestMapping(value="/notice", method=RequestMethod.GET)
	public String notice(HttpServletRequest request) {
		DuiBaNotice duiBaNotice = DuibaUtil.getDuiBaNotice(request);
		if(duiBaNotice == null) {
			return "fail";
		}
		logger.info(duiBaNotice.toString());
		// 处理通知
		orderService.doNotice(duiBaNotice);
		return "ok";
	}
}
