package com.bonc.controller;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonc.quatz.TestJob;

@RestController
@RequestMapping("/quatz")
public class QuatzController {
	@Autowired
	Scheduler scheduler;
	@RequestMapping("/test")
	public String test() throws SchedulerException, InterruptedException {
		JobDataMap map = new JobDataMap();
		map.put("k1", "v1");
		JobDetail jd = JobBuilder.newJob(TestJob.class)
				.withIdentity("test1", "group1")
				.setJobData(map).build();
		Trigger trigger = TriggerBuilder.newTrigger()
				.startNow().build();
		scheduler.start();
		scheduler.scheduleJob(jd, trigger);
		Thread.sleep(3000);
		return "123";
	}
}
