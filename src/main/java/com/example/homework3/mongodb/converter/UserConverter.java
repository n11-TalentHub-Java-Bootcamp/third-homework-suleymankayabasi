package com.example.homework3.mongodb.converter;

import com.example.homework3.mongodb.dto.UserDto;
import com.example.homework3.mongodb.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(target = "id",source = "id")
    UserDto convertUserToUserDto(User user);

    @Mapping(target = "id",source = "id")
    List<UserDto> convertAllUserListToUserDtoList(List<User> userList);

    @Mapping(target = "id",source = "id")
    User convertUserDtoToUser(UserDto userDto);

}
