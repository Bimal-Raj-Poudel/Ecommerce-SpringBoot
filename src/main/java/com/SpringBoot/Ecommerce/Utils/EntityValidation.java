package com.SpringBoot.Ecommerce.Utils;

public interface EntityValidation {

//Category Validation
    String CATEGORY_EMPTY_MESSAGE = "Category content con not be empty.";
    String CATEGORY_NAME_SIZE = "Category Name must be at least 3 characters long.";
    String CATEGORY_DESCRIPTION_EMPTY_MESSAGE = "Category description can not be empty.";

    String CATEGORY_DESCRIPTION_SIZE = "Category Name must be at least 10 characters long.";


    // comment validation.......................
    String COMMENT_CONTENT_EMPTY= "Comment must not be empty.";
    String COMMENT_CONTENT_SIZE="Size must be aleast 4";


    //PERSON VALIDATION..............................
    String PERSON_NAME_EMPTY="person name cannot be empty";

    String PERSON_NAME_SIZE="person name size must be atleast 5";

    String PERSON_ADDRESS_EMPTY="address cannot be empty";

    String PERSON_ADDRESS_SIZE="address must be aleast 6 words";

    //


}
