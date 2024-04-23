package com.SpringBoot.Ecommerce.Service;

import com.SpringBoot.Ecommerce.DTO.CommentDto;

import java.util.List;

public interface CommentService {

    // Creating method
    CommentDto postComment (CommentDto commentDto , Integer personId , Integer productId);

    //Get all Comment
    List<CommentDto>getAllPerson();

    // Get a single Comment
    CommentDto getCommentById(Integer commentId);


    //Delete comment
    void deleteComment(Integer commentId);


    //update the comment
    CommentDto updateComment(Integer commentId,Integer personId,CommentDto commentDto);

}
