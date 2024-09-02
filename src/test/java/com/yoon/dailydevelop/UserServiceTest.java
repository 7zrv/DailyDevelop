package com.yoon.dailydevelop;

import com.yoon.dailydevelop.domain.user.entity.User;
import com.yoon.dailydevelop.domain.user.repository.UserRepository;
import com.yoon.dailydevelop.domain.user.requestDto.RegisterUserRequestDto;
import com.yoon.dailydevelop.domain.user.responseDto.UserResponseDto;
import com.yoon.dailydevelop.domain.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        User user = User.builder()
                .email("test@example.com")
                .password("password1234")
                .nickname("nickname")
                .phoneNumber("123-456-7890")
                .build();

        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();


        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        UserResponseDto registeredUser = userService.registerUser(user);

        // Then
        assertNotNull(registeredUser);
        assertEquals("test@example.com", registeredUser.getEmail());
        verify(userRepository, times(1)).save(user);
    }
}
