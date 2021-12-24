package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    List<UserDto> findAll();
    UserDto findById(String id);
    UserDto save(UserDto userDto);
    void deleteById(String id);
}
