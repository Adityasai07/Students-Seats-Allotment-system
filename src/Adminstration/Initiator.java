package Adminstration;

import java.util.*;

import Colleges.PrivateCollegesList;
import Colleges.UniversityCollegesList;

public class Initiator {
	public static void main(String args[]) {
		StudentsInitiator student = new StudentsInitiator();
		CollegeInitiator college = new CollegeInitiator();
		PrivateCollegesList p = new PrivateCollegesList();
		p.setDefaultColleges();
		UniversityCollegesList u = new UniversityCollegesList();
		u.setDefaultColleges();
		int choice = 0;
		String green = "\u001B[32m";
		String red = "\u001B[31m";
		String reset = "\u001B[0m";
		while(true) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println(green + "Press 1 - Student \nPress 2 - College\nPress 3 to Exit" + reset);
			System.out.println("Enter Choice : ");
			choice = Integer.parseInt(sc1.nextLine());
			int flag = 0;
			switch(choice) {
			case 1:
				student.initiator();
				break;
			case 2 :
				college.initiator();
				break;
			case 3 : 
				flag = 1;
				break;
			default :
				System.out.println();	
			}
			if(flag == 1) {
				System.out.println(red + "Thank You" + reset);
				sc1.close();
				break;
			}
		}
	}
}
