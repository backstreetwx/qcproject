package com.jason.qcdao.mapper;

import java.util.List;

import com.jason.qcdao.domain.vo.OrderItem;

/**
* @ClassName: OrderMapper
* @Description: TODO(订单数据库访问接口)
* @author jason.peng
* @date 2016年3月18日 上午10:00:36
*
 */
public interface OrderMapper {
	/**
	* @Title: getOrderList
	* @Description: TODO(获取订单列表)
	* @return
	* @author jason.peng
	* @date 2016年3月18日 上午10:08:35
	 */
	public List<OrderItem> getOrderList();

}
