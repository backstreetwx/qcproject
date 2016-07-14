package com.jason.qccms.web.resolver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jason.qccms.web.resolver.annotation.DateTime;
/**
* @ClassName: DateTimeMethodArgumentResolver
* @Description: TODO(DateTime解析器)
* @author jason.peng
* @date 2015年8月25日 上午7:51:23
*
 */
public class DateTimeMethodArgumentResolver implements HandlerMethodArgumentResolver{
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.hasParameterAnnotation(DateTime.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		DateTime dateTime = parameter.getParameterAnnotation(DateTime.class);
		String value = null;
		if(isBlank(dateTime.value())){
			value = parameter.getParameterName();
		} else {
			value = dateTime.value();
		}
		Object obj = webRequest.getParameter(value);
		return formatDate(obj.toString(), dateTime.pattern());
	}
	/**
	* @Title: isBlank
	* @Description: TODO(判断字符串是否为空)
	* @param str
	* @return
	* @author jason.peng
	* @date 2015年10月21日 上午7:13:43
	 */
	private boolean isBlank(String str){
		   int strLen;
	        if (str == null || (strLen = str.length()) == 0) {
	            return true;
	        }
	        for (int i = 0; i < strLen; i++) {
	            if ((Character.isWhitespace(str.charAt(i)) == false)) {
	                return false;
	            }
	        }
	        return true;
	}
	/**
	* @Title: formatDate
	* @Description: TODO(格式化日期)
	* @param str
	* @param pattern
	* @return
	* @author jason.peng
	* @date 2015年10月21日 上午7:14:41
	 */
	private Date formatDate(String str, String pattern){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			
		}
		return date;
	}
}
