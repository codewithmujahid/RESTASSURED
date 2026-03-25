package tests;


	
	


	import org.testng.Assert;
	import org.testng.annotations.Test;

import base.BaseClass;
import payload.UserPayload;
	import service.UserService;
	import io.restassured.response.Response;

	public class GetTest  extends BaseClass {

	    UserService service = new UserService();
	    int userId;

	    // ✅ GET API
	    @Test
	    public void testGetUsers() {
	        Response response = service.getUsers();
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }

	    // ✅ POST API
	    @Test
	    public void testCreateUser() {
	        UserPayload payload = new UserPayload("Mujahid", "QA");

	        Response response = service.createUser(payload);
	        Assert.assertEquals(response.getStatusCode(), 201);

	        userId = response.jsonPath().getInt("id");
	    }

	    // ✅ PUT API
	    @Test(dependsOnMethods = "testCreateUser")
	    public void testUpdateUser() {
	        UserPayload payload = new UserPayload("Mujahid Updated", "QA Lead");

	        Response response = service.updateUser(userId, payload);
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }

	    // ✅ PATCH API
	    @Test(dependsOnMethods = "testCreateUser")
	    public void testPatchUser() {
	        UserPayload payload = new UserPayload("Mujahid Patch", "QA");

	        Response response = service.patchUser(userId, payload);
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }

	    // ✅ DELETE API
	    @Test(dependsOnMethods = "testCreateUser")
	    public void testDeleteUser() {
	        Response response = service.deleteUser(userId);
	        Assert.assertEquals(response.getStatusCode(), 204);
	    }
	}


