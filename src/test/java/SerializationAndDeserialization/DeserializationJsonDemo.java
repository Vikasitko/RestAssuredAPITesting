package SerializationAndDeserialization;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializationJsonDemo {
	
	@Test
	public void createUser()
	{
		//get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
      	requestSpec.basePath("/api/users");
      	
      	//create request body

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "vikas");
		jsonObject.put("job", "QA");
		
		requestSpec.contentType(ContentType.JSON);
		Response response =requestSpec.body(jsonObject).post();

		
	//read response body
	ResponseBody responseBody = response.getBody();
	
	//Deserialization response body - jSON response body to class Object
	
	jSONPostReqResponse responseClass = responseBody.as(jSONPostReqResponse.class);
	Assert.assertEquals(responseClass.name, "vikas", "Check for name");
	Assert.assertEquals(responseClass.job, "QA", "Check for Job");
	
	
	}

}
