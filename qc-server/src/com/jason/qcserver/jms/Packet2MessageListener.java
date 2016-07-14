package com.jason.qcserver.jms;

import org.springframework.stereotype.Component;

import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserPacket2;
import com.jason.qcserver.base.BaseServiceSupport;
/**
* @ClassName: Packet2MessageListener
* @Description: TODO(红包消息监听，处理用户抢红包的请求)
* @author jason.peng
* @date 2016年3月15日 上午8:24:04
 */
@Component
public class Packet2MessageListener extends BaseServiceSupport {

	public void handleMessage(UserPacket2 userPacket2) {
		// 去除重复订单
		if(userPacket2Mapper.isExistUserPacket2ByOrderId(userPacket2.getOrderId()) == 1) {
			logger.info("find a repeat user packet2, user packet2 info is {}", userPacket2);
			return ;
		}
		// 更新用户积分作为抢红包
		userAccountMapper.updatePointForUserPacket2(userPacket2.getHashId(), userPacket2.getPoint());
		// 保存用户明细
		UserDetail userDetail = new UserDetail();
		userDetail.setHashId(userPacket2.getHashId());
		userDetail.setType(UserDetail.PACKET_2_TYPE);
		userDetail.setIcon(UserDetail.PACKET_ICON);
		userDetail.setTitle("抢红包");
		userDetail.setPoint(userPacket2.getPoint());
		userDetail.setCreateTime(userPacket2.getCreateTime());
		userDetailMapper.saveUserDetail(userDetail);
		// 保存用户红包记录
		userPacket2Mapper.saveUserPacket2(userPacket2);
		// 更新今日收益
		userTmpMapper.updateUserTmpForPacket(userPacket2.getHashId(),  userPacket2.getPoint());
		
		logger.info("用户抢红包成功：{}", userPacket2);
	}
}
