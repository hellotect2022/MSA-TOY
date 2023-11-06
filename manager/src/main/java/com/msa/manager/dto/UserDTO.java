package com.msa.manager.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int idx;
    private String nickName;
    private String email;
    private String password;
    private String userType;
    private String delYn;
}
