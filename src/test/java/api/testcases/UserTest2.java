package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.user_payload;


import io.restassured.response.Response;

public class UserTest2 {

	Faker faker;
	user_payload userdata;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData()
	{
		faker = new Faker();
		userdata=new user_payload();
		
		userdata.setId(faker.idNumber().hashCode());
		userdata.setUsername(faker.name().username());
		userdata.setFirstName(faker.name().firstName());
		userdata.setLastName(faker.name().lastName());
		userdata.setEmail(faker.internet().safeEmailAddress());
		userdata.setPassword(faker.internet().password(5, 10));
		userdata.setPhone(faker.phoneNumber().cellPhone());

		//obtain logger
		
		logger = LogManager.getLogger("RestAssuredAutomationFramework_test");
		
		
		
	}
	@Test(priority=1)
	public void testCreateUser() {
		
		Response response= UserEndPoints2.createUser(userdata);
	
		
	    //log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//log
		
		logger.info("Create user operation is executed");
	
	}
	
	
	
	@Test(priority=2)
	public void testGetUser() {
		
		Response response= UserEndPoints2.getUser(this.userdata.getUsername());
		
		System.out.println("\nRead  user data\n");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//log
		
		logger.info("Get user operation is executed");
		
	}
	
	
	
	@Test(priority=3)
	public void testUpdateUser() {
		
		userdata.setFirstName(faker.name().firstName());
		Response response= UserEndPoints2.updateUser(this.userdata.getUsername(), userdata );
		
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	
		//read user data to check weather first name is updated or not
		Response responsepostupdate= UserEndPoints.getUser(this.userdata.getUsername());
		
		System.out.println("\nThe After update user data is\n");
		//log response
		responsepostupdate.then().log().all();
		
		//log
		
		logger.info("Update user operation is executed");
	}
	
	
	@Test(priority=4)
	public void testDeleteUser() {
	
		Response response= UserEndPoints2.deleteUser(this.userdata.getUsername());
		
		System.out.println("\nDelete user data\n");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//log
		
		logger.info("Delete user operation is executed");
		
	}
	
}
