package com.SpringBoot.Ecommerce.ModelMapper;
import com.SpringBoot.Ecommerce.DTO.ProductDto;
import com.SpringBoot.Ecommerce.Entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Product productDtoToProduct(ProductDto productDto)
    {
        return modelMapper.map(productDto,Product.class);
    }

    public ProductDto productToProductDTo(Product product){
        return modelMapper.map(product,ProductDto.class);
    }
}
