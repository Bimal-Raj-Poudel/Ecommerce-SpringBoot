package com.SpringBoot.Ecommerce.Controller;

import com.SpringBoot.Ecommerce.DTO.ProductDto;

import com.SpringBoot.Ecommerce.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/user/{personId}/category/{categoryId}")
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto productDto, @PathVariable Integer personId,@PathVariable Integer categoryId){
        ProductDto savedProductDto = productService.postProduct(productDto,personId,categoryId);
        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>>getAllProduct(){
       List<ProductDto> productDto= productService.getAllProduct();
       return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto>getProductById(@PathVariable Integer productId){
    ProductDto productDto= productService.getProductById(productId);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String ,String>> deleteProductById (@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(Map.of("message" , "Successfully deleted"),HttpStatus.OK);
    }

    @PutMapping("/{productId}/person/{personId}")
    public ResponseEntity<ProductDto> updateProduct( @PathVariable Integer productId,@PathVariable Integer personId,@RequestBody ProductDto productDto){
       ProductDto productDtoService =productService.updateProduct(productId,personId,productDto);
        return new ResponseEntity<>(productDtoService,HttpStatus.OK);
    }

    @GetMapping("/pagination/")
    public ResponseEntity<List<ProductDto>> getAllPaginatedProductsList(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize){
        List<ProductDto> productList= productService.paginatedProductList(pageSize, pageNum);
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public  ResponseEntity<List<ProductDto>> getProductListByCategory(@PathVariable Integer categoryId){
        List<ProductDto> productList = productService.getProductListByCategory(categoryId);
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    //filter by keyword
    @GetMapping("/search/{keyWord}")
    public ResponseEntity<List<ProductDto>> searchByKeywordProducts(@PathVariable String keyWord){
        List<ProductDto> productDtoList = productService.filterByKeyword(keyWord);
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);
    }

    //get product List By PersonId
    @GetMapping("/user/{personId}")
    public ResponseEntity<List<ProductDto>> getProductListByPerson(@PathVariable Integer personId){
       List<ProductDto> productList= productService.getProductByPersonId(personId);
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }


}
