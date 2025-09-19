package com.example.SaleService.services;


import com.example.SaleService.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    SaleDTO createSale(SaleDTO saleDTO);
    SaleDTO getSaleById(Long id);
    List<SaleDTO> getAllSales();
    void deleteSale(Long id);
}