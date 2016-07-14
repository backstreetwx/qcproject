package com.jason.qccms.dao.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.jason.qccms.dao.mapper.SysUserMapper;
import com.jason.qccms.dao.mapper.SysUserTaskMapper;
import com.jason.qccms.dao.mapper.TaskContentMapper;
import com.jason.qccms.dao.mapper.TaskMapper;

public abstract class BaseDaoSupport {

	@Autowired
	protected SysUserMapper sysUserMapper;
	@Autowired
	protected TaskMapper taskMapper;
	@Autowired
	protected SysUserTaskMapper sysUserTaskMapper;
	@Autowired
	protected TaskContentMapper taskContentMapper;
}
