package NestedComplexJSON;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class NestedJsonObject {
	
	@Test
	public void createUser() throws JsonProcessingException
	{
		NestedJsonPojoClass requestPayload = new NestedJsonPojoClass();
		requestPayload.setCompany("ABC Pvt Ltd");
		requestPayload.setStreet("MG Road");
		requestPayload.setCity("Gurgaon");
		requestPayload.setState("Haryana");
		requestPayload.setPin(822019);
		
		List<String> banklist = new ArrayList<>();
		banklist.add("Axis");
		banklist.add("PNB");
		banklist.add("SBI");
		
		requestPayload.setBankAccount(banklist);
		

		EmployeeNestedPojoClass emp1 = new EmployeeNestedPojoClass();
		
		emp1.setFirstName("Vikas");
		emp1.setLastName("Kumar");
		emp1.setGender("Male");
		emp1.setAge(29);
		emp1.setSalary(84775.99);
		
//		EmployeeAddress emp1Address = new EmployeeAddress();
//		
//		emp1Address.setStreet("ParkAvenue");
//		emp1Address.setCity("Daltonganj");
//		emp1Address.setState("Jharkhand");
//		emp1Address.setPin(822101);
//		
//		emp1.setAddress(emp1Address);

		// create second employee object
		EmployeeNestedPojoClass emp2 = new EmployeeNestedPojoClass();
		emp2.setFirstName("Ram");
		emp2.setLastName("Kumari");
		emp2.setGender("Male");
		emp2.setAge(19);
		emp2.setSalary(10075.99);
		
//		 EmployeeAddress emp2Address = new EmployeeAddress();
//			
//			emp2Address.setStreet("MG Raoad");
//			emp2Address.setCity("Mukaul");
//			emp2Address.setState("CG");
//			emp2Address.setPin(822102);
//			
//			emp2.setAddress(emp2Address);

		// create third employee object
		EmployeeNestedPojoClass emp3 = new EmployeeNestedPojoClass();
		emp3.setFirstName("John");
		emp3.setLastName("Cena");
		emp3.setGender("Male");
		emp3.setAge(30);
		emp3.setSalary(875.99);
		
//		 EmployeeAddress emp3Address = new EmployeeAddress();
//			
//			emp3Address.setStreet("ABC");
//			emp3Address.setCity("Ambikapur");
//			emp3Address.setState("Karnakatak");
//			emp3Address.setPin(8847543);
//			
//			emp3.setAddress(emp3Address);
		// Create list of Employee

		List<EmployeeNestedPojoClass> listOfEmp = new ArrayList<>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		requestPayload.setEmployeeList(listOfEmp);

		//Convert class object to JsonObject as string
		
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJsonload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);

		System.out.println("Employee class obj to Json payload");

		System.out.println(employeeJsonload);
		

		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.baseUri("http://httpbin.org/post");
		requestSpec.contentType(ContentType.JSON);

		Response response = requestSpec.body(employeeJsonload).post();

		System.out.println("*******Respose Body****");
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		
	}

}
