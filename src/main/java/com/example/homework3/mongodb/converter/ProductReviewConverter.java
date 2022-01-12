package com.example.homework3.mongodb.converter;

import com.example.homework3.mongodb.dto.ProductReviewDto;
import com.example.homework3.mongodb.entity.ProductReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductReviewConverter {

    ProductReviewConverter INSTANCE = Mappers.getMapper(ProductReviewConverter.class);

    @Mapping(target = "id",source = "id")
    ProductReviewDto convertProductReviewToProductReviewDto(ProductReview productReview);

    @Mapping(target = "id",source = "id")
    List<ProductReviewDto> convertAllProductReviewListToProductReviewDtoList(List<ProductReview> productReviewList);

    @Mapping(target = "id",source = "id")
    ProductReview convertProductReviewDtoToProductReview(ProductReviewDto productReviewDto);
}
