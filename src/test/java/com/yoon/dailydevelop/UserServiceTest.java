package com.yoon.dailydevelop;

import com.yoon.dailydevelop.domain.user.entity.User;
import com.yoon.dailydevelop.domain.user.repository.UserRepository;
import com.yoon.dailydevelop.domain.user.requestDto.RegisterUserRequestDto;
import com.yoon.dailydevelop.domain.user.responseDto.UserResponseDto;
import com.yoon.dailydevelop.domain.user.service.UserService;
import com.yoon.dailydevelop.global.exception.DuplicateException;
import com.yoon.dailydevelop.global.exception.ExceptionCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        // Given
        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setEmail("test@example.com");
        requestDto.setPassword("password1234");
        requestDto.setNickname("nickname");
        requestDto.setPhoneNumber("123-456-7890");

        when(userRepository.existsByEmail(requestDto.getEmail())).thenReturn(false);

        User user = requestDto.toEntity();

        // Mock the saved user entity to return
        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        UserResponseDto registeredUser = userService.registerUser(requestDto);

        // Then
        assertNotNull(registeredUser);
        assertEquals("test@example.com", registeredUser.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }


    @Test
    void testRegisterUser_DuplicateEmail() {
        // Given
        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setEmail("test@example.com");

        // Mock the email duplication check
        when(userRepository.existsByEmail(requestDto.getEmail())).thenReturn(true);

        // When & Then
        DuplicateException exception = assertThrows(DuplicateException.class, () -> userService.registerUser(requestDto));
        assertEquals(ExceptionCode.DUPLICATED_USER_EMAIL.getCode(), exception.getCode());
        assertEquals(ExceptionCode.DUPLICATED_USER_EMAIL.getMessage(), exception.getMessage());

        // Verify that save was not called
        verify(userRepository, times(0)).save(any(User.class));
    }



}
