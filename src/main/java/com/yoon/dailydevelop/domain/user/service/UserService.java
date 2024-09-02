package com.yoon.dailydevelop.domain.user.service;


import com.yoon.dailydevelop.domain.user.entity.User;
import com.yoon.dailydevelop.domain.user.repository.UserRepository;
import com.yoon.dailydevelop.domain.user.requestDto.RegisterUserRequestDto;
import com.yoon.dailydevelop.domain.user.responseDto.UserResponseDto;
import com.yoon.dailydevelop.global.exception.BadRequestException;
import com.yoon.dailydevelop.global.exception.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.yoon.dailydevelop.global.exception.ExceptionCode.DUPLICATED_USER_EMAIL;
import static com.yoon.dailydevelop.global.exception.ExceptionCode.NOT_FOUND_USER_ID;


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

    private void checkEmailDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateException(DUPLICATED_USER_EMAIL);
        }
    }

    public UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException(NOT_FOUND_USER_ID));

        return UserResponseDto.from(user);
    }

}
