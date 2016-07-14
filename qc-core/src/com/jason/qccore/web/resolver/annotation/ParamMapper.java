package com.jason.qccore.web.resolver.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jason.qccore.web.resolver.mapper.ParamMapperHandler;

/**
* @ClassName: CurrentUser
* @Description: TODO(映射参数)
* @author jason.peng
* @date 2015年8月5日 下午5:16:59
*/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented 
public @interface ParamMapper {

	Class<? extends ParamMapperHandler<?>> handler();
}
