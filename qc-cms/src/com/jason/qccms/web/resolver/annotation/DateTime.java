package com.jason.qccms.web.resolver.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @ClassName: CurrentUser
* @Description: TODO(获取格式后的日期)
* @author jason.peng
* @date 2015年8月5日 下午5:16:59
*/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented 
public @interface DateTime {

	String value() default "";
	
	String pattern() default "yyyy-MM-dd HH:mm:ss";
}
