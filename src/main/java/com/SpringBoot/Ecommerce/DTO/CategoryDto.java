package com.SpringBoot.Ecommerce.DTO;


import com.SpringBoot.Ecommerce.Utils.EntityValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements EntityValidation{

    int categoryId;

    @NotEmpty(message = CATEGORY_EMPTY_MESSAGE)
    @Size(min = 5, message = CATEGORY_NAME_SIZE)
    String categoryName;

    @NotEmpty(message = CATEGORY_DESCRIPTION_EMPTY_MESSAGE)
    @Size(min = 10, message = CATEGORY_DESCRIPTION_SIZE)
    String categoryDescription;


}
