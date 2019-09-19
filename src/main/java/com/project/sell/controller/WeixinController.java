package com.project.sell.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WeixinController
 * @AuthotAdministrator
 * @Date 2019/8/12 23:47
 **/
@RestController
@RequestMapping("/weixin")
public class WeixinController {

    @RequestMapping("/getToken")
    public String getToken(@RequestParam("code")String code){
        return code;
    }
}
