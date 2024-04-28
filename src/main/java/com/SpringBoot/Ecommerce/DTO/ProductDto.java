package com.SpringBoot.Ecommerce.DTO;



import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static com.SpringBoot.Ecommerce.Utils.EntityValidation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    int productId;

    @NotEmpty(message = PRODUCT_NAME_NOT_EMPTY)
    @Size(min=5, message =PRODUCT_NAME_SIZE)
    String productName;


    @NotEmpty(message = PRODUCT_DESCRIPTION_NOT_EMPTY)
    @Size(min=10, message =PRODUCT_DESCRIPTION_SIZE)
    String productDescription;



    @NotEmpty(message = PRODUCT_PRICE_NOT_EMPTY)
    @DecimalMin(value="0.0", inclusive=false, message=PRODUCT_MIN_PRICE)
    Double price;


    Date listedDate;
    Date updatedDate;


    CategoryDto categoryDto;


    PersonDto personDto;


}
