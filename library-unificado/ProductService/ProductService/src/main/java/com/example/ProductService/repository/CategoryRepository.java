package com.example.ProductService.repository;

import com.example.ProductService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Puedes agregar consultas personalizadas si necesitas
    // Ejemplo: Optional<Category> findByName(String name);
}
