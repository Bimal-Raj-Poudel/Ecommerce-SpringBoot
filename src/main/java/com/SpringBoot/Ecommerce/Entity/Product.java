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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;

    String productName;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;


    @ManyToOne
    @JoinColumn(name="personId")
    Person person;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Rating> ratings;
}
