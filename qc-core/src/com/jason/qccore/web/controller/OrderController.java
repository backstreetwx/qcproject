package com.jason.qccore.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.utils.DuibaUtil;
import com.jason.qccore.utils.Md5Util;
import com.jason.qccore.utils.Md5Util.EncodeStrategy;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.co.SystemConstant;
import com.jason.qcdao.domain.po.Goods;
import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.po.UserAccount;
import com.jason.qcdao.domain.po.UserOrder;
import com.jason.qcdao.domain.po.UserOrder2;
import com.jason.qcdao.domain.vo.GoodsItem;
import com.jason.qcdao.domain.vo.OrderItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.UserOrder2Item;
import com.jason.qcdao.domain.vo.UserOrderItem;
/**
* @ClassName: OrderController
* @Description: TODO(兑换商城控制器)
* @author jason.peng
* @date 2016年1月8日 上午10:54:45
 */
@Controller 
@RequestMapping("/public/order")
public class OrderController extends BaseServiceSupport{
	
	@ResponseBody
	@RequestMapping(value="/url", method=RequestMethod.GET)
	public Result url(@CookieValue("hashId")String hashId) {
		User user = userService.getUserByHashId(hashId);
		Integer mayPoint = userService.getMayPoint(hashId);
		String url = DuibaUtil.getUrl(user.getId() + "", (mayPoint / UserAccount.RATE) + "" , null);
		DataResult<String> result = new DataResult<String>();
		result.setData(url);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}

	@ResponseBody
	@RequestMapping(value="/goods", method=RequestMethod.GET)
	public Result goods(Integer index, Integer size) {
		index = index == null || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		Page<GoodsItem> page = orderService.getGoodsPage(index, size);
		DataResult<Page<GoodsItem>> result = new DataResult<Page<GoodsItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/exchange", method=RequestMethod.POST)
	public Result exchange(@CookieValue("hashId")String hashId, String params, 
			Integer id, String sign, Long timestamp) {
		if(StringUtils.isBlank(params) 
				|| id == null
				|| StringUtils.isBlank(sign)
				|| timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		// 1.校验签名
		StringBuffer sb = new StringBuffer("order")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("hashId=")
								.append(hashId)
								.append(":")
								.append("params=")
								.append(params)
								.append(":")
								.append("id=")
								.append(id)
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
		
		Goods goods = null;
		synchronized (this) {
			goods = orderService.getGoods(id);
			if(goods == null
					|| Goods.DOWN_STATUS.equals(goods.getStatus())
					|| goods.getNumber() <= 0) {
				return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
			}
			// 获取用户积分信息
			Integer mayPoint = userService.getMayPoint(hashId);
			if(mayPoint < goods.getPoint()) {
				return new DataResult<>(DataResult.USER_POINT_NOT_ENOUGH, "余额不足");
			}
			
			orderService.updateGoodsForExchange(id);
		}
		
		
		//将兑换信息提交到队列
		UserOrder userOrder = new UserOrder();
		userOrder.setHashId(hashId);
		userOrder.setOrderId(md5); // md5作为订单ID
		userOrder.setType("alipay(支付宝)");
		userOrder.setIcon(goods.getIcon());
		userOrder.setTitle(goods.getTitle());
		userOrder.setParams(params);
		userOrder.setPoint(goods.getPoint());
		userOrder.setCreateTime(new Date());
		
		orderService.doExchange(userOrder);
		return new DataResult<>(DataResult.CODE_SUCCESS, "提交成功 2-5个工作日到账！");
	}
	
	
	@ResponseBody
	@RequestMapping(value="/record", method=RequestMethod.GET)
	public Result record(@CookieValue("hashId")String hashId, Integer index, Integer size) {
		index = index == null || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		Page<UserOrderItem> page = orderService.getUserOrderPage(hashId, index, size);
		DataResult<Page<UserOrderItem>> result = new DataResult<Page<UserOrderItem>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value="/question", method=RequestMethod.GET)
	public String question() {
		return "order_question";
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Result list() {
		List<OrderItem> orderItems = orderService.getOrderList();
		DataResult<List<OrderItem>> result = new DataResult<List<OrderItem>>();
		result.setData(orderItems);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/record2", method=RequestMethod.GET)
	public Result record2(@CookieValue("hashId")String hashId, Integer index, Integer size) {
		index = index == null || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		Page<UserOrder2Item> page = orderService.getUserOrder2Page(hashId, index, size);
		DataResult<Page<UserOrder2Item>> result = new DataResult<Page<UserOrder2Item>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/exchange2", method=RequestMethod.POST)
	public Result exchange2(@CookieValue("hashId")String hashId, Integer type, 
			Integer point, String params, String sign, Long timestamp) {
		if(type == null 
				|| type > 2 
				|| type < 1 
				|| point == null 
				|| StringUtils.isBlank(params) 
				|| StringUtils.isBlank(sign)
				|| timestamp == null) {
			return new DataResult<>(DataResult.CODE_FAILED, "非法请求");
		}
		
		// 1.校验签名
		StringBuffer sb = new StringBuffer("order2")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("hashId=")
								.append(hashId)
								.append(":")
								.append("type=")
								.append(type)
								.append(":")
								.append("point=")
								.append(point)
								.append(":")
								.append("params=")
								.append(params)
								.append(":")
								.append("timestamp=")
								.append(timestamp);
		String md5 = Md5Util.encrypt(sb.toString(), EncodeStrategy.ENCODE_HEX);
		if(!md5.equals(sign)) {
			return new DataResult<>(DataResult.CODE_FAILED, "签名错误");
		}
		
		// 时间校验
		Date current = new Date();
		if(current.getTime() - timestamp > 7200000) {
			return new DataResult<>(DataResult.CODE_SYSTEM_TIME_ERROR, "系统繁忙，请稍后在试");
		}
		
		Integer mayPoint = userService.getMayPoint(hashId);
		if(mayPoint < point) {
			return new DataResult<>(DataResult.USER_POINT_NOT_ENOUGH, "余额不足");
		}
		
		String orderId = getOrderId(hashId, type, point, params, timestamp);
		
		UserOrder2 userOrder2 = new UserOrder2();
		userOrder2.setOrderId(orderId);
		userOrder2.setHashId(hashId);
		userOrder2.setType(type);
		userOrder2.setIcon(getOrderIcon(type));
		userOrder2.setTitle(getOrderTitle(type));
		userOrder2.setPoint(point);
		userOrder2.setParams(params);
		userOrder2.setCreateTime(new Date());
		
		orderService.doExchange2(userOrder2);
		return new DataResult<>(DataResult.CODE_SUCCESS, "提交成功 2-5个工作日到账！");
	}
	
	/**
	* @Title: getOrderIcon
	* @Description: TODO(获取订单图标)
	* @param type
	* @return
	* @author jason.peng
	* @date 2016年3月18日 下午1:46:29
	 */
	private String getOrderIcon(Integer type) {
		String icon = null;
		switch (type) {
		case UserOrder2.TYPE_ALIPAY:
			icon = "http://7xo77v.com2.z0.glb.qiniucdn.com/spread_icon_icon_alipay.PNG";
			break;
		case UserOrder2.TYPE_PHONE:
			icon = "http://7xo77v.com2.z0.glb.qiniucdn.com/spread_icon_icon_phone.PNG";
			break;
		default:
			break;
		}
		return icon;
	}
	
	/**
	* @Title: getOrderTitle
	* @Description: TODO(获取订单的标题)
	* @param type
	* @return
	* @author jason.peng
	* @date 2016年3月18日 下午1:47:01
	 */
	private String getOrderTitle(Integer type) {
		String title = null;
		switch (type) {
		case UserOrder2.TYPE_ALIPAY:
			title = "支付宝提现";
			break;
		case UserOrder2.TYPE_PHONE:
			title = "话费充值";
			break;
		default:
			break;
		}
		return title;
	}
	
	/**
	* @Title: getOrderId
	* @Description: TODO(获取订单ID)
	* @return
	* @author jason.peng
	* @date 2016年3月17日 下午2:10:36
	 */
	private String getOrderId(String hashId, Integer type, 
			Integer pointType, String params, Long timestamp) {
		String[] arr = {SystemConstant.SYS_KEY, SystemConstant.SYS_SECRET, hashId, type + "", pointType + "", params, timestamp + ""};
		String str = StringUtils.join(arr, SystemConstant.SEPARATOR);
		return Md5Util.encrypt(str, EncodeStrategy.ENCODE_HEX);
	}
}
