package com.jason.qccms.service.impl;

import org.springframework.stereotype.Service;

import com.jason.qccms.dao.base.BaseDaoSupport;
import com.jason.qccms.domain.po.SysUser;
import com.jason.qccms.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoSupport implements UserService{

	@Override
	public SysUser getSysUserByUsername(String username) {
		return sysUserMapper.getSysUserByUsername(username);
	}

}
