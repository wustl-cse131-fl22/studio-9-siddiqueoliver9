package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;


public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> result;
	public UniversityDatabase() {
		this.result = new HashMap<>();
	}
	public void addStudent(String accountName, Student student) {
		// TODO
		
		result.put(accountName,student);
	}

	public int getStudentCount() {
		// TODO
		return result.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		Student s=result.get(accountName);
		return s.getFullName();
	}

	public double getTotalBearBucks() {
		// TODO
		double bbBalance = 0;
		for(String name:result.keySet()) {
			Student s=result.get(name);
			bbBalance += s.getBearBucksBalance();
		}
		return bbBalance;
	}
}
