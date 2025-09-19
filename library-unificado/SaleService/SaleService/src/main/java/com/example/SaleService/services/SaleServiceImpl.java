package com.example.SaleService.services;


import com.example.SaleService.dto.SaleDTO;
import com.example.SaleService.entity.Sale;
import com.example.SaleService.exception.SaleNotFoundException;
import com.example.SaleService.repository.SaleRepository;
import com.example.SaleService.util.SaleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        log.info("Creating new sale for customer ID: {}", saleDTO.getCustomerId());

        // Validar que tenga detalles
        if (saleDTO.getDetails() == null || saleDTO.getDetails().isEmpty()) {
            throw new IllegalArgumentException("Sale must have at least one detail");
        }

        // Establecer fecha actual si no se proporciona
        if (saleDTO.getSaleDate() == null) {
            saleDTO.setSaleDate(LocalDateTime.now());
        }

        // Mapear DTO a entidad
        Sale sale = saleMapper.toEntity(saleDTO);

        // Establecer relaciones bidireccionales y calcular total
        if (sale.getDetails() != null) {
            sale.getDetails().forEach(detail -> detail.setSale(sale));

            // Calcular total
            double total = sale.getDetails().stream()
                    .mapToDouble(detail -> detail.getPrice() * detail.getQuantity())
                    .sum();
            sale.setTotalAmount(total);
        }

        // Guardar
        Sale savedSale = saleRepository.save(sale);

        log.info("Sale created successfully with ID: {} and total: {}",
                savedSale.getId(), savedSale.getTotalAmount());

        return saleMapper.toDTO(savedSale);
    }

    @Override
    public SaleDTO getSaleById(Long id) {
        return saleRepository.findById(id)
                .map(saleMapper::toDTO)
                .orElseThrow(() -> new SaleNotFoundException("Sale not found with id " + id));
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream()
                .map(saleMapper::toDTO)
                .toList();
    }

    @Override
    public void deleteSale(Long id) {
        if (!saleRepository.existsById(id)) {
            throw new SaleNotFoundException("Sale not found with id " + id);
        }
        saleRepository.deleteById(id);
    }
}