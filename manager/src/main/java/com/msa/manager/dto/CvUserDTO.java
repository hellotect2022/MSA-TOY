package com.msa.manager.dto;

import lombok.Data;

@Data
public class CvUserDTO {
    private int id;
    private String userId;
    private String username;
    private String email;
    private String password;
    private int isUse;
    private String tel;
    private String createdAt;
    private String updatedAt;
    private String expired;
    private int isLock;


}
