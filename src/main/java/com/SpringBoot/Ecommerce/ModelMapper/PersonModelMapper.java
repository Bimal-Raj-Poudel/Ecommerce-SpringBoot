package com.SpringBoot.Ecommerce.ModelMapper;


import com.SpringBoot.Ecommerce.DTO.PersonDto;
import com.SpringBoot.Ecommerce.Entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PersonDto personToPersonDto(Person person){
        return modelMapper.map(person, PersonDto.class);
    }

    public Person personDtoToPerson(PersonDto personDto){
        return modelMapper.map(personDto, Person.class);
    }
}
