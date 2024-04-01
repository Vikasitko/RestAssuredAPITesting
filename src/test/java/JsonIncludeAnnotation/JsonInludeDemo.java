package JsonIncludeAnnotation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonInludeDemo {
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
		     
	}

}
