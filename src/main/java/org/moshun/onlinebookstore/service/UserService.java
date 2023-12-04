package org.moshun.onlinebookstore.service;

import org.moshun.onlinebookstore.dto.userDto.UserRegistrationRequestDto;
import org.moshun.onlinebookstore.dto.userDto.UserResponseDto;
import org.moshun.onlinebookstore.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}

