package com.funnycode.ministore.ProductAPI.repository;

import com.funnycode.ministore.ProductAPI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, String> {
}
