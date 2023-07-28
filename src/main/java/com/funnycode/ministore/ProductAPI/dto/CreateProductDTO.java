package com.funnycode.ministore.ProductAPI.dto;

import com.funnycode.ministore.CategoryAPI.dto.ResponseCategoryDTO;
import com.funnycode.ministore.CategoryAPI.entity.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductDTO {
    String name;
    int quantity;
    double price;
    String description;
    String image;
    Category category;
}
