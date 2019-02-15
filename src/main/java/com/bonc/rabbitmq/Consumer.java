package com.bonc.rabbitmq;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

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

	@RabbitHandler
	public void process2(byte[] info) throws UnsupportedEncodingException {
		System.out.println("I handle byte[],"+new String(info,"UTF-8"));
	}
}
