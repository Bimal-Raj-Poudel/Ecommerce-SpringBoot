package com.SpringBoot.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy="person", cascade=CascadeType.ALL)
    List<Product> products;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Rating> ratings;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Comment> comments;

}
