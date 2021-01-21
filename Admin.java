package com.capgemini.view;

import java.util.Scanner;

import com.capgemini.service.StudentScheduler;

public class Admin {
	
	private static Scanner s = new Scanner(System.in);

	private static StudentScheduler studSch = new StudentScheduler();
	
	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		int choice;
		while(true) {
			
			System.out.println("\n1.Add student");
			System.out.println("2.Show all students");
			System.out.println("3.Reports");
			System.out.println("4.Show students as per course");
			System.out.println("5.Show count of students enrolled in courses");
			System.out.println("6.Exit");
			
			System.out.println("Enter your choice");
			choice=s.nextInt();
		       
			switch(choice) {
			
			case 1: addStudentDetails();
			break;
			
			case 2: showAllStudentDetails();
			break;
			
			case 3: showStudentAsPerRollNumber();
			break;
			
			case 4: showStudentAsPerCourse();
			break;
			
			case 5: showCountOfCourses();
			break;
			
			case 6: System.exit(0);
			break;
			
			default: System.out.println("Sorry your choice entered is wrong. Please try again.");
			
			}
		}
	}

	private static void showCountOfCourses() {
		
		System.out.println("Enter the course name whose count you need to know: ");
		String courseName = s.next();
		
		studSch.showCountOfstudentForCourses(courseName);
	}

	private static void showStudentAsPerCourse() {
		
		System.out.println("Enter course of your choice: ");
		String courseName = s.next();
		
		studSch.showStudentDetailsAsPerCourse(courseName);
	}

	private static void showStudentAsPerRollNumber() {
		
		System.out.println("Enter roll number of your choice: ");
		int rollNumber = s.nextInt();
		
		studSch.showStudentDetailsAsPerRollNumber(rollNumber);
	}

	private static void showAllStudentDetails() {
		
			studSch.showAllStudentDetails();
	}

	private static void addStudentDetails() {
		
		System.out.println("Enter Student's Roll Number: ");
		int rollNumber=s.nextInt();
		
			System.out.println("Enter Student's Name: ");
			String name = s.next();
			
			System.out.println("How many course(s) do you want?: ");
			int numberOfCourses = s.nextInt();
			String [] courseString = new String[numberOfCourses];
			System.out.println("Enter course(s) of your choice: ");
			for(int j=0;j<numberOfCourses;j++) {
				courseString[j] = s.next();
		    }
			System.out.println(studSch.addStudent(rollNumber, name, courseString));
	  }
}
		
		


