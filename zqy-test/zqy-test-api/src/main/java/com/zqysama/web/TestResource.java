package com.zqysama.web;

import org.springframework.web.bind.annotation.RequestMapping;

public interface TestResource {

    @RequestMapping("/hello")
    String testHello();
}
