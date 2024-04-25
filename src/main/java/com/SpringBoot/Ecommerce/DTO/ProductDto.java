package com.SpringBoot.Ecommerce.DTO;


import com.SpringBoot.Ecommerce.Entity.Category;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    int productId;
    String productName;
    String productDescription;
    Double price;
    Date listedDate;
    Date updatedDate;


}
