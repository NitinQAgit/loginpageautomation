package api.testcases;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints_Practice;
import api.payload.User_payloadPractice;
import io.restassured.response.Response;

public class UserTest_Practice {

	Faker faker;
	User_payloadPractice userdata;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData()
	{
		faker = new Faker();
		userdata=new User_payloadPractice();
		
		userdata.setId(faker.idNumber().hashCode());
		userdata.setUsername(faker.name().username());
		userdata.setFirstName(faker.name().firstName());
		userdata.setLastName(faker.name().lastName());
		userdata.setEmail(faker.internet().safeEmailAddress());
		userdata.setPassword(faker.internet().password(5, 10));
		userdata.setPhone(faker.phoneNumber().cellPhone());
		
		

			
		     // obtain logger
	        logger = LogManager.getLogger("RestAssuredAutomationFramework_test");
	    
	}
	    @Test(priority = 1)
	    public void testCreateUser() {
	        Response response = UserEndPoints_Practice.createUser(userdata);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Create user operation is executed");
	    }

	    
	    @Test(priority = 2)
	    public void testCreateUsersWithArray() {
	        List<User_payloadPractice> users = new ArrayList<>();
	        users.add(userdata);

	        Response response = UserEndPoints_Practice.createUsersWithArray(users);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Create users with array operation is executed");
	    }

	    
	    @Test(priority = 3)
	    public void testCreateUsersWithList() {
	        List<User_payloadPractice> users = new ArrayList<>();
	        users.add(userdata);

	        Response response = UserEndPoints_Practice.createUsersWithList(users);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Create users with list operation is executed");
	    }

	    
	    @Test(priority = 4)
	    public void testGetUser() {
	        Response response = UserEndPoints_Practice.getUser(userdata.getUsername());
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Get user operation is executed");
	    }

	    
	    @Test(priority = 5)
	    public void testGetUser_InvalidInput() {
	    	String invalidUsername = "";
	        Response response = UserEndPoints_Practice.getUser_InvalidInput(invalidUsername);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 400);
	        logger.info("Get user with invalid input operation is executed");
	    }

	    
	    @Test(priority = 6)
	    public void testGetUser_NotFound() {
	        Response response = UserEndPoints_Practice.getUser_NotFound("nonExistentUser");
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 404);
	        logger.info("Get user not found operation is executed");
	    }

	    
	    @Test(priority = 7)
	    public void testUpdateUser() {
	        userdata.setFirstName(faker.name().firstName());
	        Response response = UserEndPoints_Practice.updateUser(userdata.getUsername(), userdata);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Update user operation is executed");
	    }

	    
	    @Test(priority = 8)
	    public void testUpdateUser_InvalidInput() {
	        User_payloadPractice invalidPayload = new User_payloadPractice();
	        invalidPayload.setFirstName(""); // Empty first name for invalid data
	        Response response = UserEndPoints_Practice.updateUser_InvalidInput("invalid@#$%^&**Username", invalidPayload);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 400);
	        logger.info("Update user with invalid input operation is executed");
	    }

	    
	    @Test(priority = 9)
	    public void testUpdateUser_NotFound() {
	        Response response = UserEndPoints_Practice.updateUser_NotFound("nonExistentUser@#$%^&*(", userdata);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 404);
	        logger.info("Update user not found operation is executed");
	    }

	    
	    @Test(priority = 10)
	    public void testDeleteUser() {
	        Response response = UserEndPoints_Practice.deleteUser(userdata.getUsername());
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Delete user operation is executed");
	    }

	    
	    @Test(priority = 11)
	    public void testDeleteUser_InvalidInput() {
	        Response response = UserEndPoints_Practice.deleteUser_InvalidInput("@#$%^%^&**()");
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 400);
	        logger.info("Delete user with invalid input operation is executed");
	    }

	    
	    @Test(priority = 12)
	    public void testDeleteUser_NotFound() {
	        Response response = UserEndPoints_Practice.deleteUser_NotFound("nonExistentUser");
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 404);
	        logger.info("Delete user not found operation is executed");
	    }

	    
	    @Test(priority = 13)
	    public void testLoginUser() {
	        Response response = UserEndPoints_Practice.loginUser(userdata.getUsername(), userdata.getPassword());
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Login user operation is executed");
	    }

	    
	    @Test(priority = 14)
	    public void testLogoutUser() {
	        Response response = UserEndPoints_Practice.logoutUser();
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("Logout user operation is executed");
	    }
	}

	
	
	
