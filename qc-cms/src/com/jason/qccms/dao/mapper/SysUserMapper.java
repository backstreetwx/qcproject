package com.jason.qccms.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.jason.qccms.domain.po.SysUser;

public interface SysUserMapper {
	/**
	 * 
	* @Title: getSysUserByUsername
	* @Description: TODO(通过用户名获取用户)
	* @param username
	* @return
	* @author jason.peng
	* @date 2016年3月8日 下午2:03:46
	 */
	public SysUser getSysUserByUsername(@Param("username")String username);

}
