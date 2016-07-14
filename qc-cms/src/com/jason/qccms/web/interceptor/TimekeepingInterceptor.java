package com.jason.qccms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 类名：PermissionInterceptor <br>
 * 作者：jason <br>
 * 创建时间： 2015年6月4日 上午10:10:31 <br>
 * 版本： 1.0.0 <br>
 * 描述：接口计时拦截器
 */
public class TimekeepingInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String url  = request.getRequestURL().toString();
		System.out.println(url);
		return true;
	}

}
