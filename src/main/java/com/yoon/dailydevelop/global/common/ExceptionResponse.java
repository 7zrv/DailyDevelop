package com.yoon.dailydevelop.global.common;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse<T> implements ResponseBase{

    private int code;
    private String message;

    public static ExceptionResponse<?> of(int code, String message) {
        return new ExceptionResponse<>(code, message);
    }

    public ExceptionResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

}