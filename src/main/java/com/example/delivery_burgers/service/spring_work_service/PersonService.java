package com.example.delivery_burgers.service.spring_work_service;

import com.example.delivery_burgers.model.Person;
import com.example.delivery_burgers.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }
}
