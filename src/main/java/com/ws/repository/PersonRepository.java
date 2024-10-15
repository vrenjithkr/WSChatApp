package com.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	Optional<Person> findByMobileNumber(int mobileNumber);
}
