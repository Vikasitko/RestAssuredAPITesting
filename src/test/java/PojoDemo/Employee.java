package PojoDemo;

public class Employee {
	
	/*{ 
    "firstName":"Vikas",
	"lastName":"Kumar",
	"age":38,
	"salary":10000.00
	}*/
	
	//Create pojo class and declared all variable as private and create getter and setter method
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	
//getter and setter methods
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName= firstName;
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
	
}
