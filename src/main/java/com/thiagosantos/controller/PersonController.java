
package com.thiagosantos.controller;


import com.thiagosantos.dto.request.PersonDTO;
import com.thiagosantos.dto.response.MessageResponseDTO;
import com.thiagosantos.entity.Person;
import com.thiagosantos.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public  PersonController(PersonService personService){
        this.personService = personService;

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
      return personService.createPerson(personDTO);

    }
}
