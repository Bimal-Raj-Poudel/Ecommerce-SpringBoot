package com.SpringBoot.Ecommerce.Controller;


import com.SpringBoot.Ecommerce.DTO.CommentDto;
import com.SpringBoot.Ecommerce.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @PostMapping("/user/{personId}/product/{productId}")
    public ResponseEntity<CommentDto> postComment(@Valid @RequestBody CommentDto commentDto, @PathVariable Integer personId, @PathVariable Integer productId ){
       CommentDto savedCommentDto = commentService.postComment(commentDto,personId, productId);
        return new ResponseEntity<>(savedCommentDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CommentDto>> getAllComment (){

        List<CommentDto> commentDtoList=commentService.getAllPerson();
        return new ResponseEntity<>(commentDtoList,HttpStatus.OK);

    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Integer commentId){
        CommentDto commentDto= commentService.getCommentById(commentId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);

    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Map<String , String>> deleteByCommentId(@PathVariable Integer commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(Map.of("message", "successfully deleted"),HttpStatus.OK);
    }

    @PutMapping("/{commentId}/person/{personId}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable Integer commentId,@PathVariable Integer personId,@Valid @RequestBody CommentDto commentDto){
     CommentDto commentDtoServiced = commentService.updateComment(commentId,personId,commentDto);
        return new ResponseEntity<>(commentDtoServiced,HttpStatus.OK);
    }




}
