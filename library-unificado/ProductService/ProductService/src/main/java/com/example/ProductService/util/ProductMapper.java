package com.example.ProductService.util;


import com.example.ProductService.dto.ProductDTO;
import com.example.ProductService.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDTO(Product product);

    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(ProductDTO dto);

    List<ProductDTO> toDTOList(List<Product> products);
    List<Product> toEntityList(List<ProductDTO> productDTOs);
}

