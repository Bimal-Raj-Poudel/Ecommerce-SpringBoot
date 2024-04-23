package com.SpringBoot.Ecommerce.ModelMapper;
import com.SpringBoot.Ecommerce.DTO.CommentDto;
import com.SpringBoot.Ecommerce.Entity.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentModelMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Comment commentDtoToComment( CommentDto commentDto){
        return modelMapper.map(commentDto,Comment.class);
    }
    public CommentDto commentToCommentDto(Comment comment){
        return modelMapper.map(comment, CommentDto.class);
    }
}
