package com.jason.qccore.base;

import java.io.Serializable;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.jason.qccore.service.OrderService;
import com.jason.qccore.service.TaskService;
import com.jason.qccore.service.UserService;
import com.jason.qccore.service.SystemService;
/**
* @ClassName: BaseServiceSupport
* @Description: TODO(业务逻辑的基本，提供一些基本的业务所需的对象，包括数据库访问接口对象)
* @author jason.peng
* @date 2016年1月6日 上午10:57:00
 */
public abstract class BaseServiceSupport {
	
	protected Logger logger = LoggerFactory.getLogger(BaseServiceSupport.class);
	
	//-----------------------------
    // redis缓存数据库
	@Resource(name="otherCache")
	protected RedisTemplate<Serializable, ? super Serializable> otherCache;
	
	@Resource(name="userCache")
	protected RedisTemplate<Serializable, ? super Serializable> userCache;
	
	@Resource(name="codeCache")
	protected RedisTemplate<Serializable, ? super Serializable> codeCache;
	
	@Resource(name="ipCache")
	protected RedisTemplate<Serializable, ? super Serializable> ipCache;
	
	@Resource(name="fingerCache")
	protected RedisTemplate<Serializable, ? super Serializable> fingerCache;
	
	//-----------------------------
    // 业务逻辑接口实现类
	@Autowired
	protected UserService userService;
	@Autowired
	protected SystemService systemService;
	@Autowired
	protected OrderService orderService;
	@Autowired
	protected TaskService taskService;
	
}
