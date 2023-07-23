package com.funnycode.ministore.CategoryAPI.service;

import com.funnycode.ministore.CategoryAPI.dto.CreateCategoryDTO;
import com.funnycode.ministore.CategoryAPI.dto.ResponseCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    ResponseCategoryDTO createCategory(CreateCategoryDTO createCategoryDTO);

    List<ResponseCategoryDTO> getAllCategories();

    ResponseCategoryDTO getCategoryById(int id);
}
