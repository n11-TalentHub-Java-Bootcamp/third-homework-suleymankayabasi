package com.example.homework3.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReviewDto {

    private String id;
    @Size(max = 500,message = "Character Size Limit Exceeded.")
    private String productReview;
    private Date reviewDate;
    private String productId;
    private String userId;
}
