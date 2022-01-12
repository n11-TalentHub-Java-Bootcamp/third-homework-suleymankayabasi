package com.example.homework3.mongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductReviewNotFoundException extends RuntimeException{

    public ProductReviewNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
