package com.SpringBoot.Ecommerce.Configuration;

import com.SpringBoot.Ecommerce.ModelMapper.*;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public CategoryModelMapper categoryModelMapper(){
        return new CategoryModelMapper();
    }

    @Bean
    public PersonModelMapper personModelMapper(){
        return new PersonModelMapper();
    }

    @Bean
    public CommentModelMapper commentModelmapper(){
        return new CommentModelMapper();
    }

    @Bean
    public ProductModelMapper productModelMapper(){
        return new ProductModelMapper();
    }

    @Bean
    public RatingModelMapper ratingModelMapper(){
        return new RatingModelMapper();
    }

}
