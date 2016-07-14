package com.jason.qccore.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
		String ip = getRemoteIP(request);
		String url  = request.getRequestURL().toString();
		System.out.println("(" + ip + ")" + url);
		return true;
	}

	 /**
	    * @Title: getRemoteIP
	    * @Description: TODO(获取远程IP地址)
	    * @param request
	    * @return
	    * @author jason.peng
	    * @date 2015年10月21日 上午7:07:39
	     */
	    private String getRemoteIP(HttpServletRequest request){
	    	String ip = request.getHeader("X-Forwarded-For");
			if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
				// 多次反向代理后会有多个ip值，第一个ip才是真实ip
				int index = ip.indexOf(",");
				if (index != -1) {
					return ip.substring(0, index);
				} else {
					return ip;
				}
			}
			ip = request.getHeader("X-Real-IP");
			if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
				return ip;
			}
			return request.getRemoteAddr();
	    }
}
