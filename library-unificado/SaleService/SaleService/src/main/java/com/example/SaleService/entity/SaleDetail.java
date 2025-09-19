package com.example.SaleService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sale_details")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Sale (está en el mismo microservicio, así que sí se mantiene)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    // Ya no usamos Product directamente
    @Column(name = "product_id", nullable = false)
    private Long productId;

    private Integer quantity;
    private Double price;
}

