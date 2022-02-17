package com.abw12.springbootawsdynamodb.service;

import com.abw12.springbootawsdynamodb.entity.Person;
import com.abw12.springbootawsdynamodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/addPerson")
    public Person savePerson(@RequestBody Person person){
        return personRepository.addPerson(person);
    }

    @GetMapping("/findByPersonId/{personId}")
    public Person findPerson(@PathVariable String personId){
        return personRepository.findPersonById(personId);
    }

    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody Person person){
        return personRepository.deletePerson(person);
    }
    @PutMapping("/updatePerson")
    public String updatePerson(@RequestBody Person person ){
        return personRepository.editPerson(person);
    }

}
