package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.DTO.ProductDto;
import com.SpringBoot.Ecommerce.Entity.Category;
import com.SpringBoot.Ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    List<Product> findByCategory(Category category);
}
