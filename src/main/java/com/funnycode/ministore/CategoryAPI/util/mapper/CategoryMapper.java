package com.funnycode.ministore.CategoryAPI.util.mapper;

import com.funnycode.ministore.CategoryAPI.dto.CreateCategoryDTO;
import com.funnycode.ministore.CategoryAPI.dto.ResponseCategoryDTO;
import com.funnycode.ministore.CategoryAPI.entity.Category;

public class CategoryMapper {
    public static Category toCategory(CreateCategoryDTO createCategoryDTO) {
        return Category.builder()
                .categoryName(createCategoryDTO.getCategoryName())
                .build();
    }

    public static ResponseCategoryDTO toResponseCategoryDTO(Category category) {
        return ResponseCategoryDTO.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
