package com.SpringBoot.Ecommerce.Controller;

import com.SpringBoot.Ecommerce.DTO.RatingDto;
import com.SpringBoot.Ecommerce.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/user/{personId}/product/{productId}")
    public ResponseEntity<RatingDto> postRating(@RequestBody RatingDto ratingDto, @PathVariable Integer personId, @PathVariable  Integer productId)
    {
       RatingDto ratingDtoService=ratingService.postRating(ratingDto,personId,productId);
       return new ResponseEntity<>(ratingDtoService, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<RatingDto>> getAllRating (){
        List<RatingDto> ratingDtoList=  ratingService.getAllRating();

        return new ResponseEntity<>(ratingDtoList,HttpStatus.OK);
    }
    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable Integer ratingId){
        RatingDto ratingDtoService= ratingService.getRatingById(ratingId);
        return new ResponseEntity<>(ratingDtoService,HttpStatus.OK);
    }


    @DeleteMapping("/deleted/{ratingId}")
    public ResponseEntity<Map<String,String>> deleteRatingById(@PathVariable Integer ratingId){
        ratingService.deleteRating(ratingId);
        return new ResponseEntity<>(Map.of("message","successfully deleted"),HttpStatus.OK);
    }

    @PutMapping("/person/{personId}/product/{productId}/rating/{ratingId}")
    public ResponseEntity<RatingDto>updateRating(@PathVariable Integer personId, @PathVariable Integer productId,@PathVariable Integer ratingId, @RequestBody RatingDto ratingDto ){

        RatingDto savedRatingDto =ratingService.updateRating(ratingId,personId,productId,ratingDto);
        return new ResponseEntity<>(savedRatingDto,HttpStatus.OK);
    }

}
