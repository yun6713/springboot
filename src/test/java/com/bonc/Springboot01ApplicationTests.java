package com.bonc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.bonc.service.TestService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01ApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	WebApplicationContext context;
	@Autowired
	TestService tService;
	@Before
	public void before() {
		//获取mockMvc对象
		mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
	}

	@Test
	public void test01() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();;
		map.add("name", "lee");
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/excp/test/1").params(map)).andReturn();
		System.out.println(result);
	}
	@Test
	public void testQuatz() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.get("/quatz/test")).andReturn();
		System.out.println(result);
	}
	
}

