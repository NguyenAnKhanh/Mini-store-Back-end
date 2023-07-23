package com.funnycode.ministore.CategoryAPI.service.impl;

import com.funnycode.ministore.CategoryAPI.dto.CreateCategoryDTO;
import com.funnycode.ministore.CategoryAPI.dto.ResponseCategoryDTO;
import com.funnycode.ministore.CategoryAPI.entity.Category;
import com.funnycode.ministore.CategoryAPI.repository.ICategoryRepository;
import com.funnycode.ministore.CategoryAPI.service.CategoryService;
import com.funnycode.ministore.CategoryAPI.util.mapper.CategoryMapper;
import com.funnycode.ministore.Exception.MiniStoreException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {
    
    ICategoryRepository iCategoryRepository;

    @Override
    public ResponseCategoryDTO createCategory(CreateCategoryDTO createCategoryDTO) {
        Category category = CategoryMapper.toCategory(createCategoryDTO);
        category = iCategoryRepository.save(category);
        return CategoryMapper.toResponseCategoryDTO(category);
    }

    @Override
    public List<ResponseCategoryDTO> getAllCategories() {
        return iCategoryRepository.findAll().stream()
                .map(CategoryMapper::toResponseCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCategoryDTO getCategoryById(int id) {
        Category category = iCategoryRepository.findById(id)
                .orElseThrow(() -> MiniStoreException.notFoundException("Category doesn't exist"));
        return CategoryMapper.toResponseCategoryDTO(category);
    }
}
