package com.jason.qcms.service;

import com.jason.qcms.domain.po.SysUser;

/**
* @ClassName: UserService
* @Description: TODO(用户业务接口)
* @author jason.peng
* @date 2016年2月28日 上午7:45:00
*
 */
public interface UserService {
	/**
	* @Title: getUserByUsername
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param username
	* @return
	* @author jason.peng
	* @date 2016年2月28日 上午8:00:52
	 */
	public SysUser getSysUserByUsername(String username);

}
