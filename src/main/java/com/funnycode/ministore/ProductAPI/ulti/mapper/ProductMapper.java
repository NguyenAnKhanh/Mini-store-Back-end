package com.funnycode.ministore.ProductAPI.ulti.mapper;

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
                .build();
    }
}
