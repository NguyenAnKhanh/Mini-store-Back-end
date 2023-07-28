package com.funnycode.ministore.ProductAPI.repository.criteria;

import com.funnycode.ministore.ProductAPI.dto.FilterProductDTO;
import com.funnycode.ministore.ProductAPI.dto.ResponseProductDTO;
import com.funnycode.ministore.ProductAPI.entity.Product;
import com.funnycode.ministore.ProductAPI.ulti.mapper.ProductMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductRepositoryCriteria {
    EntityManager em;


    public List<ResponseProductDTO> search(FilterProductDTO filterProductDTO) {
        StringBuilder sql = new StringBuilder(" select p from Product p where 1=1 ");
        // dùng map để map lại các query trong trường hợp mình filter theo nhiều field
        Map<String, Object> params = new HashMap<>();

        //Dynamic query
        // nguoi dung gui ve categoryID
        if (filterProductDTO.getCategoryID() != null){
            sql.append(" and p.category.id = :categoryID "); // nhớ thêm cách vào sau và trước câu query
            params.put("categoryID", filterProductDTO.getCategoryID());
        }
        // nguoi dung gui ve name
        if (filterProductDTO.getName() != null) {
            sql.append(" and p.name  like :name "); // nhớ thêm cách vào sau và trước câu query
            params.put("name", "%" + filterProductDTO.getName() + "%");
        }
        TypedQuery<Product> productTypedQuery = em.createQuery(sql.toString(), Product.class);

        // Set param to query
        if (params!=null){
            params.forEach((k,v) ->{
                productTypedQuery.setParameter(k,v);
            });
        }


        List<Product> productList = productTypedQuery.getResultList();

        return productList.stream()
                .map(ProductMapper::toResponseProductDTO)
                .collect(Collectors.toList());
    }
}
