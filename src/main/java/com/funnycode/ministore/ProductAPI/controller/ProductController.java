package com.funnycode.ministore.ProductAPI.controller;

import com.funnycode.ministore.ProductAPI.dto.CreateProductDTO;
import com.funnycode.ministore.ProductAPI.dto.FilterProductDTO;
import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;
import com.funnycode.ministore.ProductAPI.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.funnycode.ministore.Util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION+"/products")

public class ProductController {
   ProductService productService;

    @GetMapping("/search")
    public List<ResponseProductDTO> searchProduct(@ModelAttribute FilterProductDTO filterProductDTO){
        //Thay vì chỗ search này search cho tất cả, thì ít nhất m phân chia nó ra
        //1 là cho có category (param), tức là lấy hết
        //2 là lấy theo param
        //M đã bao được trường hợp có param, vậy bao thêm trường hợp ko có param là dc
        //THiếu bao điều kiện thôi ko sao
        //Vả lại thì nếu được nha, đừng để chữ in hoa lên link, trông nó phèn
        return productService.searchProduct(filterProductDTO);
    }

    // add product
    @PostMapping()
    public ResponseProductDTO createProduct(@RequestBody CreateProductDTO createProductDTO){
        return productService.createProduct(createProductDTO);
    }
}
