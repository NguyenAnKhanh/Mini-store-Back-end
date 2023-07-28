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
    String name;

    @Column(name = "stock")
    int quantity;

    double price;

    @Column(columnDefinition = "TEXT")
    String description;

    String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Category category;
}
