package com.example.homework3.mongodb.entityservice;

import com.example.homework3.mongodb.converter.ProductReviewConverter;
import com.example.homework3.mongodb.dto.ProductReviewDto;
import com.example.homework3.mongodb.entity.ProductReview;
import com.example.homework3.mongodb.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductReviewEntityService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductReviewDto> findAll(){

        List<ProductReview> productReviewList = productReviewRepository.findAll();
        List<ProductReviewDto> productReviewDtoList = ProductReviewConverter.INSTANCE.convertAllProductReviewListToProductReviewDtoList(productReviewList);
        return productReviewDtoList;
    }

    public ProductReviewDto findById(String id){

        Optional<ProductReview> optional = productReviewRepository.findById(id);
        ProductReview productReview = null;
        if (optional.isPresent()){
            productReview = optional.get();
        }
        ProductReviewDto productReviewDto = ProductReviewConverter.INSTANCE.convertProductReviewToProductReviewDto(productReview);
        return productReviewDto;
    }

    public ProductReviewDto save(ProductReviewDto productReviewDto){
        ProductReview productReview = ProductReviewConverter.INSTANCE.convertProductReviewDtoToProductReview(productReviewDto);
        productReview = productReviewRepository.save(productReview);
        ProductReviewDto productReviewDtoResult = ProductReviewConverter.INSTANCE.convertProductReviewToProductReviewDto(productReview);
        return productReviewDtoResult;
    }

    public void deleteById(String id){
        productReviewRepository.deleteById(id);
    }

}
