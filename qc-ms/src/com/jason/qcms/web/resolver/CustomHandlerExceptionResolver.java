package com.jason.qcms.web.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.jason.qcms.exception.SystemException;
/**
* @ClassName: CustomHandlerExceptionResolver
* @Description: TODO(统一异常处理解析器)
* @author jason.peng
* @date 2015年8月5日 下午5:40:16
*/
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(CustomHandlerExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		if(ex instanceof SystemException){
			logger.error("系统异常", ex);
		} else if(ex instanceof ClientAbortException){
			logger.warn("终止异常", ex);
		} else {
			logger.error("未知异常", ex);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/public/system/error500");
		return mav;
	}

}
