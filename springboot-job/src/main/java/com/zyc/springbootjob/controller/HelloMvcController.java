package com.zyc.springbootjob.controller;

import com.zyc.springbootjob.entity.User;
import com.zyc.springbootjob.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

    @Resource
    private IUserService userService;

    /**
     * 使用JSON作为响应内容
     */

    // @CrossOrigin(origins="*",maxAge=3600)
    //@RequestMapping(value="/getUser/{userID}",method= RequestMethod.GET)
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value="/getUser/{userID}", produces = "text/json; charset=utf-8")
    @ResponseBody
    public User getUser(@PathVariable int userID) {
/*        User u = new User();
        u.setName("Richard");
        u.setAge(38);
        u.setId(userID);
        return u;*/;
        User user = this.userService.getUserById(userID);
        return user;
    }
}