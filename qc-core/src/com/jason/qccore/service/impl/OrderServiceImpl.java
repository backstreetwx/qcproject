package com.jason.qccore.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.jason.qccore.service.OrderService;
import com.jason.qcdao.domain.po.Goods;
import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserOrder;
import com.jason.qcdao.domain.po.UserOrder2;
import com.jason.qcdao.domain.vo.DuiBaNotice;
import com.jason.qcdao.domain.vo.GoodsItem;
import com.jason.qcdao.domain.vo.OrderItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.UserOrder2Item;
import com.jason.qcdao.domain.vo.UserOrderItem;
/**
* @ClassName: OrderServiceImpl
* @Description: TODO(订单业务逻辑接口实现类)
* @author jason.peng
* @date 2016年1月7日 下午2:41:48
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

	@Override
	public Page<GoodsItem> getGoodsPage(Integer index, Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		List<GoodsItem> items = goodsMapper.getGoodses(start, len);
		return new Page<GoodsItem>(size, items);
	}

	@Override
	public Goods getGoods(Integer id) {
		return goodsMapper.getGoods(id);
	}

	@Override
	public void doExchange(UserOrder userOrder) {
		JmsTemplate.convertAndSend(orderDestination, userOrder);
	}

	@Override
	public Page<UserOrderItem> getUserOrderPage(String hashId, Integer index,
			Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		List<UserOrderItem> items = userOrderMapper.getUserOrders(hashId, start, len);
		return new Page<UserOrderItem>(size, items);
	}

	@Override
	public void updateGoodsForExchange(Integer id) {
		goodsMapper.updateGoodsForExchange(id);
	}

	@Override
	public void doNotice(DuiBaNotice duiBaNotice) {
		String[] arr = StringUtils.split(duiBaNotice.getBizId(), "::");
		if(arr == null || arr.length != 2) {
			logger.error("doNotice is error, duiBaNotice is {}", duiBaNotice);
			return ;
		}
		String hashId = userMapper.getHashId(Integer.parseInt(arr[0]));
		if(duiBaNotice.getSuccess()) { // 成功
			userOrderMapper.updateStatus(arr[1], UserOrder.PROCESSED_STATUS);
		} else {
			userOrderMapper.updateStatus(arr[1], UserOrder.EXCEPTION_STATUS);
			// 返还积分
			Integer point = userOrderMapper.getPoint(arr[1]);
			userAccountMapper.updatePointForUserOrder2(hashId, point);
			// 创建明细
			UserDetail userDetail = new UserDetail();
			userDetail.setHashId(hashId);
			userDetail.setType(UserDetail.USER_ORDER_ERROR_TYPE);
			userDetail.setIcon(UserDetail.USER_ORDER_ICON);
			userDetail.setTitle("兑换失败");
			userDetail.setPoint(point);
			userDetail.setCreateTime(new Date());
			userDetailMapper.saveUserDetail(userDetail);
		}
	}

	@Override
	public void doExchange2(UserOrder2 userOrder2) {
		JmsTemplate.convertAndSend(order2Destination, userOrder2);
	}

	@Override
	public List<OrderItem> getOrderList() {
		return orderMapper.getOrderList();
	}

	@Override
	public Page<UserOrder2Item> getUserOrder2Page(String hashId, Integer index,
			Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		List<UserOrder2Item> items = userOrder2Mapper.getUserOrder2s(hashId, start, len);
		return new Page<UserOrder2Item>(size, items);
	}

}
