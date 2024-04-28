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

    String ENTER_VALID_EMAIL = "Enter valid Email address.";

    String EMAIL_NOT_EMPTY = "Email mus not be empty.";

    String EMAIL_REGEXP = "^[a-zA-Z0-9#-_&]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,}$";

   String PERSON_GENDER_NOTEMPTY=" Gender must be provided";

   String PERSON_NUMBER_NOT_EMPTY=" Phone Number Must be Entered";

   String PERSON_NUMBER_SIZE= " Phone Number Must Be atleast 10 Digits";



   //FOR PRODUCT VALIDATION
    String PRODUCT_NAME_NOT_EMPTY="Product name must be given.";

    String PRODUCT_NAME_SIZE= "product name size must be atleast 5 char";
    String PRODUCT_DESCRIPTION_NOT_EMPTY=" product description cannot be empty";

    String PRODUCT_DESCRIPTION_SIZE= "product description must be in 10 char";

    String PRODUCT_PRICE_NOT_EMPTY="Price for any product must be given";
     String PRODUCT_MIN_PRICE="Minimum price must be grater than 1 Rupees .";

//   For Rating Validation

    String RATING_VALUE_NOT_NULL = "Rating value field can not be null.";

    String MIN_RATING_VALUE = "Minimum value is 1.";

    String MAX_RATING_VALUE = "Maximum value is 5.";



}
