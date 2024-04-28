package com.SpringBoot.Ecommerce.Repository;


import com.SpringBoot.Ecommerce.Entity.Comment;
import com.SpringBoot.Ecommerce.Entity.Person;
import com.SpringBoot.Ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

    List<Comment>findByPerson(Person person);
    List<Comment>findByProduct(Product product);
}
