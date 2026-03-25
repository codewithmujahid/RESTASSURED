package ComplexJson;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonClass {

	
	
	@Test
	public void createuser() throws JsonProcessingException {
		
		/*{
		"firstName": "Suresh",
		"lastName": "Mehra",
		"gender": "Male",
		"age": 35,
		"salary: 10000.56,
		"Address": {
		"Street": "Park Avenue",
		"City": "Vijaywada",
		
		"State": "Andhra Pradesh",
		"pin code":530012
		}
		コ*/
		
		EmpoyeeDetails emp=new EmpoyeeDetails();
		emp.setFirstName("Mujahid");
		emp.setLastName("Ali");
		emp.setGender("Male");
		emp.setSalary(52220);
		EmployeeAddress emp2=new EmployeeAddress();
		
		emp2.setStreet("Park Avenue");
		emp2.setCity("Hyderabad");
		emp2.setState("Telanagena");
		emp2.setPincode(431804);
		emp.setAddress(emp2);
		
		ObjectMapper objmap=new ObjectMapper();
		String payload=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		System.out.println("REQUEST BODY "+payload);
		
		RequestSpecification re=RestAssured.given();
		re.baseUri("https://httpbin.org/post");
		re.contentType(ContentType.JSON);
		re.body(payload);
	
		Response res= re.post();
		res.prettyPrint();
		String URL=res.jsonPath().getString("url");
		System.out.println("URL OF The RESPONCE "+URL);
		String addres =res.jsonPath().getString("json.address.street");
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(addres, "Hyderabad");
		//System.out.println("Street Addres"+addres);
		soft.assertAll();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
