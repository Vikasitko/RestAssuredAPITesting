package ValidateJsonBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	@Test
	//https://reqres.in/api/users?page=2
	public void userListResponseBody()
	{
		//get RequestSpecification of the request
				RequestSpecification requestSpec = RestAssured.given();
				
				//specify base uri
				requestSpec.baseUri("https://reqres.in");
		      	requestSpec.basePath("/api/users?page=2");
		      	
				//call get method
				Response response=  requestSpec.get();
				
			//read response body
			ResponseBody responseBody = response.getBody();
//				
//				String responseString = responseBody.asString();
//				System.out.println("Response body is" +responseString);
//				
//				//check for presence of George in response body
//				
//				Assert.assertEquals(responseString.contains("George1"), true, "Check for George");
				
				//get json path view of response body by help of tool
			JsonPath jsonPathView= responseBody.jsonPath();
			
			//x.data[4].first_name ===from json path finder
			
			String firstName=jsonPathView.get("x.data[4].first_name");
			Assert.assertEquals(firstName, "George", "Check for George");
	}

}
