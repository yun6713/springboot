package com.bonc.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	
	
	//RedisTemplate自动配置，
	//导入spring-boot-starter-data-redis时，CacheManager自动配置。
	@SuppressWarnings("rawtypes")
	@Bean
	public CacheManager getRedisCacheManager(@Qualifier("redisTemplate")RedisTemplate template) {
		RedisCacheManager rcm = new RedisCacheManager(template);
		//设置默认过期时间，S。
		rcm.setDefaultExpiration(100);
		return rcm;
	}
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {

			@Override
			//对象,method,args
			public Object generate(Object arg0, Method arg1, Object... arg2) {
				StringBuffer stb = new StringBuffer(arg0.getClass().getName())
						.append(".").append(arg1.getName());
				for (int i = 0; i < arg2.length; i++) {
					stb.append(",").append(arg2[i].toString());
				}
				System.out.println(stb.toString());
				return stb.toString();
			}
			
		};
	}
}
