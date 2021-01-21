package com.capgemini.bean;

public class Student {

	private int studentRollNumber;
	private String studentName;
	private String[] studentCourses;
	
	public Student(int studentRollNumber, String studentName, String[] studentCourses) {
		super();
		this.studentRollNumber = studentRollNumber;
		this.studentName = studentName;
		this.studentCourses = studentCourses;
	}
	
	public Student() {}
	
	public int getStudentRollNumber() {
		return studentRollNumber;
	}
	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String[] getStudentCourses() {
		return studentCourses;
	}
	public void setStudentCourses(String[] studentCourses) {
		this.studentCourses = studentCourses;
	}
	
	
	
}
