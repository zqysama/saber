package com.zqysama.test.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHello {

    @RequestMapping("/hello")
    public String test(){
        return "hello spring";
    }
}
