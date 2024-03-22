package restAssuredBasics;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

@Test
public class Test_DeleteMethod {
	
	public void deleteMethod() {
		//delete data on same id = 97 and response should be 204
		RestAssured.baseURI= "https://reqres.in/api/users/97";
		RestAssured.given()
		
		
		.when().delete()
		.then().statusCode(204).log().all();
		}


}
