package com.bonc.quatz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.bonc.service.TestService;

public class TestJob implements Job {
	@Autowired
	TestService tService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(context.getJobDetail().getJobDataMap().keySet());
		System.out.println(tService.findById(1L));
		System.out.println("Hello World!");
	}

	/*@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println(context.getJobDetail().getJobDataMap().keySet());
		System.out.println(tService.findById(1L));
		System.out.println("Hello World!");
	}*/

}
