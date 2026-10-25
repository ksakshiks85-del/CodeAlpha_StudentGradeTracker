package codeAlpha_StudentGradeTracker;
import java.util.Scanner;

public class StudentGradeTracker {

	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);

	    // Enter the number of students
	    int n;

	    do {
	        System.out.print("Enter number of students: ");
	        while (!sc.hasNextInt()) {
	            System.out.println("Please enter a valid whole number.");
	            sc.next();
	            System.out.print("Enter number of students: ");
	        }
	        n = sc.nextInt();

	        if (n <= 0) {
	            System.out.println("Number of students must be greater than zero.");
	        }

	    } while (n <= 0);

	    // Arrays to store student names and marks
	    String[] names = new String[n];
	    double[] marks = new double[n];

	    double total = 0;
	    double highest = -1;
	    double lowest = 101;

	    // Input student details
	    for (int i = 0; i < n; i++) {

	        System.out.print("Enter student " + (i + 1) + " name: ");
	        names[i] = sc.next();

	        System.out.print("Enter marks for " + names[i] + " (0-100): ");

	        while (!sc.hasNextDouble()) {
	            System.out.println("Invalid input! Please enter numeric marks.");
	            sc.next();
	            System.out.print("Enter marks for " + names[i] + " (0-100): ");
	        }

	        marks[i] = sc.nextDouble();

	        while (marks[i] < 0 || marks[i] > 100) {
	            System.out.println("Marks must be between 0 and 100.");
	            System.out.print("Enter marks for " + names[i] + " (0-100): ");

	            while (!sc.hasNextDouble()) {
	                System.out.println("Invalid input! Please enter numeric marks.");
	                sc.next();
	                System.out.print("Enter marks for " + names[i] + " (0-100): ");
	            }

	            marks[i] = sc.nextDouble();
	        }

	        total += marks[i];

	        if (marks[i] > highest) {
	            highest = marks[i];
	        }

	        if (marks[i] < lowest) {
	            lowest = marks[i];
	        }
	    }

	    // Calculate average
	    double average = total / n;

	    // Display student report
	    System.out.println("\n========== STUDENT GRADE REPORT ==========");

	    System.out.printf("%-15s %-10s %-10s%n", "Student Name", "Marks", "Grade");
	    System.out.println("------------------------------------------");

	    for (int i = 0; i < n; i++) {

	        char grade;

	        if (marks[i] >= 90) {
	            grade = 'A';
	        } else if (marks[i] >= 80) {
	            grade = 'B';
	        } else if (marks[i] >= 70) {
	            grade = 'C';
	        } else if (marks[i] >= 60) {
	            grade = 'D';
	        } else {
	            grade = 'F';
	        }

	        System.out.printf("%-15s %-10.2f %-10c%n",
	                names[i], marks[i], grade);
	    }

	    // Display summary
	    System.out.println("------------------------------------------");
	    System.out.printf("Average Marks : %.2f%n", average);
	    System.out.printf("Highest Marks : %.2f%n", highest);
	    System.out.printf("Lowest Marks  : %.2f%n", lowest);

	    System.out.println("==========================================");

	    sc.close();
	}

	}

	