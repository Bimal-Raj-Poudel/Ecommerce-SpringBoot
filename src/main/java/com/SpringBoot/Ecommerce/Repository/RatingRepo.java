package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating,Integer> {
}
