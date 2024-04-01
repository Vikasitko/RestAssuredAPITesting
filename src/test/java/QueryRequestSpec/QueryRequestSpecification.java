package QueryRequestSpec;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {

	// https://reqres.in/api/users
	//whatever we sending in request.how to retrieve those..so as below QueryableRequestSpecification
	@Test
	public void createUser() {
		// create json request body

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Ruby");
		jsonObject.put("job", "Teacher");
		
		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		requestSpec.contentType(ContentType.JSON).body(jsonObject.toJSONString());
		
		//query details from request specification
		
		QueryableRequestSpecification queryRequest= SpecificationQuerier.query(requestSpec);
		
		//get base URI
		
		String baseURI = queryRequest.getBaseUri();
		System.out.println("Base URI  is :"+baseURI);
		
		//get body
		String reqbody = queryRequest.getBody();
		System.out.println("res body is :"+reqbody);
		
		//get request headers
        Headers allHeaders = queryRequest.getHeaders();
        for(Header header: allHeaders)
        {
        	System.out.println("Header name is :" +header.getName()+ "  Header value is" +header.getValue());
        }
	}

}
