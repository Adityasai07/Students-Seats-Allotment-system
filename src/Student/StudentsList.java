package Student;

import java.util.*;

public class StudentsList {
	String hallTicketNo;
	Scanner sc = new Scanner(System.in);
	static HashMap<String,Student> studentsList= new HashMap<>();
	@Override
	public String toString() {
		return "StudentsList [hallTicketNo=" + hallTicketNo + ", studentsList=" + studentsList + "]";
	}
	
	public String getHallTicketNo() {
		return hallTicketNo;
	}
	public void setHallTicketNo(String hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	public HashMap<String, Student> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(HashMap<String, Student> studentsList) {
		for (Map.Entry<String, Student> entry : studentsList.entrySet()) {
            StudentsList.studentsList.put(entry.getKey(), entry.getValue());
        }
	}
	public void displayStudentsList() {
		for (Map.Entry<String, Student> entry : studentsList.entrySet()) {
            System.out.println("Hall Ticket : " + entry.getKey());
            Student s = entry.getValue();
            System.out.println("Phone Number : " + s.phoneNumber);
            System.out.println("Rank : " + s.rank);
        } 
	}
	
}
