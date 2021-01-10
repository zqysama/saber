package com.zqysama.test;

import com.zqysama.test.service.TestService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestAllTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAllTest.class);

    @Resource
    TestService testService;

    @BeforeAll
    static void beforeAll() {
        LOGGER.info("beforeAll called");
    }

    @Test
    public void aTest1() {
       testService.testHello();
    }

    @Test
    public void aTest2() {
        LOGGER.info("aTest2 called");
        LOGGER.info(this.toString());
    }

    @AfterAll
    static void afterAll() {
        LOGGER.info("afterAll called");
    }

}
