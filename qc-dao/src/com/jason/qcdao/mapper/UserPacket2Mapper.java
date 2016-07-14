package com.jason.qcdao.mapper;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserPacket2;

/**
* @ClassName: UserPacket2Mapper
* @Description: TODO(红包实体数据库访问接口)
* @author jason.peng
* @date 2016年3月15日 上午7:59:18
 */
public interface UserPacket2Mapper {
	/**
	* @Title: isExistUserPacket2ByOrderId
	* @Description: TODO(是否存在用户抢红包记录)
	* @param orderId
	* @return
	* @author jason.peng
	* @date 2016年3月15日 上午8:26:18
	 */
	public Integer isExistUserPacket2ByOrderId(@Param("orderId")String orderId);
	/**
	* @Title: saveUserPacket2
	* @Description: TODO(保存用户红包记录)
	* @param userPacket2
	* @author jason.peng
	* @date 2016年3月15日 上午8:38:01
	 */
	public void saveUserPacket2(UserPacket2 userPacket2);

}
