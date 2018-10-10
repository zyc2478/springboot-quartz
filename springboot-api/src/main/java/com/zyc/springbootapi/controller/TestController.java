package com.zyc.springbootapi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.zyc.springbootutils.helper.CommandMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试获得系统时间
     */

    @GetMapping("/date")
    public String getDate() {
        Date d = CommandMethod.getCurDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "当前时间：" + sdf.format(d);
    }
}
