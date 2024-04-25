package com.SpringBoot.Ecommerce.DTO;

import com.SpringBoot.Ecommerce.Utils.EntityValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements EntityValidation {

    int commentId;

    @NotEmpty(message= COMMENT_CONTENT_EMPTY)
    @Size(min = 4, message = COMMENT_CONTENT_SIZE)
    String commentContent;



}
