package com.imooc.miaosha.config;

import java.util.List;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.imooc.miaosha.access.AccessInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{
	
	@Autowired
	UserArgumentResolver userArgumentResolver;
	
	@Autowired
	AccessInterceptor accessInterceptor;
	@Autowired
	MyMessageConverter myMessageConverter;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accessInterceptor);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/converter").setViewName("/converter");
	}

 /*
    配置自定义的HttpMessageConvert的Bean，在Spring MVC里注册HttpMessageConvert有两个方法：
    configureMessageConverts：重置会覆盖Spring MVC里注册的多个HttpMessageConvert。
    extendMessageConverters：仅添加一个自定义的HttpMessageConvert，不覆盖默认注册的HttpMessageConvert
    这里重写extendMessageConverters
    */


   @Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	   converters.add(converter());

   }

	@Bean
	public MyMessageConverter converter(){
		return new MyMessageConverter();
	}



}
