package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.user_payload;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {

	
	@Test(priority=1,dataProvider = "AllData" , dataProviderClass = DataProviders.class)
	public void testCreateUser(String UserID, String UserName, String FirstName, String LastName , String Email ,String Password ,String Phone)
	{

	
		user_payload userdata = new user_payload();
		
	    userdata.setId(Integer.parseInt(UserID));

		userdata.setUsername(UserName);
		userdata.setFirstName(FirstName);
		userdata.setLastName(LastName);
		userdata.setEmail(Email);
		userdata.setPassword(Password);
		userdata.setPhone(Phone);
		
		

		Response response= UserEndPoints.createUser(userdata);
	
	    //log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	@Test(priority=2,dataProvider = "UseNameData" , dataProviderClass = DataProviders.class)
	public void testGetUser(String username) {
		
		Response response= UserEndPoints.getUser(username);
		
		System.out.println("\nRead  user data\n");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3,dataProvider = "UseNameData" , dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
	
		Response response= UserEndPoints.deleteUser(username);
		
		System.out.println("\nDelete user data\n");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
}
