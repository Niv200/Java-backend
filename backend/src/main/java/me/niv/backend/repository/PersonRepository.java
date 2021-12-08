package me.niv.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.niv.backend.person.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>  {
	  public Person findByName(String Name);
}
