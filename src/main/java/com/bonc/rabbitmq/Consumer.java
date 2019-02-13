package com.bonc.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues= {"route1"})
public class Consumer {

	@RabbitHandler
	public void process(String info) {
		System.out.println(info);
	}
}
