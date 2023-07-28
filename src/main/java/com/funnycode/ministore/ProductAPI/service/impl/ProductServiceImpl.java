package com.funnycode.ministore.ProductAPI.service.impl;

import com.funnycode.ministore.ProductAPI.dto.CreateProductDTO;
import com.funnycode.ministore.ProductAPI.dto.FilterProductDTO;
import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;
import com.funnycode.ministore.ProductAPI.entity.Product;
import com.funnycode.ministore.ProductAPI.repository.IProductRepository;
import com.funnycode.ministore.ProductAPI.repository.criteria.ProductRepositoryCriteria;
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
    ProductRepositoryCriteria productRepositoryCriteria;
    IProductRepository iProductRepository;
    @Override
    public List<ResponseProductDTO> searchProduct(FilterProductDTO filterProductDTO) {
        return productRepositoryCriteria.search(filterProductDTO);
    }

    @Override
    public ResponseProductDTO createProduct(CreateProductDTO createProductDTO) {
        Product product = ProductMapper.toProduct(createProductDTO);
        product = iProductRepository.save(product);
        return ProductMapper.toResponseProductDTO(product);
    }
}
