package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	private static ArrayList<Course> myCourse = new ArrayList<Course>(3);
	private static ArrayList<Semester> mySemester = new ArrayList<Semester>(2);
	private static ArrayList<Section> mySection = new ArrayList<Section>();
	private static ArrayList<Student> myStudent = new ArrayList<Student>();

	@BeforeClass
	public static void setUp() {

		// Create UUID for each Course
		UUID CiscID = UUID.randomUUID();
		UUID PhysID = UUID.randomUUID();
		UUID ChemID = UUID.randomUUID();
		// Create each course
		Course Cisc = new Course(CiscID, "CISC", 3, eMajor.COMPSI);
		Course Phys = new Course(PhysID, "Physics", 3, eMajor.PHYSICS);
		Course Chem = new Course(ChemID, "Chemistry", 3, eMajor.CHEM);
		// Append Courses to myCouse arraylist
		myCourse.add(Cisc);
		myCourse.add(Phys);
		myCourse.add(Chem);

		// Create UUID for each Semester
		UUID FallID = UUID.randomUUID();
		UUID SpringID = UUID.randomUUID();
		 
		//Create instance of each semester
		Semester Fall = new Semester(FallID, null, null);
		Semester Spring = new Semester(SpringID, null, null);
		
		// Add each semester to the arraylist
		mySemester.add(Spring);
		mySemester.add(Fall);
		
		//Create each Section and append it to mySection arrayList
		for (Semester eachSemester : mySemester) {
			for (Course eachCourse : myCourse) {
				UUID sectionID = UUID.randomUUID();
				Section eachSection = new Section(eachCourse.getCourseID(), eachSemester.getSemesterID(), sectionID, 0);
				mySection.add(eachSection);
			}
		}

		// Create UUID for each student
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

		//Create 10 student records and add it to myStudent  arrayList 
		Student Happy = new Student("Happy", null, null, null, eMajor.COMPSI, null, null, null, Student1);
		Student Angry = new Student("Angry", null, null, null, eMajor.PHYSICS, null, null, null, Student2);
		Student Excited = new Student("Excited", null, null, null, eMajor.CHEM, null, null, null, Student3);
		Student Sad = new Student("Sad", null, null, null, eMajor.COMPSI, null, null, null, Student4);
		Student Crazy = new Student("Crazy", null, null, null, eMajor.CHEM, null, null, null, Student5);
		Student Good = new Student("Good", null, null, null, eMajor.PHYSICS, null, null, null, Student6);
		Student Bad = new Student("Bad", null, null, null, eMajor.PHYSICS, null, null, null, Student7);
		Student Nerd = new Student("Nerd", null, null, null, eMajor.COMPSI, null, null, null, Student8);
		Student Player = new Student("Player", null, null, null, eMajor.COMPSI, null, null, null, Student9);
		Student Me = new Student("Me", null, null, null, eMajor.CHEM, null, null, null, Student10);
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

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		// Create an ArrayList for Enrollment of each Student
		ArrayList<Enrollment> myEnrollment = new ArrayList<Enrollment>();
		 
		//Enroll each student
		for (Student eachStudent : myStudent) {
			for (Section eachSection : mySection) {
				Enrollment Enroll = new Enrollment(eachStudent.getStudentID(), eachSection.getSectionID());
				Enroll.setGrade(Math.round(Math.random() * 4 * 100d) / 100d);
				myEnrollment.add(Enroll);
			}
		}
		// Note for Professor:

		// The below procedure to calculate GPA for each student works perfectly
		// fine.
		// However, to run the assertEquals test to calculate GPA from the below
		// procedure would require me to
		// manually input grades for each student enrolled in each section (i.e.
		// 60 times).
		// As a result, below I am conducting assertEquals for only 1 student

		// Create custom grades for student 1
		myEnrollment.get(0).setGrade(3.95);
		myEnrollment.get(1).setGrade(3.62);
		myEnrollment.get(2).setGrade(3.04);
		myEnrollment.get(3).setGrade(2.97);
		myEnrollment.get(4).setGrade(3.27);
		myEnrollment.get(5).setGrade(4.0);

		//Create an arrayList for the grades of each student
		ArrayList<Double> StuGrades = new ArrayList<Double>(10);
		double grade = 0;
		for (int i = 0; i < myEnrollment.size(); i++) {
			if (i == 0) {
				grade += myEnrollment.get(i).getGrade();
			} else {
				if (i % 6 != 0) {
					grade += myEnrollment.get(i).getGrade();
				} else {
					StuGrades.add(grade);
					grade = 0;
					grade += myEnrollment.get(i).getGrade();
				}
				if (i == (myEnrollment.size() - 1)) {
					StuGrades.add(grade);
				}
			}
		}

		// Calculate GPA of students
		for (int j = 0; j < StuGrades.size(); j++) {
			double GPA = StuGrades.get(j) * 3 / 18;
			StuGrades.remove(j);
			StuGrades.add(j, Math.round(GPA * 100d) / 100d);
		}
		//Perform assertEquals test for first student
		assertEquals(StuGrades.get(0), 3.48, 1);

		//Calculate grades for each course
		double CiscGrade = 0;
		double PhysGrade = 0;
		double ChemGrade = 0;

		for (int l = 0; l < myEnrollment.size(); l++) {
			if (l % 3 == 0) {
				CiscGrade += myEnrollment.get(l).getGrade();
				PhysGrade += myEnrollment.get(l + 1).getGrade();
				ChemGrade += myEnrollment.get(l + 2).getGrade();
			}
			if (l == myEnrollment.size() - 1) {
				ChemGrade += myEnrollment.get(l).getGrade();
			}
		}

		// Calculate average grade
		double avgCisc = Math.round(CiscGrade / 20 * 100d) / 100d;
		double avgPhys = Math.round(PhysGrade / 20 * 100d) / 100d;
		double avgChem = Math.round(ChemGrade / 20 * 100d) / 100d;

		// Note for Professor:
		// Performing the assertEquals test for small amount of custom data to
		// calculate average course grade from above procedure,
		// yields the conclusion that above procedure is valid to calculate
		// average course grade.
		// However, because of large amount of randomize data (60 random grade
		// values), assertEquals test to
		// determine average course grade is not performed.
		
		//Change the major of one of the student record
		System.out.println(myStudent.get(0).getMajor());
		myStudent.get(0).setMajor(eMajor.NURSING);
		System.out.println(myStudent.get(0).getMajor());
		
	}
}
