package com.bonc.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class DruidConfig {

	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean registry = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		//设置ip白名单
		registry.addInitParameter("allow","127.0.0.1");
        //设置ip黑名单，如果allow与deny共同存在时,deny优先于allow
		registry.addInitParameter("deny","192.168.0.19");
        //设置控制台管理用户
		registry.addInitParameter("loginUsername","druid");
		registry.addInitParameter("loginPassword","123456");
        //是否可以重置数据
		registry.addInitParameter("resetEnable","false");
        return registry;
	}
}
