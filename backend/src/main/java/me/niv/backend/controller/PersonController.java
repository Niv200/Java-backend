package me.niv.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.niv.backend.exception.InvalidPersonException;
import me.niv.backend.person.Person;
import me.niv.backend.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonService personService;
	
	//Return List<person> based on every person that exists in DB
	@GetMapping("/getall")
	  public List<Person> getAllPersons() {
		return personService.findAll();
	}
	
	//Create a new person based on an object
	//has to have, name, firstName, age, balance, country
	@PostMapping("/createperson")
	public Person createNewPerson(@RequestBody Person person) throws InvalidPersonException {
		return personService.savePerson(person);
	}
	
	//Delete person based on {id}
	@DeleteMapping("/deleteperson/{id}")
	public void deletePerson(@PathVariable("id") String id) {
		personService.deletePersonById(id);
	}
	
	//DO NOT SEND JSON, STRAIGHT THE BALANCE!
	//Set person balance
	@PostMapping("/setbalance/{id}")
	public void setBalance(@PathVariable("id") String id, @RequestBody int balance) {
		personService.updateBalance(id, balance);
	}
	
	//DO NOT SEND JSON, STRAIGHT THE BALANCE!
	//Add balance to the person based on their existing balance.
	@PostMapping("/addbalance/{id}")
	public void addBalance(@PathVariable("id") String id, @RequestBody int balanceToAdd) {
		personService.addToBalance(id, balanceToAdd);
	}
	
	//Return person based on {id}
	@GetMapping("/getperson/{id}")
	public Optional<Person> getPerson(@PathVariable("id") String id) {
		return personService.getPerson(id);
	}
	
	//Return person based on {id}
	@GetMapping("/getbalance/{id}")
	public int getBalance(@PathVariable("id") String id) {
		return personService.getPerson(id).get().getBalance();
	}
	
	//Test route
	@GetMapping("/test")
	public String test() {
		return "hey";
	}

}
