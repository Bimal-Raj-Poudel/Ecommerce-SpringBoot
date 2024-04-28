package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    @Query(value = "SELECT * FROM category WHERE category_name LIKE %:keyword%",nativeQuery = true)
    List<Category> filterByKeyword(@Param("keyword") String keyword);
}
