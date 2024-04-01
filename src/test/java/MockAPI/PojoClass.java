package MockAPI;

import java.util.Map;

public class PojoClass {
	/*{
	  "firstName": "Vikas",
	  "lastName": "Kumar",
	  "gender": "Male",
	  "age": 38,
	  "salary": 10000.00,
	  "hobbies": [
	    "Reading",
	    "Music"
	  ],
	  "familyMembers": {
	    "1": "Mother",
	    "2": "Father"
	  },
	  "isMarried": true
	}*/
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean isMarried;
	private String[]hobbies;
	private Map<String, String> familyMembers;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean getisMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
	}

}
