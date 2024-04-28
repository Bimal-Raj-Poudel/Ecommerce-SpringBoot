package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Integer> {


    Optional<Person> findByEmail(String email);

    @Query(value = "SELECT * FROM person WHERE name LIKE %keyword%", nativeQuery = true)
    List<Person> filterByKeyword(@Param("keyword") String keyword);

}
