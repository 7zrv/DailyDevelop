package com.yoon.dailydevelop.global.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {

    INVALID_PASSWORD(401, "이메일이나 비밀번호가 일치하지 않습니다."),
    INVALID_EMAIL(401, "이메일이나 비밀번호가 일치하지 않습니다."),

    NOT_FOUND_USER_ID(404, "해당하는 유저가 존재하지 않습니다."),

    DUPLICATED_USER_EMAIL(409, "이미 가입된 이메일입니다.");


    private final int code;
    private final String message;
}
