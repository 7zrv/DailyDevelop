package com.yoon.dailydevelop.domain.user.service;


import com.yoon.dailydevelop.domain.user.repository.UserRepository;
import com.yoon.dailydevelop.domain.user.requestDto.RegisterUserRequestDto;
import com.yoon.dailydevelop.domain.user.responseDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto registerUser(RegisterUserRequestDto requestDto) {




        return null;
    }

    private Boolean checkEmailDuplicate(String email) {
        userRepository.existsByEmail();
    }
}
