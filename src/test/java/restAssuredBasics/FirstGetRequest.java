package restAssuredBasics;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class FirstGetRequest {
	//https://reqres.in/api/users/2
	
//	Base URL  =https://reqres.in
//		Resource = api/users
//		path parameter = 2
//		Quesry Parameter = ?page2
	
	//if do not want to restAssured class on each statement, mark import statement as Static
	@Test
	public void testCase01()
	{
		//Response res = RestAssured.get("https://reqres.in/api/users/2");
		
		Response res = get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println("Status code is " +res.getStatusCode());
		System.out.println("Body is " +res.getBody().asString());
		System.out.println("Header is " +res.getHeader("Content-Type"));
		
		Assert.assertEquals(200, res.getStatusCode());
		
	}
	
	@Test
	public void testCase02()
	{
		//Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		Response res = get("https://reqres.in/api/users?page=2");
		
		System.out.println("Response Status code is " +res.getStatusCode());
		System.out.println("Body is " +res.getBody().asString());
		System.out.println("Header is " +res.getHeader("Content-Type"));
		
		Assert.assertEquals(200, res.getStatusCode());
		
	}
	
	@Test
	
	
	public void testCase03()
	{
		//given, when , then 
		//RestAssured.baseURI="https://reqres.in/api/users";
		//RestAssured.given()
		
		//Changed import statement as Static so no need to write RestAssured class here 
		baseURI="https://reqres.in/api/users";
		given()
		.queryParam("page", 2)
		.when().get()
		.then().statusCode(200);
	
		
	}

}
