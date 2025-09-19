package com.example.SaleService.util;


import com.example.SaleService.dto.SaleDTO;
import com.example.SaleService.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "total", source = "totalAmount")  // mapea totalAmount → total
    SaleDTO toDTO(Sale sale);

    @Mapping(target = "totalAmount", source = "total")  // mapea total → totalAmount
    Sale toEntity(SaleDTO dto);
}
