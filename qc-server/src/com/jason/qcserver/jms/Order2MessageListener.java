package com.jason.qcserver.jms;

import org.springframework.stereotype.Component;

import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserOrder2;
import com.jason.qcserver.base.BaseServiceSupport;
/**
* @ClassName: OrderMessageListener
* @Description: TODO(用户订单监听，主要是用户的兑换监听)
* @author jason.peng
* @date 2016年1月7日 下午5:34:16
 */
@Component
public class Order2MessageListener extends BaseServiceSupport{

	public void handleMessage(UserOrder2 userOrder2) {
		// 去除重复订单
		if(userOrder2Mapper.isExistUserOrder2ByOrderId(userOrder2.getOrderId()) == 1) {
			logger.info("find a repeat user order, user order info is {}", userOrder2);
			return ;
		}
		// 更新用户账号信息
		userAccountMapper.updatePointForUserOrder(userOrder2.getHashId(), userOrder2.getPoint());
		// 保存用户明细
		UserDetail userDetail = new UserDetail();
		userDetail.setHashId(userOrder2.getHashId());
		userDetail.setType(UserDetail.USER_ORDER_TYPE);
		userDetail.setIcon(userOrder2.getIcon());
		userDetail.setTitle(userOrder2.getTitle());
		userDetail.setPoint(-userOrder2.getPoint());
		userDetail.setCreateTime(userOrder2.getCreateTime());
		userDetailMapper.saveUserDetail(userDetail);
		// 保存用户订单
		userOrder2Mapper.saveUserOrder(userOrder2);
		
		logger.info("2-创建用户订单成功：{}", userOrder2);
	}
	
}
