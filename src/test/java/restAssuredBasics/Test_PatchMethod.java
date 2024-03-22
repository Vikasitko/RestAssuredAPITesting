package restAssuredBasics;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
@Test
public class Test_PatchMethod {
	
	public void putMethod() {
		//updating partial data on same id = 97
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Ankita");
		jsonData.put("Job", "HoseWife");
		
		RestAssured.baseURI= "https://reqres.in/api/users/97";
		RestAssured.given().header("Content-type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().patch()
		.then().statusCode(200).log().all();
		}

}
