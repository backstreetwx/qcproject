package com.jason.qccms.web.resolver.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 作者：jason.peng <br/>
 * 创建时间：2015-3-5 <br/>
 * 描述：
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented 
public @interface CurrentUser {
    /**
     * 当前用户在request中的名字
     * @return
     */
    String value() default "sysUser";
}
