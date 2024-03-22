package HTTPResponseStatus;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Test
public class CheckForValidResponse {
	//https://reqres.in/api/users/2
	
	public void getSingleUser() {
		//Every Request in Rest Assured library is represented by an interface called Request Specification
		
		RestAssured.baseURI= "https://reqres.in/api/users/2";
		
		//get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();
		//call get method
		Response response=  requestSpec.get();
		
		//get status code
		int stscode = response.getStatusCode();
		//Validation
		Assert.assertEquals(stscode, 200);
		
		//Assert.assertEquals("Correct status code",stscode, 201 );
		
		String statusline = response.getStatusLine();
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		}
}
