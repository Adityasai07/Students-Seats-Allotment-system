package Student;

import java.util.*;

public class LogInPage {
	Scanner sc = new Scanner(System.in);
	String green = "\u001B[32m";
	String red = "\u001B[31m";
	String reset = "\u001B[0m";
	String blue = "\u001B[96m";
	public int loginStudent() {
		System.out.println(blue + "Enter HallTicket No : " + reset);
		String hallTicketNo = sc.next();
		HashMap<String,Student> studentsList = new HashMap<>();
		StudentsList sList = new StudentsList();
		studentsList = sList.getStudentsList();
		int rank = 999999;
		int check = 0;
		while(true) {
			for (Map.Entry<String, Student> entry : studentsList.entrySet()) {
				if(entry.getKey().equals(hallTicketNo)) {
					System.out.println(blue + "Enter Password : " + reset);
					String password = sc.next();
					while(true) {
						if(entry.getValue().password.equals(password)) {
							check = 1;
							System.out.println(blue + "----------------LogIn Successfull----------------" + reset);
							System.out.println(blue + "*****************Student Details*****************" + reset);
							System.out.print(blue + "HallTicket Number	: " + reset);
							System.out.println(entry.getKey());
							System.out.print(blue + "Rank 			: " + reset);
							System.out.println(entry.getValue().rank);
							System.out.print(blue + "Phone Number 		: " + reset);
							System.out.println(entry.getValue().phoneNumber);
							System.out.println(green + "Press 1 - To Select Web Options\nPress 2 - To Exit" + reset);
							int proceed = 0;
							System.out.println("Enter Choice : ");
							proceed = sc.nextInt();
							if(proceed == 1) {
								rank = entry.getValue().rank;
								break;
							}else {
								return -1;
							}
						}else {
							System.out.println(red + "Incorrect Password\n" +  reset + "Enter Password Again : ");
							password = sc.next();
						}
					}
				}
			}
			if(check != 1) {
				System.out.println(red + "Invalid HallTicket No\n" + reset + "Enter HallTicket Number Again : ");
				hallTicketNo = sc.next();
			}else {
				break;
			}
		}
		return rank;
	}
}
