package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(String id) ;

    Category save(Category category);

    void delete(String id) ;
}
