package com.example.ProductService.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("Categoría con ID " + id + " no encontrada");
    }
}
