package com.SpringBoot.Ecommerce.ModelMapper;
import com.SpringBoot.Ecommerce.DTO.RatingDto;
import com.SpringBoot.Ecommerce.Entity.Rating;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RatingModelMapper {
    @Autowired
    private ModelMapper modelMapper;

    public RatingDto ratingToRatingDto( Rating rating){
        return modelMapper.map(rating , RatingDto.class);
    }

    public Rating ratingDtoToRating( RatingDto ratingDto){
        return modelMapper.map(ratingDto,Rating.class);
    }
}
