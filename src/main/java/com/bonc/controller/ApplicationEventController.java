package com.bonc.controller;

import org.junit.experimental.theories.suppliers.TestedOnSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonc.entity.TestEvent;

@RestController
@RequestMapping("/event")
public class ApplicationEventController {

	@Autowired
	ApplicationContext appContext;
	
	@RequestMapping("/test/{id}")
	public String test01(@PathVariable String id) {
		appContext.publishEvent(new TestEvent(this,id));
		return id;
	}
}
