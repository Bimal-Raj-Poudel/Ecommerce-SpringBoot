package com.SpringBoot.Ecommerce.Service;

import com.SpringBoot.Ecommerce.DTO.PersonDto;
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

//    Pgination in product list
    List<ProductDto> paginatedProductList(Integer pageSize, Integer pageNo);

    List<ProductDto> getProductListByCategory(Integer categoryId);


    //filter task
    List<ProductDto> filterByKeyword(String keyword);


    //getElement by person
    List<ProductDto> getProductByPersonId(Integer personId);

    //Finding Product by gender
//    ProductDto getProductByGender(String gender);

}
