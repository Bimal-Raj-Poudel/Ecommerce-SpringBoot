package com.SpringBoot.Ecommerce.Service;

import com.SpringBoot.Ecommerce.DTO.ProductDto;
import com.SpringBoot.Ecommerce.Entity.Product;

import java.util.List;

public interface ProductService {

    // create product
    ProductDto postProduct(ProductDto productDto,Integer personId, Integer categoryId);

    //get all product
    List<ProductDto> getAllProduct();

    //get product by id
    ProductDto getProductById(Integer productId);

    //delete product by id
    void deleteProduct(Integer productId);

    //updating the Product
    ProductDto updateProduct (Integer productId,Integer personId, ProductDto productDto);
}