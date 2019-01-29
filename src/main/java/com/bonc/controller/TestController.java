package com.bonc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class TestController {
	@RequestMapping("/test")
	@ResponseBody
	public String test01() {
		return "hello world!";
	}
	@RequestMapping("/info")
	public String info() {
		return "info";
	}
	
}
