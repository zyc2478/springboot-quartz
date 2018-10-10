package com.zyc.springbootjob.job;
import com.zyc.springbootjob.service.IUserService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: hezishan
 * Date: 2018/6/6
 * Description:
 */
@DisallowConcurrentExecution
public class MyJob implements Job, Serializable {

    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(new Date());
        System.out.println("id 为1的user是：" + userService.getUserById(1).getName());
    }
}