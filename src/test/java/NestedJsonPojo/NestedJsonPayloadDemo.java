package NestedJsonPojo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NestedJsonPayloadDemo {
	
	@Test
	public void createUser() throws JsonProcessingException
	{
		EmployeeNestedPojoClass emp1 = new EmployeeNestedPojoClass();
		emp1.setFirstName("Vikas");
		emp1.setLastName("Kumar");
		emp1.setGender("Male");
		emp1.setAge(29);
		emp1.setSalary(84775.99);
		
		EmployeeAddress emp1Address = new EmployeeAddress();
		
		emp1Address.setStreet("ParkAvenue");
		emp1Address.setCity("Daltonganj");
		emp1Address.setState("Jharkhand");
		emp1Address.setPin(822101);
		
		emp1.setAddress(emp1Address);
		
		//Convert class object to JsonObject as string
		
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJsonload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

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
