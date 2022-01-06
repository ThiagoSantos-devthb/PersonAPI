package com.thiagosantos.service;


import com.thiagosantos.dto.MessageResponseDTO;
import com.thiagosantos.entity.Person;
import com.thiagosantos.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("created person with ID" + savedPerson.getId())
                .build();
    }
}
