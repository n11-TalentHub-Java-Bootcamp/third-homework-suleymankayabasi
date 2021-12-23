package com.example.homework3.mongodb.controller;

import com.example.homework3.mongodb.dto.ProductReviewDto;
import com.example.homework3.mongodb.dto.UserDto;
import com.example.homework3.mongodb.entityservice.ProductReviewEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_reviews/")
public class ProductReviewController {

    @Autowired
    private ProductReviewEntityService productReviewEntityService;

    @GetMapping("")
    public List<ProductReviewDto> findAllUserList() {
        List<ProductReviewDto> productReviewDtoList = productReviewEntityService.findAll();
        return productReviewDtoList;
    }

    @GetMapping("{id}")
    public ProductReviewDto findUserById(@PathVariable String id){
        return productReviewEntityService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<ProductReviewDto> saveUser(@RequestBody ProductReviewDto productReviewDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productReviewEntityService.save(productReviewDto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        productReviewEntityService.deleteById(id);
    }
}
