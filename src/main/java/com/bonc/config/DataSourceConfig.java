package com.bonc.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class DataSourceConfig {

	/*@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.bonc")
	@ConditionalOnExpression("'${server.loc}'=='bonc'")
	public DataSource boncDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.home")
	@ConditionalOnExpression("'${server.loc}'=='home'")
	public DataSource homeDataSource() {
		return DruidDataSourceBuilder.create().build();
	}*/
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource homeDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
}
