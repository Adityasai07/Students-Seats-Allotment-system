package Colleges;

public interface CollegesList {
	public boolean validCollege(String collegeName,String Branch,int rank);
	public boolean updateCollegeList();
	public void addCollege(String collegeName,String collegeCode,double fee,int[] rankCutOff);
	public boolean removeCollege();
	public void displayCollegeList();
}
