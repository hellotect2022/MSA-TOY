package com.msa.manager.service;

import com.msa.manager.dao.TestDAO;
import com.msa.manager.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestDAO testDAO;
    public List<TestDTO> getTestUser(){
        int a =1;
        return testDAO.getTestUsers();
    };
}
