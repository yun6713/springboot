package com.bonc.quatz;

import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
@Configuration
public class QuatzConfig {
	//继承SpringBeanJobFactory，由其创建job；而后托管给context，使Job类可通过注解注入bean
	public static class AutowireJobFactory extends SpringBeanJobFactory{
		AutowireCapableBeanFactory beanFactory;
		public AutowireJobFactory(ApplicationContext context) {
			beanFactory = context.getAutowireCapableBeanFactory();
		}
		@Override
		protected Object createJobInstance(TriggerFiredBundle arg0) throws Exception {
			Object job = super.createJobInstance(arg0);
			beanFactory.autowireBean(job);
			return job;
		}
	}
	public SpringBeanJobFactory springBeanJobFactory(ApplicationContext context) {
		return new SpringBeanJobFactory() {
			@Override
			protected Object createJobInstance(TriggerFiredBundle arg0) throws Exception {
				Object job = super.createJobInstance(arg0);
				context.getAutowireCapableBeanFactory().autowireBean(job);
				return job;
			}
		};
	}
	@Bean
	public JobFactory jobFactory(ApplicationContext context) {
//		SpringBeanJobFactory jf = new AutowireJobFactory(context);
		SpringBeanJobFactory jf = springBeanJobFactory(context);
		return jf;
	}
	@Bean
//	@Bean(destroyMethod="destroy",autowire=Autowire.NO)
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) {
		SchedulerFactoryBean sfb = new SchedulerFactoryBean();
		sfb.setJobFactory(jobFactory);
		return sfb;
	}
}
