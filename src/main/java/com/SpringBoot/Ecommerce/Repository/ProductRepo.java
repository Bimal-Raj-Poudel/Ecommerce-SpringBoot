package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
