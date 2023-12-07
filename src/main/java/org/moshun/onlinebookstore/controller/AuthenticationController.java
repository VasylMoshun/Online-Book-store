package org.moshun.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.moshun.onlinebookstore.dto.userdto.UserRegistrationRequestDto;
import org.moshun.onlinebookstore.dto.userdto.UserResponseDto;
import org.moshun.onlinebookstore.exception.RegistrationException;
import org.moshun.onlinebookstore.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth management", description = "Endpoints to managing authentication ")
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("registration")
    @Operation(summary = "Registration a new user", description = "Registration new user")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto request)
            throws RegistrationException {
        return userService.register(request);
    }
}
