package com.zqysama.test.web;

import org.springframework.web.bind.annotation.RequestMapping;

public interface TestResource {

    @RequestMapping("/hello")
    String testHello();
}
