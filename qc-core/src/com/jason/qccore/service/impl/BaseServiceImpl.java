package com.jason.qccore.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;

import com.jason.qcdao.base.BaseDaoSupport;
/**
* @ClassName: BaseServiceSupport
* @Description: TODO(业务逻辑的基本，提供一些基本的业务所需的对象，包括数据库访问接口对象)
* @author jason.peng
* @date 2016年1月6日 上午10:57:00
 */
public abstract class BaseServiceImpl extends BaseDaoSupport{
	
	protected Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	//-----------------------------
	// 异步任务执行器
	@Autowired
	protected TaskExecutor taskExecutor;
	
	//-----------------------------
    // JMS队列实体对象和JMS模板
	@Autowired
	protected JmsTemplate JmsTemplate;
	@Resource(name="userDestination")
	protected Destination userDestination;
	@Resource(name="orderDestination")
	protected Destination orderDestination;
	@Resource(name="packet2Destination")
	protected Destination packet2Destination;
	@Resource(name="order2Destination")
	protected Destination order2Destination;
	
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
}
