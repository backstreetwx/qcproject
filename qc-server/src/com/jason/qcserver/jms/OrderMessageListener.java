package com.jason.qcserver.jms;

import org.springframework.stereotype.Component;

import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserOrder;
import com.jason.qcserver.base.BaseServiceSupport;
/**
* @ClassName: OrderMessageListener
* @Description: TODO(用户订单监听，主要是用户的兑换监听)
* @author jason.peng
* @date 2016年1月7日 下午5:34:16
 */
@Component
public class OrderMessageListener extends BaseServiceSupport{

	public void handleMessage(UserOrder userOrder) {
		// 去除重复订单
		if(userOrderMapper.isExistUserOrderByOrderId(userOrder.getOrderId()) == 1) {
			logger.info("find a repeat user order, user order info is {}", userOrder);
			return ;
		}
		// 更新用户账号信息
		userAccountMapper.updatePointForUserOrder(userOrder.getHashId(), userOrder.getPoint());
		// 保存用户明细
		UserDetail userDetail = new UserDetail();
		userDetail.setHashId(userOrder.getHashId());
		userDetail.setType(UserDetail.USER_ORDER_TYPE);
		userDetail.setIcon(UserDetail.USER_ORDER_ICON);
		userDetail.setTitle(userOrder.getTitle());
		userDetail.setPoint(-userOrder.getPoint());
		userDetail.setCreateTime(userOrder.getCreateTime());
		userDetailMapper.saveUserDetail(userDetail);
		// 保存用户订单
		userOrderMapper.saveUserOrder(userOrder);
		
		logger.info("1-创建用户订单成功：{}", userOrder);
	}
}
