package com.bonc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonc.service.TestService;

@RequestMapping("/test")
@Controller
public class TestController {
	@Autowired
	TestService tService;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test01() {
		return "hello world!";
	}
	@RequestMapping("/info")
	public String info() {
		return "info";
	}
	@RequestMapping("/getTest/{id}")
	@ResponseBody
	public Object getTest(@PathVariable Long id) {
		return tService.findById(id);
	}
	@RequestMapping("/insertTest")
	@ResponseBody
	public Object insertTest() {
		return tService.testNativeInsert();
	}
	@RequestMapping("/testPageAndSort/{type}")
	@ResponseBody
	public Object testPageAndSort(@PathVariable int type) {
		return tService.testPageAndSort(type);
	}
	
	
}
