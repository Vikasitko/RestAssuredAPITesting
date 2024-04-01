package JsonIgnore;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoDemo.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonIgnoreDemo {
	@Test
	
	public void testMethod1() throws JsonProcessingException
	{
		EmployeePojoClass requestPayload= new EmployeePojoClass();
		requestPayload.setFirstName("Vikas");
		//if not setting last name so it will give null as output for lastname
		//requestPayload.setLastName("Kumar");
		requestPayload.setGender("Male");
		//requestPayload.setAge(29);
		requestPayload.setSalary(6445.98);
		requestPayload.setMarried(true);
		requestPayload.setFullName("Vikas Kumaar");
		
		//Convert employee class object to JSON payload asString
		
				ObjectMapper objectMapper = new ObjectMapper();
				String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
				
				System.out.println(employeeJson);
				

				// get RequestSpecification of the request
				RequestSpecification requestSpec = RestAssured.given();

				requestSpec.baseUri("https://reqres.in/api/users");
				requestSpec.contentType(ContentType.JSON);
				
		     Response response=requestSpec.body(employeeJson).post();
		     
		     response.prettyPrint();
		     System.out.println(response.getBody().asString());
		     
		     Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");
		     
		     //deserialization
		     
		     EmployeePojoClass emp2 = objectMapper.readValue(employeeJson, EmployeePojoClass.class);
		     
		     System.out.println("FirstName is:" +emp2.getFirstName());
		     System.out.println("LastName is:" +emp2.getLastName());
		     System.out.println("Age is:" +emp2.getAge());
		     System.out.println("Gender is:" +emp2.getGender());
		     System.out.println("Salary is:" +emp2.getSalary());
		     System.out.println("FullName is:" +emp2.getFullName());
		     
	}

}
