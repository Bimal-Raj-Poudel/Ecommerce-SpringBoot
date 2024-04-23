package com.SpringBoot.Ecommerce.ServiceImpl;

import com.SpringBoot.Ecommerce.DTO.PersonDto;
import com.SpringBoot.Ecommerce.Entity.Person;
import com.SpringBoot.Ecommerce.Exception.ResourceNotFoundException;
import com.SpringBoot.Ecommerce.ModelMapper.PersonModelMapper;
import com.SpringBoot.Ecommerce.Repository.PersonRepo;
import com.SpringBoot.Ecommerce.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PersonModelMapper personModelMapper;

    @Override
    public PersonDto postPerson(PersonDto personDto){
        Person person = personModelMapper.personDtoToPerson(personDto);
       Person savePerson = personRepo.save(person);
        return personModelMapper.personToPersonDto(savePerson);
    }

    @Override
    public List<PersonDto> getAllPerson() {
        List<Person> personList = personRepo.findAll();
        return personList.stream().map((person) -> personModelMapper.personToPersonDto(person)).collect(Collectors.toList());
    }
    @Override
    public PersonDto getPersonById(Integer personId) {
       Person person = personRepo.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person","Id", personId));
        return personModelMapper.personToPersonDto(person);
    }
    @Override
    public void deletePerson(Integer personId) {
     Person person = personRepo.findById(personId).orElseThrow(() -> new ResourceNotFoundException("User","id", personId));
     personRepo.delete(person);
    }

    @Override
    public PersonDto updatePerson(Integer personId, PersonDto personDto) {
        Person person = personRepo.findById(personId).orElseThrow(() -> new ResourceNotFoundException("User","id", personId));
//        Person person = Person.builder().name(personDto.getName()).personId(personDto.getPersonId()).build();

        person.setName(personDto.getName());
        Person savePerson = personRepo.save(person);
        return personModelMapper.personToPersonDto(savePerson);
    }


}
