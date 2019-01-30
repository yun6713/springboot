package com.bonc.config;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bonc.entity.Test01;
import com.bonc.repository.TestJpaRepository;
@Configuration//便于类内部将inteceptor托管给spring
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/index");
		registry.addViewController("/info").setViewName("info");
		registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
	}
	
	@Bean
	public HandlerInterceptor druidInterceptor() {
		
		return new HandlerInterceptor(){
			//托管给spring管理后，可注入bean
			@Autowired
			TestJpaRepository test;
			@Override
			public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
					throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			//通过路径、session、cookie进行处理；false不通过，response重定向
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
				//uri资源标识，不带ip、端口；url资源定位，全路径
				System.out.println(request.getRequestURI());
				System.out.println(request.getRequestURL());
				if("/web/test/info".equals(request.getRequestURI())) {
					response.sendRedirect("/web/test/test");
					test.saveAndFlush(new Test01());
					return false;
				}
				//session，true保证有session，无参默认true
				request.getSession().setAttribute("","");
				request.getSession(true).getAttribute("");
				//cookie
				response.addCookie(new Cookie("la","la"));
				request.getCookies();
				return true;
			}
			
		};
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(druidInterceptor());
	}
	
	//跨域设置
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("*");
	}
	//处理静态文件映射
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("").addResourceLocations("");
	}
	//配置消息转换器，converters初始为空集
	@SuppressWarnings("deprecation")
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 定义一个转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 在转换器中添加配置信息
		fastConverter.setFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteDateUseDateFormat);
		fastConverter.setDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将转换器添加到converters中
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
				Charset.forName("UTF-8"));
		converters.add(stringHttpMessageConverter);
		converters.add(fastConverter);
	}
}
