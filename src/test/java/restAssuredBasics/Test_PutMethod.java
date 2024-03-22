package restAssuredBasics;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
@Test
public class Test_PutMethod {
	//got id as response is = 97
	//https://reqres.in/api/users/97
	public void putMethod() {
	
	JSONObject jsonData = new JSONObject();
	jsonData.put("name", "Ankita");
	jsonData.put("Job", "BA");
	
	RestAssured.baseURI= "https://reqres.in/api/users/97";
	RestAssured.given().header("Content-type","application/json")
	.contentType(ContentType.JSON)
	.body(jsonData.toJSONString())
	.when().put()
	.then().statusCode(200).log().all();
	}

}
