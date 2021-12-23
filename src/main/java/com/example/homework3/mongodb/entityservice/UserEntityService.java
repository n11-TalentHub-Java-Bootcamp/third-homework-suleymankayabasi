package com.example.homework3.mongodb.entityservice;

import com.example.homework3.mongodb.converter.UserConverter;
import com.example.homework3.mongodb.dto.UserDto;
import com.example.homework3.mongodb.entity.User;
import com.example.homework3.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserEntityService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll() {

        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUserListToUserDtoList(userList);
        return userDtoList;
    }

    public UserDto findById(String id) {

        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);
        return userDto;
    }

    public UserDto save(UserDto userDto){

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        user = userRepository.save(user);
        UserDto userDtoResult = UserConverter.INSTANCE.convertUserToUserDto(user);
        return userDtoResult;
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
