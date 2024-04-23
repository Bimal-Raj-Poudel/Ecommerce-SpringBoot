package com.SpringBoot.Ecommerce.Controller;

import com.SpringBoot.Ecommerce.DTO.PersonDto;
import com.SpringBoot.Ecommerce.Service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @PostMapping( "/")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        logger.info("I am in Person Controller class.");
        PersonDto postPersonDto = personService.postPerson(personDto);
        return new ResponseEntity<>(postPersonDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonDto>> getAllPerson(){
        List<PersonDto> personDto = personService.getAllPerson();
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDto> getSinglePersonDto(@PathVariable Integer personId){
        logger.info("I am in the Method.");
        PersonDto personDto = personService.getPersonById(personId);
        return new ResponseEntity<>(personDto,HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Map<String, String>> deletePerson(@PathVariable Integer personId){
        personService.deletePerson(personId);
        return new ResponseEntity<>(Map.of("message","Successfully deleted !!"),HttpStatus.OK);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonDto> updatePerson1(@PathVariable Integer personId, @RequestBody PersonDto personDto){
        PersonDto personDto1 = personService.updatePerson(personId, personDto);
        return new  ResponseEntity<>(personDto1, HttpStatus.OK);
    }

}
