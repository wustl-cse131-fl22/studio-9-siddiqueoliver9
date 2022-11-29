package assignment7;

import java.util.HashMap;
import java.util.Map;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {

	/**
	 *Instance variables, which are all private
	 * 
	 */
	Map<String, Integer> result = new HashMap<>();
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private int credits;
	private double grade;
	private double gradeQualityPoints;
	private double bearBucksBalance;
	private boolean isHyphenated;
	private double gradePointAverage;

	/**
	 * Constructor
	 * 
	 * @param firstName the first name of the student
	 * @param lasttName the last name of the student
	 * @param id the id number of the student
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	/**
	 * Gets the full name of the student
	 * 
	 * @return the full name of the student
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * Gets the id number of the student
	 * 
	 * @return the id number of the student
	 */
	public int getId() {
		return id;
	}

	/**
	 * Updates the student's GPA
	 * 
	 * @param grade the grade earned in the course
	 * @param credits the number of credits that course is worth
	 */
	public void submitGrade(double grade, int credits) {
		this.attemptedCredits += credits;
		this.gradeQualityPoints += grade*credits;
		if (grade >= 1.7) {
			this.passingCredits += credits;
		}
	}

	/**
	 * Gets the total number of the students' attempted credits
	 * 
	 * @return the number of the students' attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}

	/**
	 * Gets the total number of the students' passing credits
	 * 
	 * @return the number of the students' passing credits
	 */
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}

	/**
	 * Calculates the student's GPA
	 * 
	 * @return the GPA of the student
	 */
	public double calculateGradePointAverage() {
		this.gradePointAverage = this.gradeQualityPoints/this.attemptedCredits;
		return this.gradePointAverage;
	}

	/**
	 * Finds the students' class standing, otherwise known as their grade level
	 * 
	 * @return the class that the student is a part of
	 */
	public String getClassStanding() {
		if (passingCredits < 30) {
			return "First Year";
		}
		else if (passingCredits < 60) {
			return "Sophomore";
		}
		else if (passingCredits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}

	/**
	 * Figures out if the student is eligible for Phi Beta Kappa based on the eligibility requirements
	 * 
	 * @return whether or not the student is eligible for Phi Beta Kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if ((this.passingCredits >= 98 && calculateGradePointAverage() >= 3.60) || (this.passingCredits >= 75 && calculateGradePointAverage() >= 3.80)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Deposits an amount of bear bucks into the student's account
	 * @param amount the amount being deposited into the account
	 */
	public void depositBearBucks(double amount) {
		bearBucksBalance = bearBucksBalance + amount;
	}

	/**
	 * Deducts an amount of bear bucks from the student's account
	 * @param amount the amount being removed from the account
	 */
	public void deductBearBucks(double amount) {
		bearBucksBalance = bearBucksBalance - amount;
	}

	/**
	 * Gets the student's bear bucks account balance
	 * @return the bear bucks balance of the student's account
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}

	/**
	 * Sets the bear bucks account balance to 0 and returns the refunded amount
	 * @return the refunded amount based on the original bear bucks account balance
	 */
	public double cashOutBearBucks() {
		double refund = bearBucksBalance;
		if (bearBucksBalance <=10) {
			bearBucksBalance = 0;
			refund = 0;
		}
		else if (bearBucksBalance >= 10) {
			bearBucksBalance = 0;
			refund = refund - 10;
		}
		return refund;

	}

	/**
	 * Creates a new legacy student that is the child of two students
	 * @param firstName the first name of the legacy student 
	 * @param other the other parent 
	 * @param isHyphenated whether or not the last name of the legacy student should be hyphenated
	 * @param id the legacy student's id number
	 * @return the legacy student
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String childLastName = "";
		if (isHyphenated) {
			childLastName = this.lastName + "-" + other.lastName;
		}
		else {
			childLastName = this.lastName;
		}
		Student legacy = new Student(firstName, childLastName, id);
		legacy.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
		return legacy;
	}

	/**
	 * Creates a string containing information about the student
	 * @return a String containing the first name, last name, and id of the student
	 */
	public String toString() {
		return firstName + " " + lastName + ": " + id;
	}

}
