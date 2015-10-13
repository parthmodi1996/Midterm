package com.cisc181.core;

public class PersonException extends Exception {
	private Person Person;

	public Person getPerson() {
		return Person;
	}
	//Create custom exception
	public PersonException(Person Person) {
		super("\n" + "Invalid Input: Please provide correct input" + "\n");
		this.Person = Person;
	}
}
