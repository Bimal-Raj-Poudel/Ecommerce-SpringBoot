package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
