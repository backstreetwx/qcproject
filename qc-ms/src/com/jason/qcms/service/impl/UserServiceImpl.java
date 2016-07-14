package com.jason.qcms.service.impl;

import org.springframework.stereotype.Service;

import com.jason.qcms.dao.base.BaseDaoSupport;
import com.jason.qcms.domain.po.SysUser;
import com.jason.qcms.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoSupport implements UserService {

	@Override
	public SysUser getSysUserByUsername(String username) {
		return sysUserMapper.getSysUserByUsername(username);
	}

}
