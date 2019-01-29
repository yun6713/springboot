package com.bonc.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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
			public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
				System.out.println("happy");
				return arg0.getAttribute("")==null;
			}
			
		};
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(druidInterceptor());
	}
	
	
	
}
