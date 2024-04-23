package com.SpringBoot.Ecommerce.ServiceImpl;


import com.SpringBoot.Ecommerce.DTO.CommentDto;
import com.SpringBoot.Ecommerce.Entity.Comment;
import com.SpringBoot.Ecommerce.Entity.Person;
import com.SpringBoot.Ecommerce.Entity.Product;
import com.SpringBoot.Ecommerce.Exception.ResourceNotFoundException;
import com.SpringBoot.Ecommerce.ModelMapper.CommentModelMapper;
import com.SpringBoot.Ecommerce.Repository.CommentRepo;
import com.SpringBoot.Ecommerce.Repository.PersonRepo;
import com.SpringBoot.Ecommerce.Repository.ProductRepo;
import com.SpringBoot.Ecommerce.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private CommentModelMapper commentModelMapper; // yeha error vye uta bean ma check garne ek patak

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PersonRepo personRepo;

    // posting the comment
    @Override
    public CommentDto postComment (CommentDto commentDto , Integer personId , Integer productId){

        Person person= personRepo.findById(personId).orElseThrow(() -> new ResourceNotFoundException("person","id",personId));
        Product product= productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product","id",productId));

        Comment comment=commentModelMapper.commentDtoToComment(commentDto);

        comment.setPerson(person);
        comment.setProduct(product);

        Comment saveComment= commentRepo.save(comment);
        return commentModelMapper.commentToCommentDto(saveComment);
    }


    // Getting all comment in list
    @Override
    public List<CommentDto> getAllPerson() {
        List<Comment> commentList=commentRepo.findAll();
        return commentList.stream().map((comment) ->commentModelMapper.commentToCommentDto(comment)).collect(Collectors.toList());
    }

    //get comment by id
    @Override
    public CommentDto getCommentById(Integer commentId) {
       Comment comment= commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment","Id",commentId));
        return commentModelMapper.commentToCommentDto(comment);
    }

    //deleting comment by id
    @Override
    public void deleteComment(Integer commentId) {
        Comment comment= commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment","id",commentId));

    }


//updating the comment
    @Override
    public CommentDto updateComment(Integer commentId, Integer personId, CommentDto commentDto)
    {
        personRepo.findById(personId).orElseThrow(()-> new ResourceNotFoundException("person","id",personId));
        Comment comment = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment","id",commentId));

       comment.setCommentContent(commentDto.getCommentContent());

       Comment saveComment = commentRepo.save(comment);
        return commentModelMapper.commentToCommentDto(saveComment);
    }


}
