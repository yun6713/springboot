package com.bonc.rabbitmq;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
//	@Autowired
//	AmqpTemplate amqpTemplate;
	@Autowired
	RabbitTemplate amqpTemplate;
	
	public void send() throws AmqpException, UnsupportedEncodingException {
		String info = "rabbitmq test";
		amqpTemplate.convertSendAndReceive("route1", info);
		//amqpTemplate.convertSendAndReceive("route1", new int[]{1});
		amqpTemplate.convertSendAndReceive("route1", info.getBytes("UTF-8"));
	}
}
