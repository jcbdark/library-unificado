package com.example.ProductService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Locale;

@Entity
@Table(name = "product")
@Data   // <-- Esto genera getters, setters, toString, equals y hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Boolean active = true;
}