package com.example.SaleService.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SaleDetailDTO {
    private Long productId;
    private Integer quantity;
    private Double price;
}

