package com.produtos.apirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
