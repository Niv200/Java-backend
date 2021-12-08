package me.niv.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.niv.backend.exception.InvalidPersonException;
import me.niv.backend.person.Person;
import me.niv.backend.repository.PersonRepository;

@Service
public class PersonService implements IPersonService{
	
	@Autowired
	PersonRepository personRepository;

	public Person savePerson(Person person) throws InvalidPersonException {
		if(validatePerson(person)){
			return personRepository.save(person);			
		}
		throw new InvalidPersonException("Person is invalid!");
	}

	@Override
	public boolean validatePerson(Person p) {
		if(p.getName() instanceof String && p.getAge() >= 0 && p.getFamilyName() instanceof String
				&& p.getBalance() >= 0 && p.getClass() != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	
	@Override
	public void deletePersonById(String id) {
		personRepository.deleteById(id);
	}

	@Override
	public int checkBalance(String id) {
		return personRepository.findById(id).get().getBalance();
	}

	@Override
	public void updateBalance(String id, int balance) {
		Person person = personRepository.findById(id).get();
		person.setBalance(balance);
		personRepository.save(person);
	}

	@Override
	public void addToBalance(String id, int balanceToAdd) {
		int currentBalance = personRepository.findById(id).get().getBalance();
		updateBalance(id, currentBalance + balanceToAdd);
	}
	
	@Override
	public Optional<Person> getPerson(String id) {
		return personRepository.findById(id);
	}
}
