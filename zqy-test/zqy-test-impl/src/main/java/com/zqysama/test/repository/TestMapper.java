package com.zqysama.test.repository;

import com.zqysama.test.po.TestPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    List<TestPO> qryAllTest();
}
