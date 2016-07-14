package com.jason.qccms.service;

import com.jason.qccms.domain.po.SysUser;

public interface UserService {
	/**
	* @Title: getSysUserByUsername
	* @Description: TODO(通过用户名获取用户)
	* @param username
	* @return
	* @author jason.peng
	* @date 2016年3月8日 下午2:03:00
	 */
	public SysUser getSysUserByUsername(String username);

}
