package com.SpringBoot.Ecommerce.ModelMapper;
import com.SpringBoot.Ecommerce.DTO.CategoryDto;
import com.SpringBoot.Ecommerce.Entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDto categoryToCategoryDto (Category category){
        return modelMapper.map(category, CategoryDto.class);
    }

    public Category categoryDtoToCategory( CategoryDto categoryDto){
        return modelMapper.map(categoryDto, Category.class);
    }
}
