package com.SpringBoot.Ecommerce.ServiceImpl;

import com.SpringBoot.Ecommerce.DTO.CategoryDto;
import com.SpringBoot.Ecommerce.Entity.Category;
import com.SpringBoot.Ecommerce.Exception.ResourceNotFoundException;
import com.SpringBoot.Ecommerce.ModelMapper.CategoryModelMapper;
import com.SpringBoot.Ecommerce.Repository.CategoryRepo;
import com.SpringBoot.Ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryModelMapper categoryModelMapper;

    @Autowired
    private CategoryRepo categoryRepo;


    //create category
    @Override
    public CategoryDto postCategory(CategoryDto categoryDto) {
       Category category= categoryModelMapper.categoryDtoToCategory(categoryDto);  //mapper instance call garera teo vitra ko method invoke garera dto pathaune ra teslai return type ko variable ma store garne
        Category saveCategory=categoryRepo.save(category); // db snga communication garnu paryo vane hamle repo snga khelxau
        return categoryModelMapper.categoryToCategoryDto(saveCategory);
    }


    //show all category
    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categoryList =categoryRepo.findAll(); // after = part le dherai list wala value haru falxa so teslai store garna euta list wala chaiyo , teslai kaseri rakhne vanda category object wala ma rakhxa storage
        return categoryList.stream().map((category) -> categoryModelMapper.categoryToCategoryDto(category)).collect(Collectors.toList());
    }

    //show single category
    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
      Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category","Id", categoryId));
        return categoryModelMapper.categoryToCategoryDto(category);
    }


    //Delete category by id
    @Override
    public void deleteCategory(Integer categoryId) {
        Category category=categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category","Id",categoryId));

    }


    // update category id
    @Override
    public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto) {
      Category category=  categoryRepo.findById(categoryId).orElseThrow( () -> new ResourceNotFoundException("category","Id",categoryId));
     category.setCategoryName(categoryDto.getCategoryName());
     Category saveCategory= categoryRepo.save(category);
      return categoryModelMapper.categoryToCategoryDto(saveCategory);
    }

    //paginated by categoryList
    @Override
    public List<CategoryDto> getCategoryListByPagination(Integer pageNo, Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        Page<Category> paginatedListOfCategory= categoryRepo.findAll(pageable);
        return paginatedListOfCategory.getContent().stream().map((category)->categoryModelMapper.categoryToCategoryDto(category)).collect(Collectors.toList());
    }


    // filtering the category by keyword
    @Override
    public List<CategoryDto> filterByKeyword(String Keyword) {
      List<Category> categoryList=  categoryRepo.filterByKeyword(Keyword);
        return categoryList.stream().map((category) -> categoryModelMapper.categoryToCategoryDto(category)).collect(Collectors.toList());
    }


}
