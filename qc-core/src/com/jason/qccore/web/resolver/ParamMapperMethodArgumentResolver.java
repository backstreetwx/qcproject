package com.jason.qccore.web.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jason.qccore.web.resolver.annotation.ParamMapper;
import com.jason.qccore.web.resolver.mapper.ParamMapperHandler;
/**
* @ClassName: ParamMapperMethodArgumentResolver
* @Description: TODO(ParamMapper解析器)
* @author jason.peng
* @date 2015年8月25日 上午8:01:44
 */
public class ParamMapperMethodArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(ParamMapper.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    	ParamMapper paramMapper = parameter.getParameterAnnotation(ParamMapper.class);
    	ParamMapperHandler<?> handler = paramMapper.handler().newInstance();
    	return handler.convert((HttpServletRequest) webRequest.getNativeRequest());
    }
}
