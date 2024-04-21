package Adminstration;

import java.util.*;

import Colleges.*;

public class CollegeInitiator {
	public boolean initiator() {
		Scanner sc3 = new Scanner(System.in);
		int collegeChoice = 5;
		String green = "\u001B[32m";
		String red = "\u001B[31m";
		String reset = "\u001B[0m";
		String blue = "\u001B[96m";
		PrivateCollegesList privateCollege = new PrivateCollegesList();
		UniversityCollegesList  university = new UniversityCollegesList();
		while(true) {
			int flag = 0;
			switch(collegeChoice) {
			case 1 :
				int type = 0;
				System.out.println(blue + "TO Insert : \nUniversity - press 1\tPrivate college - Press 2" + reset);
				type = sc3.nextInt();
				if(type == 1) {
					university.setUniversityColleges();
				}else if(type == 2) {
					privateCollege.setPrivateColleges();
				}else {
					System.out.println("Invalid ");
				}
				break;
			case 2 :
				int type2 = 0;
				System.out.println(blue + "TO Delete : \nUniversity - Press 1\tPrivate college - Press 2" + reset);
				type2 = sc3.nextInt();
				if(type2 == 1) {
					university.removeCollege();
				}else if(type2 == 2) {
					privateCollege.removeCollege();
				}else {
					System.out.println("Invalid ");
				}
				break;
			case 3 :
				int type3 = 0;
				System.out.println(blue + "TO Update : \nUniversity - Press 1\tPrivate college - Press 2" + reset);
				type3 = sc3.nextInt();
				if(type3 == 1) {
					university.updateCollegeList();
				}else if(type3 == 2) {
					privateCollege.updateCollegeList();
				}else {
					System.out.println(red + "Invalid " + reset);
				}
				break;
			case 4 :
				flag = 1;
				break;
			default :
				flag = 0;
			}
			if(flag == 1) {
				break;
			}else {
				System.out.println(green + "Press 1 - insert College\tPress 2 to Delete College\tPress 3 to Update College Data\nPress 4 to Exit " + reset);
				System.out.println("Enter Choice : ");
				collegeChoice = sc3.nextInt();
			}
		}
		return true;
	}
}
