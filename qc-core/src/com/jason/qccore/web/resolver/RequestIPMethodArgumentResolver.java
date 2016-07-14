package com.jason.qccore.web.resolver;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jason.qccore.web.resolver.annotation.RequestIP;
/**
* @ClassName: RequestIPMethodArgumentResolver
* @Description: TODO(RequestIP参数解析器)
* @author jason.peng
* @date 2015年8月5日 下午5:23:31
*/
public class RequestIPMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(RequestIP.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    	return getRemoteIP((HttpServletRequest) webRequest.getNativeRequest());
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
