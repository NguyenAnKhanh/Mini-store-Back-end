package com.funnycode.ministore.ProductAPI.service;

import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;

import java.util.List;

public interface ProductService {
    List<ResponseProductDTO> getAllProducts();
}
