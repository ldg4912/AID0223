package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {

    //指定返回的媒体为我们自定义的媒体类型application/x-wisely
    @RequestMapping(value = "/convert", produces = { "application/x-wisely" })
    @ResponseBody
    public  UserEntity convert(@RequestBody UserEntity demoObj) {
     System.out.println(demoObj);
        return demoObj;
    }
}
