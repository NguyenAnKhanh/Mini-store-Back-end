package com.funnycode.ministore.ProductAPI.service.impl;

import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;
import com.funnycode.ministore.ProductAPI.repository.IProductRepository;
import com.funnycode.ministore.ProductAPI.service.ProductService;
import com.funnycode.ministore.ProductAPI.ulti.mapper.ProductMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    IProductRepository iProductRepository;
    @Override
    public List<ResponseProductDTO> getAllProducts() {
        return iProductRepository.findAll().stream()
                .map(ProductMapper::toResponseProductDTO)
                .collect(Collectors.toList());
    }
}
