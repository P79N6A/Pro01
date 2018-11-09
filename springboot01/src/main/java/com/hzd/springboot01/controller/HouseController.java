package com.hzd.springboot01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author akoasm hzd
 * @since date: 2018/11/10 time: 1:37
 **/

@RestController
public class HouseController {
    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }
}

