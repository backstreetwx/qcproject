package com.jason.qccms.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.jason.qccms.service.TaskService;
import com.jason.qccms.service.UserService;

public abstract class BaseServiceSupport {

	@Autowired
	protected UserService userService;
	@Autowired
	protected TaskService taskService;
}
