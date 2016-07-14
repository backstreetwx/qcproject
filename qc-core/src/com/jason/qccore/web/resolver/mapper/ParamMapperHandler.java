package com.jason.qccore.web.resolver.mapper;

import javax.servlet.http.HttpServletRequest;

/**
* @ClassName: MapperHandler
* @Description: TODO(这里用一句话描述这个类的作用)
* @author jason.peng
* @date 2015年8月25日 上午7:59:22
 */
public interface ParamMapperHandler<T> {
	/**
	* @Title: convert
	* @Description: TODO(将请求参数转换为一个对象)
	* @param request
	* @return
	* @author jason.peng
	* @date 2015年8月25日 上午8:00:26
	 */
	public T convert(HttpServletRequest request);
}
