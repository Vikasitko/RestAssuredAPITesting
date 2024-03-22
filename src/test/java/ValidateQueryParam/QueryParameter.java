package ValidateQueryParam;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {
	
	//Query parameter is used for filter the data from json ..
	//always start with ?
	@Test
	public void filterData()
	{
		
		//get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
      	requestSpec.basePath("/api/users");
      	//requestSpec.queryParam("page", 2);
      	
      	//if want to apply more filter
      	requestSpec.queryParam("page", 2).queryParam("id", 10);	
		//call get method
		Response response=  requestSpec.get();
		
	//read response body
	String  responseBodyString = response.getBody().asString();
	System.out.println("Response body is" +responseBodyString);
		
	}

}
