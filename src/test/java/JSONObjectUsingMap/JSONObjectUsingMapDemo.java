package JSONObjectUsingMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONObjectUsingMapDemo {
	@Test(enabled= false)
	public void creatAuthToke()
	{
		Map<String, String> authToken = new HashMap<>();
		
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		// get RequestSpecification of the request
				RequestSpecification requestSpec = RestAssured.given();

				requestSpec.baseUri("https://restful-booker.herokuapp.com/auth");
				requestSpec.contentType(ContentType.JSON);
		     Response response= 	requestSpec.body(authToken).post();
		     
		     response.prettyPrint();
		     
		     Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
	
	@Test
	public void creatUser()
	{
		
		/*{ 
		    "firstName":"Vikas",
			"lastName":"Kumar",
			"age":38,
			"salary":10000.00,
			"isMarried":true,
			"Hobbies":["Cricket", "Hocky", "Football"],
			"TechSkill":{
			             "Program": "Java",
			             "Automation": "Selenium"
		}
		}*/
		Map<String, Object> userData = new HashMap<>();
		
		userData.put("firstName", "Vikas");
		userData.put("lastName", "Kumar");
		userData.put("age", 38);
		userData.put("salarye", 10098.98);
		userData.put("isMarried", true);
		
		ArrayList<String> hobbies = new ArrayList<>();
		hobbies.add("Cricket");
		hobbies.add("Hockey");
		hobbies.add("Football");
		
		userData.put("Hobbies",hobbies );
		
       Map<String, Object> teckSkill = new HashMap<>();
		
       teckSkill.put("Program", "Java");
       teckSkill.put("Automation", "Selenium");
		
		userData.put("TechSkill",teckSkill );
		
		// get RequestSpecification of the request
				RequestSpecification requestSpec = RestAssured.given();

				requestSpec.baseUri("https://reqres.in/api/users");
				requestSpec.contentType(ContentType.JSON);
		     Response response= 	requestSpec.body(userData).post();
		     
		     response.prettyPrint();
		     System.out.println(response.getBody().asString());
		     
		     Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");
	}

}
