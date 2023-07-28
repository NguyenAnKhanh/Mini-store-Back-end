package com.funnycode.ministore.ProductAPI.service;

import com.funnycode.ministore.ProductAPI.dto.CreateProductDTO;
import com.funnycode.ministore.ProductAPI.dto.FilterProductDTO;
import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;

import java.util.List;

public interface ProductService {
    List<ResponseProductDTO> searchProduct(FilterProductDTO filterProductDTO);

    ResponseProductDTO createProduct(CreateProductDTO createProductDTO);
}
