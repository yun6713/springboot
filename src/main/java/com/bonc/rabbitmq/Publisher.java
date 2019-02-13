package com.bonc.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
	@Autowired
	AmqpTemplate amqpTemplate;
	
	public void send() {
		String info = "rabbitmq test";
		amqpTemplate.convertSendAndReceive("route1", info);
	}
}
