package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    User save(User user);

    void deleteById(String id);
}
