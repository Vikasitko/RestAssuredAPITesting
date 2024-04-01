package SchemaVlidation;

import java.io.File;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoJsonSchemaValidation {
	@Test
	public void schemaValidation()
	{
		/*{
			"username": "admin",
			"password": "password123",
			
		}*/
		String payload= "{\r\n"
				+ "			\"username\": \"admin\",\r\n"
				+ "			\"password\": \"password123\",\r\n"
				+ "			\r\n"
				+ "		}";
		
		//get RequestSpecification of the request
				RequestSpecification requestSpec = RestAssured.given();
				
				//specify base uri
				requestSpec.baseUri("https://restful-booker.herokuapp.com/auth");
		      	requestSpec.contentType(ContentType.JSON);
		      	
				//call get method
				Response response=  requestSpec.post();
				
				Assert.assertEquals(response.statusCode(), 200);
				Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
				
				//response.body("token", Matchers.notNullValue())
				//.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\vikas\\OneDrive\\Desktop\\Schema.json")));
	}

}
