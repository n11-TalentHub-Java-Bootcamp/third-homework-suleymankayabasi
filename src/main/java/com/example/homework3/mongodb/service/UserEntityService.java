package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.converter.UserConverter;
import com.example.homework3.mongodb.dto.UserDto;
import com.example.homework3.mongodb.entity.User;
import com.example.homework3.mongodb.exception.UserNotFoundException;
import com.example.homework3.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserEntityService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {

        List<User> userList = userRepository.findAll();
        if(userList.isEmpty()) throw  new UserNotFoundException("User List is empty");
        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUserListToUserDtoList(userList);
        return userDtoList;
    }

    @Override
    public UserDto findById(String id) {

        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);
        if(userDto.equals(null)) throw new UserNotFoundException(id + " Id User not found.");
        return userDto;
    }

    @Override
    public UserDto save(UserDto userDto){

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        user = userRepository.save(user);
        UserDto userDtoResult = UserConverter.INSTANCE.convertUserToUserDto(user);
        return userDtoResult;
    }

    @Override
    public void deleteById(String id) {
        if (userRepository.findById(id).equals(null)) {
            throw new UserNotFoundException(id + " Id User not found.");
        }
        userRepository.deleteById(id);
    }
}
