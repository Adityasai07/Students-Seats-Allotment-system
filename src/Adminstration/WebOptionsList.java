package Adminstration;

import java.util.*;

import Colleges.*;

public class WebOptionsList {
	static ArrayList<String> webOptionsList = new ArrayList<String>();
	UniversityCollegesList u = new UniversityCollegesList();
	PrivateCollegesList p = new PrivateCollegesList();
	String yellow = "\u001B[33m";
	String green = "\u001B[32m";
	String red = "\u001B[31m";
	String reset = "\u001B[0m";
	String blue = "\u001B[94m";
	@Override
	public String toString() {
		return "WebOptionsList [webOptionsList=" + webOptionsList + "]";
	}
	HashSet<College>universityCollegeList = new HashSet<College>();
	HashSet<College>privateCollegeList = new HashSet<College>();
	public void setPrivateCollegeList(HashSet<College> privateCollegeList) {
		this.privateCollegeList = privateCollegeList;
	}

	public ArrayList<String> getWebOptionsList() {
		return webOptionsList;
	}

	public void setWebOptionsList(ArrayList<String> webOptionsList) {
		WebOptionsList.webOptionsList = webOptionsList;
	}

	public HashSet<College> getUniversityCollegeList() {
		return universityCollegeList;
	}

	public void setUniversityCollegeList(HashSet<College> universityCollegeList) {
		this.universityCollegeList = universityCollegeList;
	}

	public boolean setWebOptionsList() {
		universityCollegeList = u.getUniversityCollegeList();
		for(College college : universityCollegeList) {
			ArrayList<Branch> branchList = college.getBranchesList();
			for(int i = 0;i < branchList.size();i++) {
				String b = branchList.get(i).getBranchName();
				String result = college.getCollegeCode().concat(b);
				webOptionsList.add(result);
			}
		}
		privateCollegeList = p.getPrivateCollegeList();
		for(College college : privateCollegeList) {
			ArrayList<Branch> branchList = college.getBranchesList();
			for(int i = 0;i < branchList.size();i++) {
				String b = branchList.get(i).getBranchName();
				String result = college.getCollegeCode().concat(b);
				webOptionsList.add(result);
			}
		}
		return true;
	}
	public void displayAllCollegesInformation() {
		u.displayCollegeList();
		p.displayCollegeList();
	}
	public void displayWebOptionsList() {
		HashSet<College>privateCollegeList = p.getPrivateCollegeList();
		HashSet<College>universityCollegeList = u.getUniversityCollegeList();
		System.out.println("Sno\tCourse Code\tCollege Name");
		for(int i = 0; i < webOptionsList.size();i++) {
			System.out.print(yellow + (i+1) + "	" + webOptionsList.get(i) + "     \t");
			String collegeCode = webOptionsList.get(i).substring(0,4);
			for(College college : privateCollegeList) {
				if(college.CollegeCode.equalsIgnoreCase(collegeCode)) {
					System.out.println(college.getCollegeName());
					break;
				}
			}
			for(College college : universityCollegeList) {
				if(college.CollegeCode.equalsIgnoreCase(collegeCode)) {
					System.out.println(college.getCollegeName()+reset);
					break;
				}
			}
		}
		System.out.println();
	}
}
