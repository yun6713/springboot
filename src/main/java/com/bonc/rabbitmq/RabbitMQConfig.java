package com.bonc.rabbitmq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:config/rabbitmq_config.properties")
public class RabbitMQConfig {
	/*
		Exchange:TopicExchange、FanoutExchange；new对象
		Binding，通过BindingBuiler构建。
	 */
	@Bean
	public Queue queue() {
		return new Queue("route1");
	}
	
}
