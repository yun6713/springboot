package com.bonc.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/rabbitmq_config.properties")
public class RabbitMQConfig {
	@Bean
	public Queue queue() {
		return new Queue("route1");
	}
}
