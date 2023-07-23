package com.funnycode.ministore.CategoryAPI.repository;

import com.funnycode.ministore.CategoryAPI.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
