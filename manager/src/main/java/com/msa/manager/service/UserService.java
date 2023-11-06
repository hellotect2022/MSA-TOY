package com.msa.manager.service;

import com.msa.manager.dto.UserDTO;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
//    @Autowired
//    UserDAO userDAO;
    @Resource(name="sqlSessionTemplateDB1")
    SqlSession session;


    List<UserDTO> userSignUp() {
        return null;
    }

    public int userLogin(UserDTO userDTO) {
        return session.selectList("db.xml.user.getUser",userDTO).size();
    }

    List<UserDTO> getUsers() {
        return null;
    }
}
