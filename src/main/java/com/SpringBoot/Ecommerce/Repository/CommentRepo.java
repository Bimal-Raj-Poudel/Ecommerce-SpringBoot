package com.SpringBoot.Ecommerce.Repository;

import com.SpringBoot.Ecommerce.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
