package com.jason.qccore.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jason.qccore.service.UserService;
import com.jason.qcdao.domain.po.User;
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
		// 在cookie中获取hashId
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			response.sendRedirect(request.getContextPath() + "/public/system/error401");
			return false;
		}
		
		String hashId = null;
		for (Cookie cookie : cookies) {
			if("hashId".equals(cookie.getName())) {
				hashId = cookie.getValue();
				break;
			}
		}
		// 判断hashId是否为空
		if(StringUtils.isBlank(hashId)) {
			response.sendRedirect(request.getContextPath() + "/public/system/error401");
			return false;
		}
		
		User user = getUser(request, hashId);
		if(user == null){
			response.sendRedirect(request.getContextPath() + "/public/system/error401");
			return false;
		}
		if(User.LOCKED_STATUS.equals(user.getStatus())) {
			response.sendRedirect(request.getContextPath() + "/public/system/error403");
			return false;
		}
		
		return true;
	}
	/**
	* @Title: getUser
	* @Description: TODO(获取一个用户)
	* @param request
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午8:23:59
	 */
	private User getUser(HttpServletRequest request, String hashId) {
		WebApplicationContext ctx = (WebApplicationContext) request.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		UserService userService = ctx.getBean(UserService.class);
		return userService.getUserByHashId(hashId);
	}
}
