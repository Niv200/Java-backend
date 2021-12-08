package me.niv.backend.service;

import java.util.List;
import java.util.Optional;

import me.niv.backend.exception.InvalidPersonException;
import me.niv.backend.person.Person;

public interface IPersonService {
	
	public boolean validatePerson(Person p);
	
	public Person savePerson(Person p) throws InvalidPersonException;
	
	public List<Person> findAll();
	
	public Optional<Person> getPerson(String id);
	
	public void deletePersonById(String id);
	
	public int checkBalance(String id);
	
	public void updateBalance(String id, int balance);
	
	public void addToBalance(String id, int balanceToAdd);
}
