package Student;

public class Student {
	public int rank;
	public String phoneNumber;
	public String password;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() != 10) {
			return;
		}
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Student [rank=" + rank + ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}
	
}
