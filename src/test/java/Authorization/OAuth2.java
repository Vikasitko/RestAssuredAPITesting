package Authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2 {
	static String accessToken;
	@Test
	public void GetAccessToekn()
	{
		
		String clientId  = "jbdsg5747bfdjheu4yrubdjbej";
		String clientSecret  = "jbdsg5747bfdjheufhdjh4yrubdjbej";
		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		//uri+basepath = URL
		requestSpec.baseUri("https://api-m.sanbox.paypal.com");
		requestSpec.basePath("/v1/oauth2/token");
		
		Response response = requestSpec.auth().preemptive().basic("clientId", "clientSecret").param("grant_type", "client_credetials").post();

		
		 response.prettyPrint();

		System.out.println("Response status line is " + response.getStatusLine());
		System.out.println("Response code  is " + response.statusCode());
		
		//get access token from response body
		//here access_Toekn will be in json response and fetching as below
		 accessToken = response.getBody().path("access_Token");
		System.out.println("Access token is " +accessToken);
	}
	
	
	@Test(dependsOnMethods="GetAccessToekn")
	
	//whatever token is generated, we are using in this test method so used depends on method to execute 1st test intially and generated token declared as static and globally
	public void ListOfInvoice()
	{
		
		
		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		//uri+basepath = URL
		requestSpec.baseUri("https://api-m.sanbox.paypal.com");
		requestSpec.basePath("/v1/oauth2/token");
		
		Response res = requestSpec.auth().oauth2(accessToken).queryParam("page", "38")
				.queryParam("total_count_required", "true").param("grant_type", "client_credetials")
				.get("https://........");

		
		 res.prettyPrint();

		System.out.println("Response status line is " + res.getStatusLine());
		System.out.println("Response code  is " + res.statusCode());
		
		
	}

}
