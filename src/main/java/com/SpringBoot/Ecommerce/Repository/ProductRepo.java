package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.DTO.ProductDto;
import com.SpringBoot.Ecommerce.Entity.Category;
import com.SpringBoot.Ecommerce.Entity.Person;
import com.SpringBoot.Ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    List<Product> findByCategory(Category category);
    List<Product> findByPerson (Person person);

    // Optional<Product>findByGender(String gender);

    @Query(value = "select * from product where product_name like %:keyword%", nativeQuery = true)
    List<Product> filterByKeyword(@Param("keyword") String keyword);


}
