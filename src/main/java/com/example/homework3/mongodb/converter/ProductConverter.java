package com.example.homework3.mongodb.converter;

import com.example.homework3.mongodb.dto.ProductDetailDto;
import com.example.homework3.mongodb.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productPrice", source = "price")
    ProductDetailDto convertProductToProductDetailDto(Product product);

    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productPrice", source = "price")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> product);

}
