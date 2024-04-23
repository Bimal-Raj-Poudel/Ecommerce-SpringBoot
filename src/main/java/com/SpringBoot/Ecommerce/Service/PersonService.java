package com.SpringBoot.Ecommerce.Service;

import com.SpringBoot.Ecommerce.DTO.PersonDto;

import java.util.List;


public interface PersonService {

//    create person
PersonDto postPerson(PersonDto personDto);

//Get all Person
List<PersonDto> getAllPerson();

//get person by ID
PersonDto getPersonById(Integer personId);

// Delete User by PersonId
void deletePerson(Integer personId);

// Update Person
PersonDto updatePerson(Integer personId, PersonDto personDto);


}
