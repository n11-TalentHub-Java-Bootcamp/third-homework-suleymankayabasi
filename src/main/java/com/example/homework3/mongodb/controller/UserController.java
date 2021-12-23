package com.example.homework3.mongodb.controller;

import com.example.homework3.mongodb.dto.UserDto;
import com.example.homework3.mongodb.entityservice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("")
    public List<UserDto> findAllUserList() {
        List<UserDto> userDtoList = userEntityService.findAll();
        return userDtoList;
    }

    @GetMapping("{id}")
    public UserDto findUserById(@PathVariable String id){
        return userEntityService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userEntityService.save(userDto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        userEntityService.deleteById(id);
    }

    //TODO: VALİD ANATASYONU EKLENECE VE ONA GÖRE ROW CHECK YAPILCAK EX. YORUM SATIRI MAKS 500 OLCAK
    //TODO: EXCEPTİON HANDLİINGLER EKLENCEK
}
