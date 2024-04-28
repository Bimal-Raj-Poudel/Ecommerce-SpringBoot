package com.SpringBoot.Ecommerce.ServiceImpl;

import com.SpringBoot.Ecommerce.DTO.PersonDto;
import com.SpringBoot.Ecommerce.DTO.ProductDto;
import com.SpringBoot.Ecommerce.Entity.Category;
import com.SpringBoot.Ecommerce.Entity.Person;
import com.SpringBoot.Ecommerce.Entity.Product;
import com.SpringBoot.Ecommerce.Exception.ResourceNotFoundException;
import com.SpringBoot.Ecommerce.ModelMapper.ProductModelMapper;
import com.SpringBoot.Ecommerce.Repository.CategoryRepo;
import com.SpringBoot.Ecommerce.Repository.PersonRepo;
import com.SpringBoot.Ecommerce.Repository.ProductRepo;
import com.SpringBoot.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;


    @Autowired
    private ProductModelMapper productModelMapper;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    


    //creating the product
    @Override
    public ProductDto postProduct(ProductDto productDto,Integer personId, Integer categoryId) {

        Person person = personRepo.findById(personId).orElseThrow(() -> new ResourceNotFoundException("User","Id",personId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

        Product product= productModelMapper.productDtoToProduct(productDto);

        product.setPerson(person);
        product.setCategory(category);

        Product saveProduct= productRepo.save(product);
        return productModelMapper.productToProductDTo(saveProduct);
    }

    // geting all the list of product
    @Override
    public List<ProductDto> getAllProduct() {
        List<Product>  productList = productRepo.findAll();
        return productList.stream().map((product) -> productModelMapper.productToProductDTo(product)).collect(Collectors.toList());
    }

    //Get  single product by id
    @Override
    public ProductDto getProductById(Integer productId) {
       Product product= productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product","id",productId));
        return productModelMapper.productToProductDTo(product);
    }


    //delete the product  by id
    @Override
    public void deleteProduct(Integer productId) {
        Product product= productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product","id",productId));
    }



    //update the product
    @Override
    public ProductDto updateProduct(Integer productId,Integer personId, ProductDto productDto) {
        personRepo.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person","id",personId));
        Product product= productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product","id",productId));

        product.setProductName(productDto.getProductName());

        Product saveProduct= productRepo.save(product);
        return productModelMapper.productToProductDTo(saveProduct);
    }

    @Override
    public List<ProductDto> paginatedProductList(Integer pageSize, Integer pageNo) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> paginatedProduct = productRepo.findAll(pageable);
        return paginatedProduct.getContent().stream().map((product) -> productModelMapper.productToProductDTo(product)).collect(Collectors.toList());
    }
    @Override
    public List<ProductDto> getProductListByCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id",categoryId));
        List<Product> productList = productRepo.findByCategory(category);
        return productList.stream().map((product) -> productModelMapper.productToProductDTo(product)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> filterByKeyword(String keyword) {
        List<Product> productList = productRepo.filterByKeyword(keyword);
        return productList.stream().map((product) -> productModelMapper.productToProductDTo(product)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductByPersonId(Integer personId) {
       Person person= personRepo.findById(personId).orElseThrow(()-> new ResourceNotFoundException("person","id",personId));
       List<Product> productList=productRepo.findByPerson(person);
        return productList.stream().map((product) -> productModelMapper.productToProductDTo(product)).collect(Collectors.toList());
    }


    // getting product list by gender
//    @Override
//    public ProductDto getProductByGender(String gender) {
//        personRepo.
//
//        return null;
//    }
}
