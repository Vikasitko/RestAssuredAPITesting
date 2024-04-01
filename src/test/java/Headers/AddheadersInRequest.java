package Headers;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class AddheadersInRequest {
@Test

public void testMethod1()
{

	//get RequestSpecification of the request
	RequestSpecification requestSpec = RestAssured.given();
	
	//specify base uri
	requestSpec.baseUri("https://reqres.in");
  	requestSpec.basePath("/api/users?page=1");
  	//2nd way
  	Map<String, String> reqHeader = new HashMap<>();
  	reqHeader.put("Header", "Value1");
  	reqHeader.put("Header", "Value2");
  	//requestSpec.headers(reqHeader);
  	requestSpec.log().headers();
  	
  	//1st way
  	//requestSpec.header("Header", "Value1");
  	
  	//3rd way
  	Header reqHeaderObj = new Header("Header", "Value1");
  	requestSpec.header(reqHeaderObj);
	//call get method
	Response response=  requestSpec.get();
	
Assert.assertEquals(response.statusCode(), 200);
	
}
}
