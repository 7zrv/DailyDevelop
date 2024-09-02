package com.yoon.dailydevelop.domain.user.service;


import com.yoon.dailydevelop.domain.user.entity.User;
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

        checkEmailDuplicate(requestDto.getEmail());

        User user = requestDto.toEntity();

        userRepository.save(user);

        return UserResponseDto.from(user);
    }

    private Boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }
}
