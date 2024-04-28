package com.SpringBoot.Ecommerce.DTO;


import com.SpringBoot.Ecommerce.Entity.Person;
import com.SpringBoot.Ecommerce.Utils.EntityValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto implements EntityValidation {

    int ratingId;

//    @NotNull(message = RATING_VALUE_NOT_NULL)
    @Min(value=1,message = MIN_RATING_VALUE)
    @Max(value=5,message = MAX_RATING_VALUE)
    int ratingValue;


}
