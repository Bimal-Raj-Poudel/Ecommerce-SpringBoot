package com.SpringBoot.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ratingId;

    @Column(name = "rating_value", nullable = false)
    int ratingValue;


    @ManyToOne
    @JoinColumn(name = "personId")
    Person person;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;


}
