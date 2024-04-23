package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}
