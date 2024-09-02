package com.yoon.dailydevelop.domain.user.responseDto;


import com.yoon.dailydevelop.domain.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Getter
@RequiredArgsConstructor
public class UserResponseDto {

    private final Long id;
    private final String email;
    private final String nickname;
    private final LocalDateTime createAt;

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getEmail(), user.getNickname(), user.getCreatedAt());
    }
}
