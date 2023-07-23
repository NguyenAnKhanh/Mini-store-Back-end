package com.funnycode.ministore.CategoryAPI.controller;

import com.funnycode.ministore.CategoryAPI.dto.CreateCategoryDTO;
import com.funnycode.ministore.CategoryAPI.dto.ResponseCategoryDTO;
import com.funnycode.ministore.CategoryAPI.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.funnycode.ministore.Util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION+"/categories")

public class CategoryController {
    CategoryService categoryService;

    @PostMapping
    public ResponseCategoryDTO createCategory(@RequestBody CreateCategoryDTO createCategoryDTO){
        return categoryService.createCategory(createCategoryDTO);
    }

    @GetMapping
    public List<ResponseCategoryDTO> getAllCategory(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseCategoryDTO getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
}
