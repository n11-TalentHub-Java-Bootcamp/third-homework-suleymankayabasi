package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.converter.ProductReviewConverter;
import com.example.homework3.mongodb.dto.ProductReviewDto;
import com.example.homework3.mongodb.entity.ProductReview;
import com.example.homework3.mongodb.exception.ProductReviewNotFoundException;
import com.example.homework3.mongodb.exception.UserNotFoundException;
import com.example.homework3.mongodb.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductReviewEntityService implements IProductReviewService{

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Override
    public List<ProductReviewDto> findAll(){
        List<ProductReview> productReviewList = productReviewRepository.findAll();
        if(productReviewList.isEmpty()) throw new ProductReviewNotFoundException("Product List is empty.");
        List<ProductReviewDto> productReviewDtoList = ProductReviewConverter.INSTANCE.convertAllProductReviewListToProductReviewDtoList(productReviewList);
        return productReviewDtoList;
    }

    @Override
    public ProductReviewDto findById(String id){
        Optional<ProductReview> optional = productReviewRepository.findById(id);
        ProductReview productReview = null;
        if (optional.isPresent()){
            productReview = optional.get();
        }
        ProductReviewDto productReviewDto = ProductReviewConverter.INSTANCE.convertProductReviewToProductReviewDto(productReview);
        if(productReviewDto.equals(null)) throw new ProductReviewNotFoundException(id + " Id Product Review not found.");
        return productReviewDto;
    }

    @Override
    public ProductReviewDto save(ProductReviewDto productReviewDto){
        ProductReview productReview = ProductReviewConverter.INSTANCE.convertProductReviewDtoToProductReview(productReviewDto);
        productReview = productReviewRepository.save(productReview);
        ProductReviewDto productReviewDtoResult = ProductReviewConverter.INSTANCE.convertProductReviewToProductReviewDto(productReview);
        return productReviewDtoResult;
    }

    @Override
    public void deleteById(String id){
        if (productReviewRepository.findById(id).equals(null)) {
            throw new UserNotFoundException(id + " Id User not found.");
        }
        productReviewRepository.deleteById(id);
    }
}
