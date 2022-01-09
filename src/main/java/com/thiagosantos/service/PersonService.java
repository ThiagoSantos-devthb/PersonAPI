package com.thiagosantos.service;


import com.thiagosantos.dto.request.PersonDTO;
import com.thiagosantos.dto.response.MessageResponseDTO;
import com.thiagosantos.entity.Person;
import com.thiagosantos.mapper.PersonMapper;
import com.thiagosantos.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("created person with ID" + savedPerson.getId())
                .build();
    }
}
