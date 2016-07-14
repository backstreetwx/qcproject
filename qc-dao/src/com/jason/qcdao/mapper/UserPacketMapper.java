package com.jason.qcdao.mapper;

import com.jason.qcdao.domain.po.UserPacket;

/**
* @ClassName: PacketMapper
* @Description: TODO(红包实体数据库访问接口)
* @author jason.peng
* @date 2016年1月7日 上午9:46:42
 */
public interface UserPacketMapper {
	/**
	* @Title: saveUserPacket
	* @Description: TODO(保存红包记录)
	* @param userPacket
	* @author jason.peng
	* @date 2016年1月7日 上午10:31:21
	 */
	public void saveUserPacket(UserPacket userPacket);

}
