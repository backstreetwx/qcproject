package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserOrder2;
import com.jason.qcdao.domain.vo.UserOrder2Item;

/**
* @ClassName: UserOrder2Mapper
* @Description: TODO(用户订单数据库访问接口)
* @author jason.peng
* @date 2016年3月17日 下午1:44:52
 */
public interface UserOrder2Mapper {
	/**
	* @Title: isExistUserOrder2ByOrderId
	* @Description: TODO(判断订单是否存在 )
	* @param orderId
	* @return
	* @author jason.peng
	* @date 2016年3月17日 下午2:20:27
	 */
	public Integer isExistUserOrder2ByOrderId(@Param("orderId")String orderId);
	/**
	* @Title: saveUserOrder
	* @Description: TODO(保存用户订单)
	* @param userOrder2
	* @author jason.peng
	* @date 2016年3月17日 下午2:20:38
	 */
	public void saveUserOrder(UserOrder2 userOrder2);
	/**
	* @Title: getUserOrder2s
	* @Description: TODO(获取用户订单)
	* @param hashId
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年3月18日 下午1:50:32
	 */
	public List<UserOrder2Item> getUserOrder2s(@Param("hashId")String hashId, @Param("start")Integer start,
			@Param("len")Integer len);

}
