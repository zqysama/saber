package com.zqysama.test.service.impl;

import com.zqysama.test.po.TestPO;
import com.zqysama.test.repository.TestMapper;
import com.zqysama.test.service.TestService;
import io.micrometer.core.instrument.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Resource
    TestMapper testMapper;

    @Resource
    RedisTemplate<String, Boolean> redisTemplate;

    @Override
    public String testHello() {
        log.info("hello");
        List<TestPO> testPOS = testMapper.qryAllTest();
        for (TestPO testPO : testPOS) {
            log.info("1、{}",testPO.toString());
        }
//        redisTemplate.opsForValue().set("testBoolean",true);
//        boolean test = redisTemplate.opsForValue().get("testBoolean");
//        if (test) {
//            log.info("true");
//        } else {
//            log.info("false");
//        }
//        redisTemplate.opsForValue().set("testBoolean2",false);
//        Boolean testBoolean2 = redisTemplate.opsForValue().get("testBoolean2");
//        System.out.println(testBoolean2);
        return "hello spring boot";
    }

    @Override
    public void testStream() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.stream().filter(a -> !a.isEmpty()).map(a -> a = a + "+").count();
        System.out.println(count);
        strings.forEach(System.out::println);
    }
}
