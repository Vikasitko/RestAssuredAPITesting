package Authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationBasicAndDigest {
	@Test
	public void basicAuth()

	// just need to pass user and password and used as Base 64
	// By Default basic is non preemtive so here minimum two request- response is
	// required to process a call
	// Rest assured will not send pass credential at first time and when server
	// asked then it will send in header with rest of the details
	{
		// get RequestSpecification of the request

		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		requestSpec.baseUri("https://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		// non preemtive authorization
		// Response response = requestSpec.auth().basic("postman", "password").get();

		// preemative authorization, need to add implicitaly
		Response response = requestSpec.auth().preemptive().basic("postman", "password").get();

		System.out.println("Response status is " + response.getStatusLine());
		System.out.println("Response body is " + response.body().asString());

	}

	@Test
	public void DigestAuth()

//just need to pass user and password and used available algorithm to encrypt password
	{
		// get RequestSpecification of the request

		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/prachi/prachi");

		Response response = requestSpec.auth().digest("prachi", "prachi").get();

		System.out.println("Response status Digest is " + response.getStatusLine());
		System.out.println("Response body of Digest is " + response.body().asString());

	}
}
