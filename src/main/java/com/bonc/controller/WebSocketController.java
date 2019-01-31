package com.bonc.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@MessageMapping("/stomp/test01")//接收
	@SendTo("/stomp/test02")//返回给订阅者
	public String test01(String info) {
		return info;
	}
	@RequestMapping("/stomp/page")
	public String page() {
		return "stomp";
	}
	
}
