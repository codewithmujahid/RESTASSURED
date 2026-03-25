package RestAssured.RestAssured;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostMethod {
 
    @Test
    public void data() {

        HashMap<String, Object> dta = new HashMap<>();
        dta.put("firstName", "morpheus");
        dta.put("lastName", "leader");
        dta.put("age", 30);
         Response responce =
        given()
            .contentType(ContentType.JSON)
            .body(dta)
        .when()
            .post("https://dummyjson.com/users/add")
       .then()
       .statusCode(201)        
       .log().all()
  
       .extract()
       .response();
        
        System.out.println(dta);
        int id=responce.path("id");
        System.out.println("ID TAKE"+id);
    //    Assert.assertTrue(id > 0, "Valiadting id ");
        
        System.out.println("REQUEST BODY"+dta);
        long responceTime=responce.getTime();
        System.out.println("Responce Time "+responceTime);
        Assert.assertTrue(responceTime<2000);
     String a=   responce.getContentType();
System.out.println("CONTENT TYPE"+a);
System.out.println("cookes ----"+responce.getCookie(a));
String token=responce.path("token");
System.out.println("TOKEN"+token);


 



    
    }

	
	
}
