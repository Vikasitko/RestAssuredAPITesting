package FileUpload;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadDemo {
	
	@Test
	public void fileUploadDemo()
	{
		//Create file object
		
		File testFileUpload = new File("C:\\Users\\vikas\\OneDrive\\Desktop\\File upload data.txt");
		

		// get RequestSpecification of the request
				RequestSpecification requestSpec = RestAssured.given();

				requestSpec.baseUri("https://reqres.in/api/users");
				
				requestSpec.multiPart("file", testFileUpload);
				requestSpec.contentType("multiPart/form-data");
				
		     Response response= 	requestSpec.post();
		     response.prettyPrint();
		     Assert.assertEquals(response.statusCode(), "200");
	}

}
