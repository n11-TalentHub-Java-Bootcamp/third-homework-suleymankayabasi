package com.example.homework3.mongodb.controller;

import com.example.homework3.mongodb.dto.ProductReviewDto;
import com.example.homework3.mongodb.service.IProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product_reviews/")
public class ProductReviewController {

    @Autowired
    private IProductReviewService productReviewService;

    @GetMapping("")
    public List<ProductReviewDto> findAllUserList() {
        List<ProductReviewDto> productReviewDtoList = productReviewService.findAll();
        return productReviewDtoList;
    }

    @GetMapping("{id}")
    public ProductReviewDto findUserById(@PathVariable String id){
        return productReviewService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<ProductReviewDto> saveUser(@RequestBody @Valid ProductReviewDto productReviewDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productReviewService.save(productReviewDto));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        productReviewService.deleteById(id);
    }
}
