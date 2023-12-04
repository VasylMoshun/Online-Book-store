package org.moshun.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import org.moshun.onlinebookstore.config.MapperConfig;
import org.moshun.onlinebookstore.dto.userDto.UserResponseDto;
import org.moshun.onlinebookstore.model.User;


@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);
}
