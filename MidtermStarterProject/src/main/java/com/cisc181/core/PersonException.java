package com.cisc181.core;

public class PersonException extends Exception {
	private Person Person;

	public Person getPerson() {
		return Person;
	}
	
	public PersonException(Person Person) {
		super("\n" + "Invalid Input" + "\n");
		this.Person = Person;
	}
}
