package com.example.homework3.mongodb.controller;

import com.example.homework3.mongodb.dto.ProductDetailDto;
import com.example.homework3.mongodb.entity.Product;
import com.example.homework3.mongodb.entity.User;
import com.example.homework3.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public MappingJacksonValue findAllUserList() {

        List<User> userList = userService.findAll();

        MappingJacksonValue mapping = new MappingJacksonValue(userList);

        return mapping;

    }

    @GetMapping("{id}")
    public MappingJacksonValue findUserById(@PathVariable String id){

        User user = userService.findById(id);

        MappingJacksonValue mapping = new MappingJacksonValue(user);

        return mapping;

    }

    @PostMapping("")
    public ResponseEntity<Object> saveUser(/**@Valid*/@RequestBody User user){
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteById(id);
    }
}
