package com.example.homework3.mongodb.repository;

import com.example.homework3.mongodb.dto.ProductDetailDto;
import com.example.homework3.mongodb.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByCategoryId(String categoryId);

    ProductDetailDto findProductDetailDtoById(String id);
}
