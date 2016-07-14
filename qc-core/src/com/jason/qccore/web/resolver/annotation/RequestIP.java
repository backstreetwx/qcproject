package com.jason.qccore.web.resolver.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
* @ClassName: RequestIP
* @Description: TODO(获取当前请求IP)
* @author jason.peng
* @date 2015年8月5日 下午5:18:42
*/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented 
public @interface RequestIP {

}
