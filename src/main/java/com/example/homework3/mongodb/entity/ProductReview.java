package com.example.homework3.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "product_review")
public class ProductReview {

    @Id
    private String id;
    private String productReview;
    private Date reviewDate;
    private String productId;
    private String userId;

}
