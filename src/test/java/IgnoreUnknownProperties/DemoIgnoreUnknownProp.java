package IgnoreUnknownProperties;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoIgnoreUnknownProp {
	
	//To ignore Unknown Properties by
	//1.Using @JsonIgnoreProperties annotation
	//2.Using ObjectMapper
	@Test
	public void test1() throws JsonMappingException, JsonProcessingException
	{
		
	String payload = "{ \r\n"
			+ "    \"firstName\":\"Vikas\",\r\n"
			+ "	\"lastName\":\"Kumar\",\r\n"
			+ "	\"gender\":\"Male\",\r\n"
			+ "	\"age\":38,\r\n"
			+ "	\"salary\":10000.00,\r\n"
			+ "\"isMarried\":true,\r\n"
			+ " \"fullName\":\"Suresh Vikas\"\r\n"
			+ "}";	
	
	//Here already payload taken as hardcoded so no need to set value after creating obj3ct of Employee class
	
	
	ObjectMapper objMappper = new ObjectMapper();
	
	//2nd way to ignore
	objMappper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	   //Deserialization- Now convert json string to class object(Employee object)
	
	 Employee emp2 = objMappper.readValue(payload, Employee.class);
	 
	  
     System.out.println("FirstName is:" +emp2.getFirstName());
     System.out.println("LastName is:" +emp2.getLastName());
     System.out.println("Age is:" +emp2.getAge());
     System.out.println("Gender is:" +emp2.getGender());
     System.out.println("Salary is:" +emp2.getSalary());
     System.out.println("Is Married is:" +emp2.getisMarried());
	}

}
