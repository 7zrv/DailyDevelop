package com.yoon.dailydevelop.domain.user.controller;


import com.yoon.dailydevelop.domain.user.requestDto.RegisterUserRequestDto;
import com.yoon.dailydevelop.domain.user.responseDto.UserResponseDto;
import com.yoon.dailydevelop.domain.user.service.UserService;
import com.yoon.dailydevelop.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("")
    public ApiResponse<UserResponseDto> registerUser(@RequestBody RegisterUserRequestDto requestDto) {

        UserResponseDto responseDto = userService.registerUser(requestDto);

        return ApiResponse.ok(responseDto, "회원가입 성공");
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponseDto> getUser(@PathVariable Long userId) {

        UserResponseDto responseDto = userService.getUser(userId);

        return ApiResponse.ok(responseDto, "유저 조회 성공");
    }



}
