package com.jason.qcserver.base;

import java.io.Serializable;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.core.RedisTemplate;

import com.jason.qcdao.base.BaseDaoSupport;
/**
* @ClassName: BaseServiceSupport
* @Description: TODO(基本的业务支撑)
* @author jason.peng
* @date 2016年1月7日 上午7:26:07
 */
public class BaseServiceSupport extends BaseDaoSupport{
	
	protected Logger logger = LoggerFactory.getLogger(BaseServiceSupport.class);
	//-----------------------------
	// 异步任务执行器
	@Autowired
	protected TaskExecutor taskExecutor;
	
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
