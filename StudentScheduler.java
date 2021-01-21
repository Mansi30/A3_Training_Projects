package com.capgemini.service;

import com.capgemini.bean.Student;

public class StudentScheduler {

	private Student[] student = new Student[10];
	private int counterStudent;
	
	public String addStudent(int studentRollNumber, String studentName, String[] studentCourse) {
		
		student[counterStudent++] = new Student(studentRollNumber,studentName,studentCourse);
		
		return "Student's record added successfully.";
	}
	    
    public void showAllStudentDetails() {
    	
    	for(int i=0;i<counterStudent;i++) 
    	{
       		System.out.println("Student's Roll Number: "+student[i].getStudentRollNumber());
    		System.out.println("Student's Name: "+student[i].getStudentName());
    		System.out.println("Student's Course(s): ");
			for(String course:student[i].getStudentCourses())
			{
				System.out.print("\t"+course);
			}
       	}
      }
    
    public void showStudentDetailsAsPerRollNumber(int rollNumber) {
    	
    	for(int i=0;i<counterStudent;i++) {
    		
    		if(student[i].getStudentRollNumber() == rollNumber) {
    			System.out.println("Student's Roll No: "+student[i].getStudentRollNumber());
        		System.out.println("Student's Name: "+student[i].getStudentName());
        		System.out.println("Student's Course(s): ");
    			for(String course:student[i].getStudentCourses())
    			{
    				System.out.print("\t"+course);
    			}
    		}else {
    			System.out.println("Roll number not valid. Please try again.");
    		}
    	}
    }
    
    public void showStudentDetailsAsPerCourse(String courseName) {
    	String [] course;
    	for(int i=0;i<counterStudent;i++) {
    		course = student[i].getStudentCourses();
    		for(int j=0;j<course.length;j++) {
    			if(course[j].equals(courseName)) {
    				System.out.println("Student's Roll No: "+student[i].getStudentRollNumber());
            		System.out.println("Student's Name: "+student[i].getStudentName());
            		System.out.println("Student's Course(s): ");
        			for(String courses:student[i].getStudentCourses())
        			{
        				System.out.print("\t"+courses);
        			}
    			}
    		}
       	}
    }
    
    public void showCountOfstudentForCourses(String courseCount) {
    	String[] courses;
    	for(int i=0;i<counterStudent;i++) {
    		courses = student[i].getStudentCourses();
    		int numberOfCourse = courses.length;
    		
    		for(int j=0;j<courses.length;j++) {
    			if(courses[j].equals(courseCount)) {
    				j = numberOfCourse;
        			System.out.println("For " +courseCount+ " there are " +numberOfCourse+ " students.");
    			}
    		}
    	}
    }
}
