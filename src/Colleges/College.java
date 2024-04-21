package Colleges;
import java.util.*;
public class College {
	public String CollegeCode;
	String CollegeName;
	public double collegeFee;
	public double getCollegeFee() {
		return collegeFee;
	}
	public void setCollegeFee(double collegeFee) {
		this.collegeFee = collegeFee;
	}
	ArrayList <Branch> BranchesList = new ArrayList<>();
	public String getCollegeName() {
		return CollegeName;
	}
	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}
	public String getCollegeCode() {
		return CollegeCode;
	}
	public void setCollegeCode(String collegeCode) {
		CollegeCode = collegeCode;
	}
	public ArrayList<Branch> getBranchesList() {
		return BranchesList;
	}
	public void setBranchesList(ArrayList<Branch> branchesList) {
		BranchesList = branchesList;
	}
	
	
	
}
