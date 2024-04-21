package Adminstration;

import java.util.Scanner;

import Student.*;

public class StudentsInitiator {
	Scanner sc2 = new Scanner(System.in);
	public int rank;
	String green = "\u001B[32m";
	String red = "\u001B[31m";
	String reset = "\u001B[0m";
	String blue = "\u001B[94m";
	public void allotment(int rank) {
		StudentsInitiator student = new StudentsInitiator();
		System.out.println("Select Web Options from List : ");
		this.rank = rank;
		AllotmentList allotmentList = new AllotmentList();
		if(!allotmentList.setAllotmentList(this.rank)) {
			student.allotment(rank);
		}
	}
	public boolean logIn() {
		LogInPage login = new LogInPage();
		StudentsInitiator student = new StudentsInitiator();
		int rank = login.loginStudent();
		if(rank == -1) {
			return false;
		}
		student.allotment(rank);
		return true;
	}
	public boolean regestration() {
		RegestrationPage register = new RegestrationPage();
		StudentsInitiator student = new StudentsInitiator();
		register.studentRegestration();
		System.out.println("Press 1 to Log In \nPress Any Number to Exit");
		int choice = 0;
		choice = sc2.nextInt();
		if(choice == 1) {
			student.logIn();
		}
		return true;
	}
	public boolean initiator() {
		StudentsInitiator student = new StudentsInitiator();
		RegestrationPage register = new RegestrationPage();
		int studentChoice = 5;
		register.defaultRegesteredStudents();
		while(true) {
			int flag = 0;
			switch(studentChoice) {
			case 1:
				student.logIn();
				break;
			case 2 :
				student.regestration();
				break;
			case 3 : 
				flag = 1;
				break;
			}
			if(flag == 1) {
				break;
			}else {
				System.out.println(green  + "Press 1 - Student LogIn \nPress 2 - Student SignUp\nPress 3 to Exit" + reset);
				System.out.println("Enter Choice : ");
				studentChoice = sc2.nextInt();
			}
		}
		return true;
	}
}
