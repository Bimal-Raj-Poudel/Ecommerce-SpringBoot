package com.SpringBoot.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;

    String categoryName;

    String categoryType;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Product> products;
}
