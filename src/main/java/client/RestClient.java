package client;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RestClient {


	    public Response get(String endpoint) {
	        return given()
	                .when()
	                .get(endpoint);
	    }

	    public Response post(String endpoint, Object body) {
	        return given()
	                .header("Content-Type", "application/json")
	                .body(body)
	                .when()
	                .post(endpoint);
	    }

	    public Response put(String endpoint, Object body) {
	        return given()
	                .header("Content-Type", "application/json")
	                .body(body)
	                .when()
	                .put(endpoint);
	    }

	    public Response patch(String endpoint, Object body) {
	        return given()
	                .header("Content-Type", "application/json")
	                .body(body)
	                .when()
	                .patch(endpoint);
	    }

	    public Response delete(String endpoint) {
	        return given()
	                .when()
	                .delete(endpoint);
	    }
	}

