package Adminstration;

import java.util.*;

import Colleges.*;

public class AllotmentList {
	ArrayList <String> allotmentList= new ArrayList<>();
	PrivateCollegesList privateColleges = new PrivateCollegesList();
	UniversityCollegesList universities = new UniversityCollegesList();
	String yellow = "\u001B[33m";
	String green = "\u001B[32m";
	String red = "\u001B[31m";
	String reset = "\u001B[0m";
	String blue = "\u001B[94m";
	Scanner sc = new Scanner(System.in);
	public boolean setAllotmentList(int rank) {
		WebOptionsList webOptions = new WebOptionsList();
		webOptions.setWebOptionsList();
		webOptions.displayWebOptionsList();
		String collegeCourse;
		int option = 0;
		while(true) {
			int flag = 0;
			switch(option) {
			case 1 :
				System.out.println("Enter College Course : ");
				collegeCourse = sc.next();
				if(WebOptionsList.webOptionsList.contains(collegeCourse)) {
					allotmentList.add(collegeCourse);
					System.out.println(green + "----------Course Added SuccessFully-----------" + reset);
				}else {
					System.out.println(red + "Course Not Found Please Check Again " + reset);
				}
				break;
			case 2 : 
				System.out.println("Enter College Course : ");
				collegeCourse = sc.next();
				if(WebOptionsList.webOptionsList.contains(collegeCourse)) {
					System.out.println("Enter Position to insert College Course  : ");
					int pos = sc.nextInt() + 1;
					if(pos > WebOptionsList.webOptionsList.size()) {
						System.out.println(red + "Invalid Input position" + reset);
					}else {
						allotmentList.add(pos, collegeCourse);
						System.out.println(green + "---------Course Added SuccessFully---------" + reset);
					}
				}else {
					System.out.println(red + "Course Not Found Please Check Again " + reset);
				}
				break;
			case 3 :
				System.out.println("Enter College Course : ");
				collegeCourse = sc.next();
				if(WebOptionsList.webOptionsList.contains(collegeCourse) && allotmentList.contains(collegeCourse)) {
					System.out.println(green + "Course Remove SuccessFully" + reset);
					allotmentList.remove(collegeCourse);
				}else {
					System.out.println(red + "Course Not Found Please Check Again " + reset);
				}
				break;
			case 4 :
				for(int i = 0;i < allotmentList.size();i++) {
					String collegeName = allotmentList.get(i).substring(0,4);
					String branchName = allotmentList.get(i).substring(4,7);
					if(privateColleges.validCollege(collegeName, branchName,rank)) {
						return true;
					}else if(universities.validCollege(collegeName, branchName,rank)){
						return true;
					}
				}
				System.out.println(red + "Sorry\nYou are not eligable for any course" + reset);
				break;
			case 6 :
				flag = 1;
				break;
			case 5:
				for(int i = 0;i < allotmentList.size();i++) {
					System.out.println(allotmentList.get(i )+"   ");
				}
				break;
			default :
				System.out.println(red + "Invalid inpuut" + reset);
			}
				
			if(flag == 1) {
				break;
			}
			System.out.println(green + "Press :\n1 - add College course \t2 - add College course with Position\t3 - delete College Course\n4 - Submit\t5 - Show List \t6 - Exit " + reset + "\nEnter Choice : ");
			try {
				option = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Invalid input");
				return false;
			}
		}
		return true;
	}
	
}
