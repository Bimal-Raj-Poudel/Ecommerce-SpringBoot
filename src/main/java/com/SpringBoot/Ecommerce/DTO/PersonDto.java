package com.SpringBoot.Ecommerce.DTO;

import com.SpringBoot.Ecommerce.Utils.EntityValidation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements EntityValidation {

    int personId;
    @NotEmpty(message = PERSON_NAME_EMPTY)
    @Size( min = 5,message = PERSON_NAME_SIZE)
    String name;

    @NotEmpty(message = EMAIL_NOT_EMPTY)
    @Pattern( regexp = EMAIL_REGEXP, message = ENTER_VALID_EMAIL)
    String email;

    @NotEmpty(message = PERSON_GENDER_NOTEMPTY)
    String gender;

    @NotEmpty
    @Size(min = 10, max = 10, message = "Phone Number must be 10 character long.")
    String phoneNumber;

    @NotEmpty(message = PERSON_ADDRESS_EMPTY)
    @Size(min = 5,message = PERSON_ADDRESS_SIZE)
    String address;

}
