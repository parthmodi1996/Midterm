package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	Section instOfSection = new Section();
	private UUID StudentID;
	private UUID EnrollmentID;
	private UUID SectionID = instOfSection.getSectionID();
	public double Grade;
	
	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}

	public double getGrade() {
		return Grade;
	}
	
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	
	public void setGrade(double grade) {
		Grade = grade;
	}
	
	/**
	 * No-arg Constructor for Enrollment
	 */
	
	public Enrollment(UUID StudentID, UUID SectionID) {
		this.StudentID = getStudentID();
		this.SectionID = getSectionID();
		UUID EnrollmentID = UUID.randomUUID();
		setEnrollmentID(EnrollmentID);
	}
	
}
