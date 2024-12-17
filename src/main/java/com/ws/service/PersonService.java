package com.ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.entity.Person;
import com.ws.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public Person registerPerson(int mobileNumber) {
		Person person = new Person();
		person.setMobileNumber(mobileNumber);
		return personRepository.save(person);
	}

	public Optional<Person> findByMobileNumber(int mobileNumber) {
		return personRepository.findByMobileNumber(mobileNumber);
	}
	
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
