package com.SpringBoot.Ecommerce.DTO;

import com.SpringBoot.Ecommerce.Utils.EntityValidation;
import jakarta.persistence.Column;
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
public class PersonDto implements EntityValidation {

    int personId;
    @NotEmpty(message = PERSON_NAME_EMPTY)
    @Size( min = 5,message = PERSON_NAME_SIZE)
    String name;

    String email;

    String gender;

    Long phoneNumber;

    @NotEmpty(message = PERSON_ADDRESS_EMPTY)
    @Size(min = 5,message = PERSON_ADDRESS_SIZE)
    String address;

}
