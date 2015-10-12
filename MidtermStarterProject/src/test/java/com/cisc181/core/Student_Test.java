package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {		
	//Create Array-List for Course
	ArrayList<Course> myCourse = new ArrayList<Course>(3);
	//Create UUID for each Course
	UUID CiscID = UUID.randomUUID();
	UUID PhysID = UUID.randomUUID();
	UUID ChemID = UUID.randomUUID();
	//Create each course
	Course Cisc = new Course(CiscID, "CISC", 3, eMajor.COMPSI);
	Course Phys = new Course(PhysID, "Physics", 4, eMajor.PHYSICS);
	Course Chem = new Course(ChemID, "Chemistry", 3, eMajor.CHEM);
	//Append Courses to myCouse arraylist
	myCourse.add(Cisc);
	myCourse.add(Phys);
	myCourse.add(Chem);
	
	//Create mySemester ArrayList
	ArrayList<Semester> mySemester = new ArrayList<Semester>(2);
	//Create UUID for each Semester
	UUID FallID = UUID.fromString("Fall-Sem");
	UUID SpringID = UUID.fromString("Spring-Sem");
	//Create instance of each semester
	Semester Fall = new Semester(FallID, null, null);
	Semester Spring = new Semester(SpringID, null, null);
	//Add each semester to the arraylist
	mySemester.add(Spring);
	mySemester.add(Fall);
	
	//Create arryalist for section
	ArrayList<Section> mySection = new ArrayList<Section>(6);
	//Create UUID for each section
	UUID FirstSection = UUID.randomUUID();
	UUID SecondSection = UUID.randomUUID();
	UUID ThirdSection = UUID.randomUUID();
	UUID FourthSection = UUID.randomUUID();
	UUID FifthSection = UUID.randomUUID();
	UUID SixthSection = UUID.randomUUID();
	//Create each section
	Section Section1 = new Section(FallID, CiscID, FirstSection, 0);
	Section Section2 = new Section(FallID, PhysID, SecondSection, 0);
	Section Section3 = new Section(FallID, ChemID, ThirdSection, 0);
	Section Section4 = new Section(SpringID, CiscID, FourthSection, 0);
	Section Section5 = new Section(SpringID, PhysID, FifthSection, 0);
	Section Section6 = new Section(SpringID, ChemID, SixthSection, 0);
	//Add each section to class mySection
	mySection.add(Section1);
	mySection.add(Section2);
	mySection.add(Section3);
	mySection.add(Section4);
	mySection.add(Section5);
	mySection.add(Section6);
			
	//Create Student Record
	ArrayList<Student> myStudent = new ArrayList<Student>(10);
	Student Happy = new Student("Happy", null, null, null, eMajor.COMPSI, null, null, null);
	Student Angry = new Student("Angry", null, null, null, eMajor.PHYSICS, null, null, null);
	Student Excited = new Student("Excited", null, null, null, eMajor.CHEM, null, null, null);
	Student Sad = new Student("Sad", null, null, null, eMajor.COMPSI, null, null, null);
	Student Crazy = new Student("Crazy", null, null, null, eMajor.CHEM, null, null, null);
	Student Good = new Student("Good", null, null, null, eMajor.PHYSICS, null, null, null);
	Student Bad = new Student("Bad", null, null, null, eMajor.PHYSICS, null, null, null);
	Student Nerd = new Student("Nerd", null, null, null, eMajor.COMPSI, null, null, null);
	Student Player = new Student("Player", null, null, null, eMajor.COMPSI, null, null, null);
	Student Me = new Student("Me", null, null, null, eMajor.CHEM, null, null, null);
	myStudent.add(Happy);
	myStudent.add(Angry);
	myStudent.add(Excited);
	myStudent.add(Sad);
	myStudent.add(Crazy);
	myStudent.add(Good);
	myStudent.add(Bad);
	myStudent.add(Nerd);
	myStudent.add(Player);
	myStudent.add(Me);
	
	//Change major of One student record
	Happy.setMajor(eMajor.NURSING);
	myStudent.remove(0);
	myStudent.add(Happy);
	
	//Create UUID for each student 
	UUID Student1 = UUID.randomUUID();
	UUID Student2 = UUID.randomUUID();
	UUID Student3 = UUID.randomUUID();
	UUID Student4 = UUID.randomUUID();
	UUID Student5 = UUID.randomUUID();
	UUID Student6 = UUID.randomUUID();
	UUID Student7 = UUID.randomUUID();
	UUID Student8 = UUID.randomUUID();
	UUID Student9 = UUID.randomUUID();
	UUID Student10 = UUID.randomUUID();
	
	//Enroll each student
	Enrollment Enrollment1 = new Enrollment(Student1, FirstSection);
	Enrollment Enrollment2 = new Enrollment(Student2, SecondSection);
	Enrollment Enrollment3 = new Enrollment(Student3, ThirdSection);
	Enrollment Enrollment4 = new Enrollment(Student4, SecondSection);
	Enrollment Enrollment5 = new Enrollment(Student5, SixthSection);
	Enrollment Enrollment6 = new Enrollment(Student6, FifthSection);
	Enrollment Enrollment7 = new Enrollment(Student7, FourthSection);
	Enrollment Enrollment8 = new Enrollment(Student8, FifthSection);
	Enrollment Enrollment9 = new Enrollment(Student9, ThirdSection);
	Enrollment Enrollment10 = new Enrollment(Student10, SecondSection);
	
	//Set grade values for each student
	Enrollment1.setGrade(89);
	Enrollment2.setGrade(78);
	Enrollment3.setGrade(94);
	Enrollment4.setGrade(72);
	Enrollment5.setGrade(95);
	Enrollment6.setGrade(84);
	Enrollment7.setGrade(68);
	Enrollment8.setGrade(91);
	Enrollment9.setGrade(88);
	Enrollment10.setGrade(82);
	
	//Calculate gpa for each student
	double GPA1 = Math.round(Enrollment1.getGrade()*4*100d)/100d;
	double GPA2 = Math.round(Enrollment2.getGrade()*4*100d)/100d;
	double GPA3 = Math.round(Enrollment3.getGrade()*4*100d)/100d;
	double GPA4 = Math.round(Enrollment4.getGrade()*4*100d)/100d;
	double GPA5 = Math.round(Enrollment5.getGrade()*4*100d)/100d;
	double GPA6 = Math.round(Enrollment6.getGrade()*4*100d)/100d;
	double GPA7 = Math.round(Enrollment7.getGrade()*4*100d)/100d;
	double GPA8 = Math.round(Enrollment8.getGrade()*4*100d)/100d;
	double GPA9 = Math.round(Enrollment9.getGrade()*4*100d)/100d;
	double GPA10 = Math.round(Enrollment10.getGrade()*4*100d)/100d;
	
	//GPA values for each student
	double ans1 = 3.56;
	double ans2 = 3.12;
	double ans3 = 3.76;
	double ans4 = 2.88;
	double ans5 = 3.80;
	double ans6 = 3.36;
	double ans7 = 2.72;
	double ans8 = 3.64;
	double ans9 = 3.52;
	double ans10 = 3.28;
	
	//Check GPA values for each student
	assertEquals(GPA1, ans1, 1);
	assertEquals(GPA2, ans2, 1);
	assertEquals(GPA3, ans3, 1);
	assertEquals(GPA4, ans4, 1);
	assertEquals(GPA5, ans5, 1);
	assertEquals(GPA6, ans6, 1);
	assertEquals(GPA7, ans7, 1);
	assertEquals(GPA8, ans8, 1);
	assertEquals(GPA9, ans9, 1);
	assertEquals(GPA10, ans10, 1);
	
	}
	
}
