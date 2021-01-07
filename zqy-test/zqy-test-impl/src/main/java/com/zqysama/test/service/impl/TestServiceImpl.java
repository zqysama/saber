package com.zqysama.test.service.impl;

import com.zqysama.test.po.TestPO;
import com.zqysama.test.repository.TestMapper;
import com.zqysama.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Resource
    TestMapper testMapper;

    @Override
    public String testHello() {
        log.info("hello");
        List<TestPO> testPOS = testMapper.qryAllTest();
        for (TestPO testPO : testPOS) {
            log.info("1、{}",testPO.toString());
        }
        return "hello spring boot";
    }
}
