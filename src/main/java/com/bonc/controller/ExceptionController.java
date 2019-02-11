package com.bonc.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excp")
public class ExceptionController {

	@RequestMapping("/test/{id}")
	public String testException(@PathVariable String id) throws Exception {
		switch(id) {
		case "1":
			throw new RuntimeException("1");
		case "2":
			String[] arr = {};
			return arr[1];
		case "3":
			String[] arr1 = {null};
			return arr1[0].toLowerCase();
		default:
			return id;
		}
	}
	@ExceptionHandler(value= {NullPointerException.class})
	public String exceptionHandler(Exception e) {
		System.out.println(e);
		return "NullPointerException";
	}
}
