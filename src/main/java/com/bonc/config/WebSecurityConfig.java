package com.bonc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

import com.bonc.repository.UserJpa;

@Configuration
@EnableWebSecurity
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
//				return userDetails;
//				返回默认的UserDetails实现
				return new org.springframework.security.core.userdetails.User(
						userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
			}			
		};
	}
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder();
	}
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder auth,UserDetailsService userDetailsService) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
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
	//注解权限表达式
	@EnableGlobalMethodSecurity(jsr250Enabled=true,prePostEnabled=true)
	public static class GlobalConfig extends GlobalMethodSecurityConfiguration{
		@Override
		protected MethodSecurityExpressionHandler createExpressionHandler() {
			return new OAuth2MethodSecurityExpressionHandler();
		}
	}
}
