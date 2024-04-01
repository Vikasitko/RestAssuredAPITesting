package PojoDemo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSONArrayPOJOClassDemo {

	/*
	 * below json array [{ "firstName":"Vikas", "lastName":"Kumar","gender":
	 * "male","age":38, "salary":10000.00 }, { "firstName":"Ram",
	 * "lastName":"Kumari","gender": "Female", "age":39, "salary":10980.00 }, {
	 * "firstName":"John", "lastName":"Cena","gender": "male", "age":45,
	 * "salary":106700.00 }]
	 */

	@Test
	public void createEmployeeJsonArray() throws JsonMappingException, JsonProcessingException {
		// create first employee object

		Employee emp1 = new Employee();
		emp1.setFirstName("Vikas");
		emp1.setLastName("Kumar");
		emp1.setGender("Male");
		emp1.setAge(29);
		emp1.setSalary(84775.99);

		// create second employee object
		Employee emp2 = new Employee();
		emp2.setFirstName("Ram");
		emp2.setLastName("Kumari");
		emp2.setGender("Male");
		emp2.setAge(19);
		emp2.setSalary(10075.99);

		// create third employee object
		Employee emp3 = new Employee();
		emp3.setFirstName("John");
		emp3.setLastName("Cena");
		emp3.setGender("Male");
		emp3.setAge(30);
		emp3.setSalary(875.99);
		// Create list of Employee

		List<Employee> listOfEmp = new ArrayList<>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);

		// Convert Employee class object to JSON Array payload

		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJsonArrayPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);

		System.out.println("Employee class obj to Json Array payload");

		System.out.println(employeeJsonArrayPayload);

		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.baseUri("http://httpbin.org/post");
		requestSpec.contentType(ContentType.JSON);

		Response response = requestSpec.body(employeeJsonArrayPayload).post();

		System.out.println("*******Respose Body****");
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");

		// Now convert json string(Employee json) to class object(Employee object)

		ResponseBody responseBody = response.getBody();
		
		System.out.println(responseBody);
		
		JsonPath jsonPathView = responseBody.jsonPath();

		List<Employee> allEmployes = jsonPathView.getList("json", Employee.class);

		// Employee object in response body
		
		System.out.println(allEmployes);

		for (Employee emp : allEmployes) {
			System.out.println("FirstName is :" + emp.getFirstName());
			System.out.println("Salry is :" + emp.getSalary());
		}

	}

}
