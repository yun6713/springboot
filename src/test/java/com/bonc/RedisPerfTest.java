package com.bonc;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bonc.service.TestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisPerfTest {

	@Rule
	public ContiPerfRule cpf = new ContiPerfRule();
	@Autowired
	TestService testService;
	@Test
	@PerfTest(invocations=10000,threads=100)
	public void test01() {
		testService.findById(1L);
	}
}
