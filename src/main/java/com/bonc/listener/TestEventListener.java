package com.bonc.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.bonc.entity.TestEvent;

@Component
public class TestEventListener {

	@EventListener
	public void testEvent(TestEvent te) {
		System.out.println(te.getArg());
	}
}
