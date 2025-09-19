package com.example.SaleService.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SaleDTO {
    private Long id;
    private Long customerId;
    private LocalDateTime saleDate;
    private Double total;
    private List<SaleDetailDTO> details;

}
