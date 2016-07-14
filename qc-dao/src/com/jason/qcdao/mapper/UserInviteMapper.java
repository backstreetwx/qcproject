package com.jason.qcdao.mapper;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserInvite;

/**
* @ClassName: UserInviteMapper
* @Description: TODO(用户邀请记录数据库访问接口)
* @author jason.peng
* @date 2016年1月7日 上午9:04:01
 */
public interface UserInviteMapper {
	/**
	* @Title: saveUserInvite
	* @Description: TODO(保存邀请记录)
	* @param userInvite
	* @author jason.peng
	* @date 2016年1月7日 上午9:16:34
	 */
	public void saveUserInvite(UserInvite userInvite);
	/**
	* @Title: getUserInvite
	* @Description: TODO(获取用的邀请记录)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年3月23日 下午3:20:18
	 */
	public UserInvite getUserInvite(@Param("hashId")String hashId);

}
