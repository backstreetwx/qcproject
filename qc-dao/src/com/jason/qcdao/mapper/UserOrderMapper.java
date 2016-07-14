package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserOrder;
import com.jason.qcdao.domain.vo.UserOrderItem;

/**
* @ClassName: UserOrderMapper
* @Description: TODO(用户订单数据库访问接口)
* @author jason.peng
* @date 2016年1月7日 下午2:37:46
 */
public interface UserOrderMapper {
	/**
	* @Title: getUserOrders
	* @Description: TODO(获取用户订单列表)
	* @param hashId
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午5:28:34
	 */
	public List<UserOrderItem> getUserOrders(@Param("hashId")String hashId, @Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: isExistUserOrderByOrderId
	* @Description: TODO(判断订单是否存在)
	* @return
	* @author jason.peng
	* @date 2016年1月8日 上午7:55:11
	 */
	public Integer isExistUserOrderByOrderId(@Param("orderId")String orderId);
	/**
	* @Title: saveUserOrder
	* @Description: TODO(保存用户订单)
	* @param userOrder
	* @author jason.peng
	* @date 2016年1月8日 上午7:56:53
	 */
	public void saveUserOrder(UserOrder userOrder);
	/**
	* @Title: updateStatus
	* @Description: TODO(更新订单状态)
	* @param hashId
	* @param processedStatus
	* @author jason.peng
	* @date 2016年2月19日 上午11:01:25
	 */
	public void updateStatus(@Param("orderId")String orderId, @Param("status")Integer status);
	/**
	* @Title: getPoint
	* @Description: TODO(获取订单积分)
	* @param string
	* @return
	* @author jason.peng
	* @date 2016年2月19日 上午11:03:42
	 */
	public Integer getPoint(@Param("hashId")String orderId);

}
