package com.msa.manager.common.utils;

public enum ErrorCode {
    // 회원가입 관련 E1001 ~ E11000
    E1001(1101,"중복된 아이디 입니다."),
    E1002(1102,"비밀번호는 특수문자 1개 이상 포함되어야 하며 8 자 이상 16자리 이하 여야 합니다."),
    E1003(1103,"사용할수 없는 아이디 입니다."),
    E1004(1104,"아이디는 최대 6자이상 16자 이하 여야 합니다."),
    E1005(1105,"중복된 이메일 입니다."),

    // 로그인 관련 E1101 ~ E12000
    E1101(1001,"없는 사용자 입니다."),
    E1102(1002,"사용할 수 없는 사용자 입니다."),
    E1103(1003,"제한된 사용자 입니다. "),
    E1104(1004,"비밀번호가 맞지 않습니다.");


    private final int errorCode;
    private final String errorMessage;

    public int getErrorCode(){
        return this.errorCode;
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }

    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


}
