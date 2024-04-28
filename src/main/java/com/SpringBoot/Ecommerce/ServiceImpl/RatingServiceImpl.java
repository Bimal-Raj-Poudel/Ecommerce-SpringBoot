package com.SpringBoot.Ecommerce.ServiceImpl;


import com.SpringBoot.Ecommerce.DTO.RatingDto;
import com.SpringBoot.Ecommerce.Entity.Person;
import com.SpringBoot.Ecommerce.Entity.Product;
import com.SpringBoot.Ecommerce.Entity.Rating;
import com.SpringBoot.Ecommerce.Exception.ResourceNotFoundException;
import com.SpringBoot.Ecommerce.ModelMapper.RatingModelMapper;
import com.SpringBoot.Ecommerce.Repository.PersonRepo;
import com.SpringBoot.Ecommerce.Repository.ProductRepo;
import com.SpringBoot.Ecommerce.Repository.RatingRepo;
import com.SpringBoot.Ecommerce.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingModelMapper ratingModelMapper;

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private ProductRepo productRepo;


    @Override
    public RatingDto postRating(RatingDto ratingDto, Integer personId , Integer productId) {
        Person person= personRepo.findById(personId).orElseThrow(()-> new ResourceNotFoundException("person","id",personId));
        Product product =productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("product","id",productId));

        Rating rating =ratingModelMapper.ratingDtoToRating(ratingDto);

        rating.setPerson(person);
        rating.setProduct(product);

       Rating savedRating= ratingRepo.save(rating);

        return ratingModelMapper.ratingToRatingDto(savedRating);
    }

    @Override
    public List<RatingDto> getAllRating() {
        List<Rating> ratingList=ratingRepo.findAll();
        return ratingList.stream().map((rating)-> ratingModelMapper.ratingToRatingDto(rating)).collect(Collectors.toList());
    }

    @Override
    public RatingDto getRatingById(Integer ratingId) {
       Rating rating = ratingRepo.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating","Id",ratingId));
        return ratingModelMapper.ratingToRatingDto(rating);
    }

    @Override
    public void deleteRating(Integer ratingId) {

       Rating rating = ratingRepo.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("rating","id",ratingId));
       ratingRepo.delete(rating);
    }

    @Override
    public RatingDto updateRating(Integer ratingId,Integer personId, Integer productId, RatingDto ratingDto) {
           personRepo.findById(personId).orElseThrow(()-> new ResourceNotFoundException("person","id",personId));
           productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("product","id",productId));
           Rating rating=ratingRepo.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("rating","id",ratingId));

           rating.setRatingValue(ratingDto.getRatingValue());

           Rating saverating= ratingRepo.save(rating);
        return ratingModelMapper.ratingToRatingDto(saverating);
    }
}
