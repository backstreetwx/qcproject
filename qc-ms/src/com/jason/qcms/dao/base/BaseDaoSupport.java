package com.jason.qcms.dao.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.jason.qcms.dao.mapper.SysUserMapper;
import com.jason.qcms.dao.mapper.TaskContentMapper;
import com.jason.qcms.dao.mapper.TaskMapper;

/**
* @ClassName: BaseDaoSupport
* @Description: TODO(基本的数据库访问支持，提供基本的数据库访问接口)
* @author jason.peng
* @date 2016年2月27日 上午8:31:13
 */
public abstract class BaseDaoSupport {

	@Autowired
	protected SysUserMapper sysUserMapper;
	@Autowired
	protected TaskMapper taskMapper;
	@Autowired
	protected TaskContentMapper taskContentMapper;
}
