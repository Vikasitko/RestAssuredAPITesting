package JSONArrayJsonObjList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayDemo {
	@Test
	public void createUserUsingJSONArray() {

		/*
		 * below json array [{ "firstName":"Vikas", "lastName":"Kumar", "age":38,
		 * "salary":10000.00 }, { "firstName":"Ram", "lastName":"Kumari", "age":38,
		 * "salary":10000.00 }, { "firstName":"John", "lastName":"Cena", "age":38,
		 * "salary":10000.00 }]
		 */

		// 1st Way- JOSN Array request body using JSON Object

		JSONObject user1 = new JSONObject();

		user1.put("firstName", "Vikas");
		user1.put("lastName", "Kumar");
		user1.put("age", 38);

		JSONObject user2 = new JSONObject();

		user2.put("firstName", "Ram");
		user2.put("lastName", "Kumari");
		user2.put("age", 40);

		JSONObject user3 = new JSONObject();

		user3.put("firstName", "John");
		user3.put("lastName", "Cena");
		user3.put("age", 39);
		
		//Add JOSN object to JSON array
		
		JSONArray userPayload = new JSONArray();
		userPayload.add(user1);
		userPayload.add(user2);
		userPayload.add(user3);
		
		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.baseUri("https://reqres.in/api/users");
		requestSpec.contentType(ContentType.JSON);
     Response response= 	requestSpec.body(userPayload).post();
     
     response.prettyPrint();
     System.out.println(response.getBody().asString());
     
     Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");

	}
	
	@Test
	public void createUserUsingList() {

		/*
		 * below json array [{ "firstName":"Vikas", "lastName":"Kumar", "age":38,
		 * "salary":10000.00 }, { "firstName":"Ram", "lastName":"Kumari", "age":38,
		 * "salary":10000.00 }, { "firstName":"John", "lastName":"Cena", "age":38,
		 * "salary":10000.00 }]
		 */

		// // 2nd Way- JOSN Array request body using List or Set

		Map<String, Object> user1 = new HashMap<>();

		user1.put("firstName", "Vikas");
		user1.put("lastName", "Kumar");
		user1.put("age", 38);

		Map<String, Object> user2 = new HashMap<>();

		user2.put("firstName", "Ram");
		user2.put("lastName", "Kumari");
		user2.put("age", 40);

		Map<String, Object> user3 = new HashMap<>();

		user3.put("firstName", "John");
		user3.put("lastName", "Cena");
		user3.put("age", 39);
		
		//Add JOSN object to JSON array
		
		List<Map<String, Object>> userPayload = new ArrayList();
		userPayload.add(user1);
		userPayload.add(user2);
		userPayload.add(user3);
		
		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.baseUri("https://reqres.in/api/users");
		requestSpec.contentType(ContentType.JSON);
     Response response= 	requestSpec.body(userPayload).post();
     
     response.prettyPrint();
     System.out.println(response.getBody().asString());
     
     Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");

	}
	
	
}