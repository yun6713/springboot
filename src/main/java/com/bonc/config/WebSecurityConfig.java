package com.bonc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bonc.repository.UserJpa;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService  userDetailsService(UserJpa userJpa) {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				UserDetails userDetails = userJpa.findByUsername(username);
				if(userDetails==null) {
					throw new UsernameNotFoundException(username+"，对应用户不存在");
				}
				return userDetails;
			}
			
		};
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//配置权限，hasRole方法默认加前缀ROLE_，hasAuthority方法直接匹配
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/test/**").hasAnyAuthority("admin")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
			.and().logout().permitAll();
	}
}
