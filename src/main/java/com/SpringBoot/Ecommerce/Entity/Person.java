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

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "name",nullable = false)
    String personName;

    @Column(name = "address",nullable = false)
    String address;

    @Column(name = "gender",nullable = false)
    String gender;

    @Column(name = "number",nullable = false)
    String phoneNumber;

    @OneToMany(mappedBy="person", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product> products;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Rating> ratings;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Comment> comments;

}
