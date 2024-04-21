package Colleges;

import java.util.*;

public class UniversityCollegesList implements CollegesList{
	static HashSet<College>universityCollegeList = new HashSet<College>();
	Scanner sc = new Scanner(System.in);
	College college;
	Branch branch;
	public boolean validCollege(String collegeName,String Branch,int rank) {
		for(College college : universityCollegeList) {
			if(college.CollegeCode.equalsIgnoreCase(collegeName)) {
				ArrayList<Branch> branchList = college.getBranchesList();
				for(int i = 0;i < branchList.size();i++) {
					if(branchList.get(i).branchName.equalsIgnoreCase(Branch)) {
						if(branchList.get(i).rankCutOff >= rank) {
							System.out.println("Congrats ! you are elegible in : \nCollege : " + college.CollegeName + "\nBranch : "+ branchList.get(i).branchName);
							return true;
						}else {
							return false;
						}
					}
				}
			}
		}
		return false;
	}
	public boolean setDefaultColleges() {
		UniversityCollegesList universityCollegesList = new UniversityCollegesList();
		int[] jntuCutOff = {2000,4000,10000,9000,6000};
		universityCollegesList.addCollege("Jntukakinada", "JNTU", 72000,jntuCutOff);
		int[] auCutOff = {2500,4500,15000,9500,6500};
		universityCollegesList.addCollege("Andra_university", "AUVP", 70000,auCutOff);
		return true;
	}
	public boolean setUniversityColleges() {
		int noOfColleges = 1;
		String [] collegeNames = new String[noOfColleges];
		String [] collegeCodes = new String[noOfColleges];
		double [] fee = new double[noOfColleges];
		for(int i = 0;i < noOfColleges;i++) {
			System.out.print("Enter College Name : ");
			collegeNames[i] = sc.next();
			System.out.print("Enter College Code : ");
			collegeCodes[i] = sc.next();
			System.out.print("Enter " + collegeNames[i] + " Fee : ");
			fee[i] = sc.nextDouble();
		}
		String [] branches = {"CSE","ECE","MEC","CIV","EEE"};
		for(int i = 0;i < collegeNames.length;i++) {
			college = new College();
			college.setCollegeName(collegeNames[i]);
			college.setCollegeCode(collegeCodes[i]);
			college.collegeFee = fee[i];
			ArrayList <Branch> x = new ArrayList<>();
			for(int j = 0;j < branches.length;j++) {
				branch = new Branch();
				branch.branchName = branches[j];
				System.out.print("Enter " + collegeNames[i] + " " + branches[j] + " Rank Cut off : ");
				int rank = sc.nextInt();
				branch.rankCutOff = rank;
				x.add(branch);
			}
			college.setBranchesList(x);
			universityCollegeList.add(college);
		}
		return true;
	}
	public boolean updateCollegeList() {
		String collegeCode;
		System.out.println("Enter College Code : ");
		collegeCode = sc.next();
		for(College college : universityCollegeList) {
			if(college.CollegeCode.equalsIgnoreCase(collegeCode)) {
				System.out.println("What do u want to update\n1.College Code\n2.College Name\n3.College Fee\n4.update single Branch CutOFF\n5.Update All branch cutoff ");
				int choice = 0;
				choice = sc.nextInt();
				if(choice == 1) {
					System.out.println("Enter College Code :");
					String code = sc.next();
					college.CollegeCode = code;
					System.out.println("College Code Changed Successfully");
				}else if(choice == 2) {
					System.out.println("Enter College Name :");
					String name = sc.next();
					college.CollegeName = name;
					System.out.println("College Code Changed Successfully");
				}else if(choice == 3) {
					System.out.println("Enter College Fee :");
					String fee = sc.next();
					college.CollegeCode = fee;
					System.out.println("College Code Changed Successfully");
				}else if(choice == 4) {
					System.out.println("Enter Branch Name ");
					String branchName = sc.next();
					ArrayList<Branch> branchList = college.getBranchesList();
					for(Branch branch : branchList) {
						if(branch.branchName.equals(branchName)) { 
							System.out.println("Enter CutOff for " + branchName + " : ");
							branch.rankCutOff = sc.nextInt();
						}
					}
				}else if(choice == 5){
					ArrayList<Branch> branchList = college.getBranchesList();
					for(Branch branch : branchList) {
						System.out.println("Enter CutOff for " + branch.branchName + " : ");
						branch.rankCutOff = sc.nextInt();
					}
				}else {
					System.out.println("Invalid Input ");
				}
			}
		}
		return false;
	}
	public void addCollege(String collegeName,String collegeCode,double fee,int[] rankCutOff) {
		College college;
		Branch branch;
		String [] branches = {"CSE","ECE","MEC","CIV","EEE"};
		college = new College();
		college.setCollegeName(collegeName);
		college.setCollegeCode(collegeCode);
		college.collegeFee = fee;
		ArrayList <Branch> x = new ArrayList<>();
		for(int j = 0;j < branches.length;j++) {
			branch = new Branch();
			branch.branchName = branches[j];
			int rank = rankCutOff[j];
			branch.rankCutOff = rank;
			x.add(branch);
		}
		college.setBranchesList(x);
		universityCollegeList.add(college);
	}
	public boolean removeCollege() {
		College removingCollege = null;
		System.out.println("Enter College Code to delete : ");
		String option = sc.next();
		for(College college : universityCollegeList) {
			if(college.CollegeCode.equalsIgnoreCase(option)) {
				removingCollege = college;
				break;
			}
		}
		if(removingCollege == null) {
			System.out.println("Invalid College Code ");
		}else {
			universityCollegeList.remove(removingCollege);
		}
		return false;
	}
	public void displayCollegeList() {
		System.out.println("No of Colleges : " + universityCollegeList.size());
		for(College college : universityCollegeList) {
			System.out.println("College Name : " + college.getCollegeName() + "\nCollege Code : " + college.getCollegeCode()+ "\nCollege Fee : " + college.getCollegeFee());
			ArrayList<Branch> branchList = college.getBranchesList();
			for(int i = 0;i < branchList.size();i++) {
				String branchName = branchList.get(i).branchName;
				int rankCutOff = branchList.get(i).rankCutOff;
				System.out.println(branchName + "\t" + rankCutOff + "\t" );
			}
			System.out.println();
		}
	}
	public HashSet<College> getUniversityCollegeList() {
		return universityCollegeList;
	}
	public Scanner getSc() {
		return sc;
	}
}
