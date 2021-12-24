package com.example.homework3.mongodb.controller;

import com.example.homework3.mongodb.dto.UserDto;
import com.example.homework3.mongodb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public List<UserDto> findAllUserList() {
        List<UserDto> userDtoList = userService.findAll();
        return userDtoList;
    }

    @GetMapping("{id}")
    public UserDto findUserById(@PathVariable String id){
        return userService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        userService.deleteById(id);
    }

    //TODO: VALİD ANATASYONU EKLENECE VE ONA GÖRE ROW CHECK YAPILCAK EX. YORUM SATIRI MAKS 500 OLCAK

}
