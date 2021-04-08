package com.zqysama.test.web;

import com.zqysama.test.service.TestService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestResourceImpl implements TestResource {

    @Resource
    TestService testService;

    @Override
    public String testHello() {
        return testService.testHello();
    }
}
