package Student;

import java.util.*;

public class RegestrationPage {
	Scanner sc = new Scanner(System.in);
	String yellow = "\u001B[33m";
	String green = "\u001B[32m";
	String red = "\u001B[31m";
	String reset = "\u001B[0m";
	String blue = "\u001B[94m";
	public boolean defaultRegesteredStudents() {
		String hallTicketNumbers[] = {"21B91A05J2","21B91A05I2","21B91A05G8","21B91A05H2","21B91A05H1"};
		int ranks[] = {100,101,200,8181,500};
		String[] phoneNumbers = {"9866475844","9876543210","6303036668","8500402044","8331814243"};
		String [] passwords = {"loki@18","ashish@143","naresh@g8","aditya@07","mani@1111"};
		HashMap<String,Student> studentsList= new HashMap<>();
		StudentsList sList = new StudentsList();
		for(int i = 0;i < ranks.length;i++) {
			Student student = new Student();
			student.rank = ranks[i];
			student.phoneNumber = phoneNumbers[i];
			student.password = passwords[i];
			studentsList.put(hallTicketNumbers[i], student);
		}
		sList.setStudentsList(studentsList);
		return true;
	}
	public boolean studentRegestration() {
		StudentsList sList = new StudentsList();
		String hallTicketNo;
		HashMap<String,Student> studentsList= sList.getStudentsList();
		while(true) {
			System.out.println(yellow + "Enter The HallTicket Number : " + reset);
			hallTicketNo = sc.next();
			if(studentsList.containsKey(hallTicketNo)) {
				System.out.println(red + "HallTicket number Already exists" + reset);
			}else {
				break;
			}
		}
		System.out.println(yellow + "Enter Rank :"  + reset);
		int rank = sc.nextInt();
		System.out.println(yellow + "Enter Phone Number : " + reset);
		String phoneNumber = sc.next();
		while(true) {
			if(phoneNumber.length() != 10) {
				System.out.println(red + "Enter Valid Number : " + reset);
				phoneNumber = sc.next();
			}else {
				break;
			}
		}
		System.out.println(yellow + "Enter password : " + reset);
		String password = sc.next();
		System.out.println(yellow + "Enter password again to Conform : " + reset);
		String conformPassword = sc.next();
		Student student = new Student();
		student.rank = rank;
		student.phoneNumber = phoneNumber;
		while(true) {
			if(password.equals(conformPassword)) {
				student.password = password;
				break;
			}else {
				System.out.println(red + "Invalid \n " + reset + yellow +  "Reenter Password Again : " + reset);
				password = sc.next();
				System.out.println(yellow + "Enter password again to Conform : " + reset);
				conformPassword = sc.next();
			}
		}
		studentsList.put(hallTicketNo,student);
		sList.setStudentsList(studentsList);
		return true;
	}
}
