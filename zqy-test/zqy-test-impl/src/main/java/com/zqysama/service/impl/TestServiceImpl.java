package com.zqysama.service.impl;

import com.zqysama.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService {


    @Override
    public String testHello() {
        log.info("hello");
        return "hello spring boot";
    }
}
