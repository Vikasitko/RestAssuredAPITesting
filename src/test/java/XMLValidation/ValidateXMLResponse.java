package XMLValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateXMLResponse {
	@Test
	public void addPet()
	{

		String jsonData = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		//https://petstore.swagger.io/v2/pet
		 //-H 'accept: application/xml' \
		  //-H 'Content-Type: application/xml' \
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
     	requestSpec.header("accept", "application/json");
     	requestSpec.header("Content-Type", "application/json");
     	Response response = requestSpec.contentType(ContentType.JSON).body(jsonData).post();
		//requestSpec.contentType(ContentType.JSON).body(jsonData.toJSONString());
     	response.prettyPrint();
     	
       String statusline = response.getStatusLine();
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void addPetinXML()
	{
		
		//to validate xml response, use hamcrest framework by use matchers class

		String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		// get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();

		// specify base uri
		//https://petstore.swagger.io/v2/pet
		 //-H 'accept: application/xml' \
		  //-H 'Content-Type: application/xml' \
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
     	requestSpec.header("accept", "application/xml");
     	requestSpec.header("Content-Type", "application/xml");
     	Response response = requestSpec.contentType(ContentType.XML).body(xmlData).post();
		//requestSpec.contentType(ContentType.JSON).body(jsonData.toJSONString());
     	response.prettyPrint();
     	
       String statusline = response.getStatusLine();
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		/* Response in xml format ::::
		 <Pet>
  <id>9223372016900014604</id>
  <name>doggie</name>
  <photoUrls>
    <photoUrl>string</photoUrl>
  </photoUrls>
  <status>available</status>
  <tags/>
</Pet>*/
		response.then().body("Pet.name", Matchers.equalTo("doggie"));
		
	}

}
