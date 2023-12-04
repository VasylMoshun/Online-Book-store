package org.moshun.onlinebookstore.service;

import org.moshun.onlinebookstore.dto.userdto.UserRegistrationRequestDto;
import org.moshun.onlinebookstore.dto.userdto.UserResponseDto;
import org.moshun.onlinebookstore.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}

