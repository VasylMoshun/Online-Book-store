package org.moshun.onlinebookstore.service;

import lombok.RequiredArgsConstructor;
import org.moshun.onlinebookstore.dto.userdto.UserRegistrationRequestDto;
import org.moshun.onlinebookstore.dto.userdto.UserResponseDto;
import org.moshun.onlinebookstore.exception.RegistrationException;
import org.moshun.onlinebookstore.mapper.UserMapper;
import org.moshun.onlinebookstore.model.User;
import org.moshun.onlinebookstore.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("User with email: "
                    + requestDto.getEmail() + " already exist");
        }
        User user = new User();
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setEmail(requestDto.getEmail());
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setShippingAddress(requestDto.getShippingAddress());
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
