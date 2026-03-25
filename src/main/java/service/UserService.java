package service;

import client.RestClient;
import io.restassured.response.Response;


public class UserService {
	 RestClient client = new RestClient();

	    public Response getUsers() {
	        return client.get("/users?page=2");
	    }

	    public Response createUser(Object body) {
	        return client.post("/users", body);
	    }

	    public Response updateUser(int id, Object body) {
	        return client.put("/users/" + id, body);
	    }

	    public Response patchUser(int id, Object body) {
	        return client.patch("/users/" + id, body);
	    }

	    public Response deleteUser(int id) {
	        return client.delete("/users/" + id);
	    }
	}
	


