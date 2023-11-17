package com.msa.manager.service;

import com.msa.manager.dao.TestDAO;
import com.msa.manager.dto.CvUserDTO;
import com.msa.manager.dto.TestDTO;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvUserService {
    @Resource(name="sqlSessionTemplateDB1")
    private SqlSession session;

    public List<CvUserDTO> getCvUser(){
        return session.selectList("covision.xml.user.getCvUser");
    }

    public CvUserDTO userLogin(CvUserDTO cvUserDTO){
        return session.selectOne("covision.xml.user.userLogin",cvUserDTO);
    }
}
