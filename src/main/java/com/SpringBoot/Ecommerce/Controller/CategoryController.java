package com.SpringBoot.Ecommerce.Controller;

import com.SpringBoot.Ecommerce.DTO.CategoryDto;
import com.SpringBoot.Ecommerce.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> postCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto categorydto = categoryService.postCategory(categoryDto);
        return new ResponseEntity<>(categorydto, HttpStatus.CREATED);
    }

    @RequestMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @RequestMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
        CategoryDto categoryDtoService = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(categoryDtoService, HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{categoryId}")
    public ResponseEntity<Map<String, String>> deleteCategoryById(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(Map.of("message", "message"), HttpStatus.OK);
    }

    @PutMapping("/updated/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategoryById(@PathVariable Integer categoryId, @Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto categoryDtoService = categoryService.updateCategory(categoryId, categoryDto);
        return new ResponseEntity<>(categoryDtoService, HttpStatus.OK);
    }

    @GetMapping("/pagination/")
    public ResponseEntity<List<CategoryDto>> getCategoryByPagination(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize) {

        List<CategoryDto> paginatedCategoryList=categoryService.getCategoryListByPagination(pageNum,pageSize);
        return new ResponseEntity<>(paginatedCategoryList,HttpStatus.OK);
    }




}