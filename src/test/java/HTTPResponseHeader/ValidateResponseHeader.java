package HTTPResponseHeader;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//https://reqres.in/api/users/2
public class ValidateResponseHeader {
	@Test
	public void GetSingleUser()
	{
		
		//get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
      	requestSpec.basePath("/api/users/2");
      	
		//call get method
		Response response=  requestSpec.get();
		
		//validate header response
		//String header = response.header("Content-Type");
		
		//System.out.println("Value of Content-Type" +header);
		
		//read  all headers attribute and print
		
		Headers headers = response.getHeaders();
		//System.out.println("Value of Header list are" +headers);
		
		for(Header header: headers)
		{
			System.out.println("Key:" +header.getName() + "   Value:"+header.getValue());
		}
		
		
	}
}
