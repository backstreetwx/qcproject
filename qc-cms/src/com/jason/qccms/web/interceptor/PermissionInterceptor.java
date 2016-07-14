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
 * 描述：权限拦截器
 */
public class PermissionInterceptor implements HandlerInterceptor {

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
		// 判断用户是否登录过，如果登录过就验证权限，没有就跳转到登录页面
		if(request.getSession().getAttribute("sysUser") == null){
			response.sendRedirect(request.getContextPath() + "/admin/system/gotoLogin");
			return false;
		}
		return true;
	}
}
