package com.funnycode.ministore.ProductAPI.entity;

import com.funnycode.ministore.CategoryAPI.entity.Category;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String productName;

    @Column(name = "stock")
    int productQuantity;

    @Column(name = "price")
    double productPrice;

    @Column(name = "description", columnDefinition = "TEXT")
    String productDescription;

    @Column(name = "image")
    String productImg;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Category category;
}
