package com.bonc.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
@Configuration
@EnableResourceServer
public class OauthConfig extends ResourceServerConfigurerAdapter {
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {

			@Override
			public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
					throws IOException, ServletException {
				arg1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");
				
			}
			
		};
	}

	
}
