package com.funnycode.ministore.ProductAPI.ulti.mapper;

import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.CategoryAPI.util.mapper.CategoryMapper;
import com.funnycode.ministore.ProductAPI.dto.CreateProductDTO;
import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;
import com.funnycode.ministore.ProductAPI.entity.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


public class ProductMapper {
    public static ResponseProductDTO toResponseProductDTO(Product product) {
        return ResponseProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .price(product.getPrice())
                .name(product.getName())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .category(CategoryMapper.toResponseCategoryDTO(product.getCategory()))
                .build();
    }

    public static Product toProduct(CreateProductDTO createProductDTO) {
        return Product.builder()
                .description(createProductDTO.getDescription())
                .image(createProductDTO.getImage())
                .price(createProductDTO.getPrice())
                .name(createProductDTO.getName())
                .quantity(createProductDTO.getQuantity())
                .category(createProductDTO.getCategory())
                .build();
    }
}
