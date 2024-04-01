package NestedComplexJSON;

import java.util.List;

public class NestedJsonPojoClass {
	/*"Company":"ABC Pvt ",
	"Street": "Park Avenue",
	  "City": "Delhi",
	    "State": "Jharkhand",
	     "Pin": 82201 ,
"BankAccount" : ["SBI", "Axis", "PNB"]*/
	
	
	private String company;
	private String street;
	private String city;
	private String state;
	private int pin;
	private List<String> bankAccount;
	private List<EmployeeNestedPojoClass> employeeList;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public List<String> getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}
	public List<EmployeeNestedPojoClass> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeNestedPojoClass> employeeList) {
		this.employeeList = employeeList;
	}
}
