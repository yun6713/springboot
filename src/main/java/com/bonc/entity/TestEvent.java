package com.bonc.entity;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {
	private Object arg;
	public TestEvent(Object source,Object arg) {
		super(source);
		this.arg = arg;
	}
	public Object getArg() {
		return arg;
	}
	
	
}
