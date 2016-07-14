package com.jason.qcms.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.jason.qcms.domain.po.SysUser;

/**
* @ClassName: SysUserMapper
* @Description: TODO(系统用户数据库访问接口)
* @author jason.peng
* @date 2016年2月28日 上午8:13:13
 */
public interface SysUserMapper {
	/**
	* @Title: getSysUserByUsername
	* @Description: TODO(通过用户名获取用户)
	* @param username
	* @return
	* @author jason.peng
	* @date 2016年2月28日 上午8:16:33
	 */
	public SysUser getSysUserByUsername(@Param("username")String username);

}
