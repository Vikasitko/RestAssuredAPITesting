package NestedJsonPojo;

public class EmployeeNestedPojoClass {
	
	/*{ 
    "firstName":"Vikas",
	"lastName":"Kumar",
	"gender":"Male",
	"age":38,
	"salary":10000.00,
	
	"address":{
	             "Street": "Park Avenue",
	             "City": "Delhi",
	              "State": "Jharkhand",
	             "Pin": 82201             
}
}*/
	//in pojo class, default public constructor will be added at compile time
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private EmployeeAddress address;
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
	public EmployeeAddress getAddress() {
		return address;
	}
	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}

}
