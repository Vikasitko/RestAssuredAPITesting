package SerializationAndDeserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONObjectUsingJacksonAPI {
	@Test
	public void createUser() throws JsonProcessingException
	{
		/*{ 
	    "firstName":"Vikas",
		"lastName":"Kumar",
		"age":38,
		"salary":10000.00,
		"isMarried":true,
		"TechSkill":{
		             "Program": "Java",
		             "Automation": "Selenium"
	}
	}*/
		
		//create ObjectMapper class instance
		
		ObjectMapper objectMapper  = new ObjectMapper();
		//create Objectnode i.e json node
		
		ObjectNode userDetails = objectMapper.createObjectNode();
		
		
		userDetails.put("firstName", "Vikas");
		userDetails.put("lastName", "Kumar");
		userDetails.put("age", 38);
		userDetails.put("salarye", 10098.98);
		userDetails.put("isMarried", true);
		
		ObjectNode techSkill = objectMapper.createObjectNode();
		
		   techSkill.put("Program", "Java");
	       techSkill.put("Automation", "Selenium");
			
	       userDetails.set("TechSkill",techSkill );
	       
	       //print userDetails JSON Object
	       
	       String UserDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
	       
	       System.out.println("Created json node is :" +UserDetailsAsString);
	       
	       //Retrieve the field value
	       String firstName = userDetails.get("firstName").asText();
	       System.out.println("Value of firstname is :" +firstName);
	       
	       Boolean isMarried = userDetails.get("isMarried").asBoolean();
	       System.out.println("Created json node is :" +isMarried);
	       
	       
	       String techSkillAutomation = userDetails.get("TechSkill").get("Automation").asText();
	       System.out.println("Value of Automation is :" +techSkillAutomation);
	       
	       System.out.println("**********Print All fields Name********");
	       
	       Iterator<String> filedNameitr = userDetails.fieldNames();
	       
	       while(filedNameitr.hasNext())
	       {
	    	   System.out.println(filedNameitr.next()); 
	       }
	       
 System.out.println("**********Print All fields Values********");
	       
	       Iterator<JsonNode> filedValueitr = userDetails.elements();
	       
	       while(filedValueitr.hasNext())
	       {
	    	   System.out.println(filedValueitr.next()); 
	       }
	       
	       
System.out.println("**********Print All fieldsname and  Values as Key value pair********");
	       
	       Iterator<Entry<String, JsonNode>> filedKeyValueitr = userDetails.fields();
	       
	       while(filedKeyValueitr.hasNext())
	       {
	    	   Entry<String, JsonNode>  node= filedKeyValueitr.next();
	    	   System.out.println("Key is :"+node.getKey()+ " Value is :" +node.getValue());
	       }
	
	
	//Remove value and add new value of the field
	
	String removedValue = userDetails.remove("firstName").asText();
	
	System.out.println("Removed filed value is:"+ removedValue);
	
	//update Jsonobject or Object Node
	
	userDetails.put("firstName", "Sanjeev");
	
	String UserDetailsAsString1 =  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
	System.out.println("Removed filed value is:"+ UserDetailsAsString1);
	
	// get RequestSpecification of the request
	RequestSpecification requestSpec = RestAssured.given();

	requestSpec.baseUri("https://reqres.in/api/users");
	requestSpec.contentType(ContentType.JSON);
 Response response= 	requestSpec.body(userDetails).post();
 
 response.prettyPrint();
 System.out.println(response.getBody().asString());
 
 Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");
}
	}

