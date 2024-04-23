package com.SpringBoot.Ecommerce.Service;

import com.SpringBoot.Ecommerce.DTO.RatingDto;
import com.SpringBoot.Ecommerce.Entity.Rating;

import java.util.List;

public interface  RatingService {


    //creating the rating
    RatingDto postRating(RatingDto ratingDto, Integer personId , Integer productId);

    //get all rating
    List<RatingDto> getAllRating();

    //get single rating by id
    RatingDto getRatingById(Integer ratingId);


    // delete the rating by id
    void deleteRating( Integer ratingId);

    //updating the rating
    RatingDto updateRating(Integer ratingId,Integer personId, Integer productId, RatingDto ratingDto);
}
