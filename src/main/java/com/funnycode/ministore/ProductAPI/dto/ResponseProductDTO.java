package com.funnycode.ministore.ProductAPI.dto;

import com.funnycode.ministore.CategoryAPI.dto.ResponseCategoryDTO;
import com.funnycode.ministore.CategoryAPI.entity.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseProductDTO {
    int id;
    String productName;
    int productQuantity;
    double productPrice;
    String productDescription;
    String productImg;
    ResponseCategoryDTO category;
}
