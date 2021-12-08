package me.niv.backend.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Unwrapped.Nullable;

import com.mongodb.lang.NonNull;

@Document(collection = "persons")
public class Person {

	@Id
	private String id;
	
	private String name;
	private String familyName;
	private int age;
	private int balance;
	private String country;
	
	public Person(String name, String familyName, int age, int balance, String country) {
		this.name = name;
		this.familyName = familyName;
		this.age = age;
		this.balance = balance;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return this.country;
	}

	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
