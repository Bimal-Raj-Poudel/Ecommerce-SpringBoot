package com.SpringBoot.Ecommerce.DTO;


import com.SpringBoot.Ecommerce.Entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    int ratingId;

    int ratingValue;

    PersonDto personDto;

}
