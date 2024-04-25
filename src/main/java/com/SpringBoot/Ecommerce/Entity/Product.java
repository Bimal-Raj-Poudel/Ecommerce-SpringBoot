package com.SpringBoot.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
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

    @Column(name = "product_name", nullable = false)
    String productName;

    @Column(name = "product_description", nullable = false)
    String productDescription;

    @Column(name = "product_price", nullable = false)
    Double price;

    @CreationTimestamp
    @Column(name = "listed_date")
    Date listedDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    Date updatedDate;


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
