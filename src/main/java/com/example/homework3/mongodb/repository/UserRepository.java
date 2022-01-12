package com.example.homework3.mongodb.repository;

import com.example.homework3.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {

}
