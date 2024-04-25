package com.SpringBoot.Ecommerce.Service;

import com.SpringBoot.Ecommerce.DTO.CategoryDto;
import com.SpringBoot.Ecommerce.Entity.Category;

import java.util.List;

public interface CategoryService {

    //Create the category
    CategoryDto postCategory (CategoryDto categoryDto);


    // get all the list of category
    List<CategoryDto> getAllCategory();


    //get single category
    CategoryDto getCategoryById(Integer categoryId);

    //delete the category
    void deleteCategory(Integer categoryId);


    // update the category
   CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto);
}
