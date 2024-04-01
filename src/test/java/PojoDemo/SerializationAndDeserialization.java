package PojoDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {
	@Test
	public void CreateJSONObjectFromClassObject() throws JsonProcessingException {
		
		Employee emp1 = new Employee();
		//here emp1 is class object and need to convert into json object
		
		emp1.setFirstName("Vikas");
		emp1.setLastName("Kumar");
		emp1.setGender("Male");
		emp1.setAge(29);
		emp1.setSalary(84775.99);
		
		//Convert employee class object to JSON payload asString
		
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(employeeJson);
		

		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.baseUri("https://reqres.in/api/users");
		requestSpec.contentType(ContentType.JSON);
		
     Response response=requestSpec.body(employeeJson).post();
     
     response.prettyPrint();
     System.out.println(response.getBody().asString());
     
     Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");
     
     //Now convert json string(Employee json) to class object(Employee object)
     
     Employee emp2 = objectMapper.readValue(employeeJson, Employee.class);
     
     System.out.println("FirstName is:" +emp2.getFirstName());
     System.out.println("LastName is:" +emp2.getLastName());
     System.out.println("Age is:" +emp2.getAge());
     System.out.println("Gender is:" +emp2.getGender());
     System.out.println("Salary is:" +emp2.getSalary());
     
     
	}

}
