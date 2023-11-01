package com.msa.manager.dao;

import com.msa.manager.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDAO {
    List<TestDTO> getTestUsers();

}
