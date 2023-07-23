package com.funnycode.ministore.ProductAPI.controller;

import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;
import com.funnycode.ministore.ProductAPI.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.funnycode.ministore.Util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION+"/products")

public class ProductController {
   ProductService productService;

    @GetMapping
    public List<ResponseProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}
