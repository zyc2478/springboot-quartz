package com.zyc.springbootjob.config;
import java.io.IOException;
import java.util.Properties;

import com.zyc.springbootjob.factory.MyJobFactory;
import com.zyc.springbootjob.job.MyJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Author: hezishan
 * Date: 2018/6/6.
 * Description:
 **/

@Configuration
@EnableScheduling
public class QuartzSchedule {

    @Autowired
    private MyJobFactory myJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(Trigger updateTrigger) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        // 延时启动
        factory.setStartupDelay(10);
        // 自定义Job Factory，用于Spring注入
        factory.setJobFactory(myJobFactory);
        factory.setTriggers(updateTrigger); return factory;
    }

    @Bean(name = "updateJobDetail")
    public JobDetailFactoryBean uploadJobDetail() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setJobClass(MyJob.class);
        return jobDetail;
    }

    @Bean(name = "updateTrigger")
    public CronTriggerFactoryBean updateTriggerFactoryBean(JobDetail updateJobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setCronExpression("*/10 * * * * ?");
        trigger.setJobDetail(updateJobDetail);
        return trigger;
    }
}