package com.bonc;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bonc.rabbitmq.Publisher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
	@Autowired
	Publisher publisher;
	@Test
	public void test01() throws InterruptedException, AmqpException, UnsupportedEncodingException {
		publisher.send();
		Thread.sleep(3000);
	}
}
