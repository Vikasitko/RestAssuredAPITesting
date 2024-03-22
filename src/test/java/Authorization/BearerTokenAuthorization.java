package Authorization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTokenAuthorization {
	@Test
	public void BearerToken() {
		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "vikas");
		jsonObject.put("gender", "male");
		jsonObject.put("email", "abc@gmail.com");

		// To Pass bearer token which start with Bearer will go in header as key value
		// pair

		String bearerToken = "Bearer jbd47467hduy7r4734hf74sdsjhsuyr7467";

		requestSpec.header("Authorization", bearerToken).contentType(ContentType.JSON).body(jsonObject.toJSONString());

		Response response = requestSpec.post();

		System.out.println("Response status Bearer token is " + response.getStatusLine());
		System.out.println("Response body of bearer token is " + response.body().asString());

	}

}
