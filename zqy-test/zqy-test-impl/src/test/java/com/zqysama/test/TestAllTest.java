package com.zqysama.test;

import com.zqysama.test.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAllTest {

    @Resource
    TestService testService;

    @Test
    public void testHello() {
        testService.testHello();
    }

}
