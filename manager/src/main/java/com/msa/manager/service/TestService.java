package com.msa.manager.service;

import com.msa.manager.dao.TestDAO;
import com.msa.manager.dto.TestDTO;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
//    @Autowired
//    TestDAO testDAO;  // dao 를 연결하는 방식

    
    @Resource(value="sqlSessionFactoryDB1")
    private SqlSession session;

    public List<TestDTO> getTestUser(){
        int a =1;
        return testDAO.getTestUsers();
    };
}
