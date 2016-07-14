package com.jason.qccore.service;

import java.util.List;

import com.jason.qcdao.domain.po.Goods;
import com.jason.qcdao.domain.po.UserOrder;
import com.jason.qcdao.domain.po.UserOrder2;
import com.jason.qcdao.domain.vo.DuiBaNotice;
import com.jason.qcdao.domain.vo.GoodsItem;
import com.jason.qcdao.domain.vo.OrderItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.UserOrder2Item;
import com.jason.qcdao.domain.vo.UserOrderItem;

/**
* @ClassName: OrderService
* @Description: TODO(订单业务逻辑接口)
* @author jason.peng
* @date 2016年1月7日 下午2:41:20
 */
public interface OrderService {
	/**
	* @Title: getGoodsPage
	* @Description: TODO(获取商品列表)
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午2:52:53
	 */
	public Page<GoodsItem> getGoodsPage(Integer index, Integer size);
	/**
	* @Title: getGoods
	* @Description: TODO(获取商品)
	* @param id
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午5:02:27
	 */
	public Goods getGoods(Integer id);
	/**
	* @Title: doExchange
	* @Description: TODO(兑换商品)
	* @param userOrder
	* @author jason.peng
	* @date 2016年1月7日 下午5:23:22
	 */
	public void doExchange(UserOrder userOrder);
	/**
	* @Title: getUserOrderPage
	* @Description: TODO(获取用户订单列表)
	* @param hashId
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午5:27:23
	 */
	public Page<UserOrderItem> getUserOrderPage(String hashId, Integer index,
			Integer size);
	/**
	* @Title: updateGoodsForExchange
	* @Description: TODO(更新商品作为兑换)
	* @author jason.peng
	* @date 2016年1月7日 下午5:50:19
	 */
	public void updateGoodsForExchange(Integer id);
	/**
	* @Title: doNotice
	* @Description: TODO(处理兑吧通知)
	* @param duiBaNotice
	* @author jason.peng
	* @date 2016年2月19日 上午10:51:10
	 */
	public void doNotice(DuiBaNotice duiBaNotice);
	/**
	* @Title: doExchange2
	* @Description: TODO(处理兑换)
	* @param userOrder2
	* @author jason.peng
	* @date 2016年3月17日 下午2:08:54
	 */
	public void doExchange2(UserOrder2 userOrder2);
	/**
	* @Title: getOrderList
	* @Description: TODO(获取订单列表)
	* @return
	* @author jason.peng
	* @date 2016年3月18日 下午1:38:49
	 */
	public List<OrderItem> getOrderList();
	/**
	* @Title: getUserOrder2Page
	* @Description: TODO(获取用户订单)
	* @param hashId
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年3月18日 下午1:44:34
	 */
	public Page<UserOrder2Item> getUserOrder2Page(String hashId, Integer index,
			Integer size);
}
