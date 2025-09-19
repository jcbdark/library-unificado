package com.example.ProductService.services;


import com.example.ProductService.dto.ProductDTO;
import com.example.ProductService.entity.Category;
import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.CategoryNotFoundException;
import com.example.ProductService.exception.ProductNotFoundException;
import com.example.ProductService.exception.ResourceNotFoundException;
import com.example.ProductService.repository.CategoryRepository;
import com.example.ProductService.repository.ProductRepository;
import com.example.ProductService.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDTOList(products);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO dto) {
        Product product = productMapper.toEntity(dto);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        Product saved = productRepository.save(product);
        return productMapper.toDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(productDTO.getCategoryId()));

        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setStock(productDTO.getStock());
        existingProduct.setCategory(category);
        existingProduct.setActive(productDTO.getActive());

        return productMapper.toDTO(productRepository.save(existingProduct));
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        // En lugar de borrarlo, lo desactivamos si está en ventas
        try {
            productRepository.delete(product);
        } catch (Exception e) {
            // Si está referenciado en ventas, lo marcamos como inactivo
            product.setActive(false);
            productRepository.save(product);
        }
    }
}