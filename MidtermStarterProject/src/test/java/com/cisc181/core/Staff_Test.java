package com.cisc181.core;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAverageSalary() {
		ArrayList<Staff> myList = new ArrayList<Staff>();
		Staff salary1 = new Staff(null, null, null, null, null, null, null, null, 0, 2500, null, null);
		Staff salary2 = new Staff(null, null, null, null, null, "1234567", null, null, 0, 1500, null, null);
		Staff salary3 = new Staff(null, null, null, null, null, null, null, null, 0, 2000, null, null);
		Staff salary4 = new Staff(null, null, null, null, null, null, null, null, 0, 4000, null, null);
		Staff salary5 = new Staff(null, null, null, null, null, null, null, null, 0, 3000, null, null);
		myList.add(salary1);
		myList.add(salary2);
		myList.add(salary3);
		myList.add(salary4);
		myList.add(salary5);
		int average = (int) ((salary1.getSalary() + salary2.getSalary() + salary3.getSalary() + salary4.getSalary() + salary5.getSalary())/5);
		assertEquals("Test average salary", average, 2600);		
	}
	@Test
	public void testPhoneNumber() throws PersonException {
		Staff myTest = new Staff(null, null, null, null, null, null, null, null, 0, 0, null, null);
		myTest.setPhone("1234567890");
		myTest.setPhone("12345");
	}
	@Test
	public void testDOB () throws PersonException {
		Calendar c = Calendar.getInstance();
		c.set(1394, 03, 04);
		Date TestDate = c.getTime();
		Staff myTest = new Staff(null, null, null, null, null, null, null, null, 0, 0, null, null);
		myTest.setDOB(TestDate);
	}
}
