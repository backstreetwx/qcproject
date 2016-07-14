package com.jason.qcms.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.jason.qcms.service.TaskService;
import com.jason.qcms.service.UserService;

/**
* @ClassName: BaseServiceSupport
* @Description: TODO(基本的业务支持，提供基本的业务接口)
* @author jason.peng
* @date 2016年2月27日 上午8:30:49
 */
public abstract class BaseServiceSupport {

	@Autowired
	protected UserService userService;
	@Autowired
	protected TaskService taskService;
}
