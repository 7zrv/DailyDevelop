package com.yoon.dailydevelop.global.common.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> implements ResponseBase{


    private int code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> ok(T data, String message) {

        return new ApiResponse<>(200, message, data);
    }

    public static ApiResponse<?> ok(String msg) {

        return new ApiResponse<>(200, msg, null);
    }

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}