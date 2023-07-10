package com.funnycode.ministore.ProductAPI.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    String idProduct;
    String nameProduct;
    int quantityProduct;
    float priceProduct;
    String typeProduct;
    String pictureProduct;

}
