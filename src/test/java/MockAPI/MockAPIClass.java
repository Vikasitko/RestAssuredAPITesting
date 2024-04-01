package MockAPI;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import PojoDemo.Employee;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class MockAPIClass {
	//Expected Json response is - 
	/*{
		  "firstName": "Vikas",
		  "lastName": "Kumar",
		  "gender": "Male",
		  "age": 38,
		  "salary": 10000.00,
		  "hobbies": [
		    "Reading",
		    "Music"
		  ],
		  "familyMembers": {
		    "1": "Mother",
		    "2": "Father"
		  },
		  "isMarried": true
		}*/
	
	//So mock this response and get API Mock URl on below website
	//https://designer.mocky.io/design/
	
	//Mock URL  for above Json is = https://run.mocky.io/v3/78e0c9f9-7996-4fe3-8cb2-3931ac5d069a
	
	@Test
	public void test1()
	{
		//get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://run.mocky.io/v3/78e0c9f9-7996-4fe3-8cb2-3931ac5d069a");
      	
      	
		//call get method
		Response response=  requestSpec.get();
		response.prettyPrint();
		
	//read response body
	//ResponseBody responseBody = response.getBody();
    Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	
	}
	
	@Test
	public void test2ToConvertClassObjectFromJsonObject()
	{
		//get RequestSpecification of the request
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://run.mocky.io/v3/78e0c9f9-7996-4fe3-8cb2-3931ac5d069a");
      	
      	
		//call get method
		Response response=  requestSpec.get();
		//deserialization
		
		PojoClass emp2= response.as(PojoClass.class);
		
	     
	     System.out.println("FirstName is:" +emp2.getFirstName());
	     System.out.println("LastName is:" +emp2.getLastName());
	     System.out.println("Age is:" +emp2.getAge());
	     System.out.println("Gender is:" +emp2.getGender());
	     System.out.println("Salary is:" +emp2.getSalary());
	     System.out.println("Is Married:" +emp2.getisMarried());
	     
	     System.out.println("Hobbies:");
	     
	     String[] hobbiestr = emp2.getHobbies();
	     
	    for(String hobbie: hobbiestr)
	    {
	    	System.out.println("Hobby:"+hobbie);
	    }
	    
	    for(Map.Entry<String, String> entry: emp2.getFamilyMembers().entrySet())
	    {
	    	System.out.println("Key is:"+entry.getKey()+"  Value is "+entry.getValue());
	    }
	}

}
