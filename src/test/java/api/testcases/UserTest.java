

// To maintain all the validations of the API request you sent (module-wise).

package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.user_payload;

import io.restassured.response.Response;

public class UserTest {

// Declaring Faker, user_payload, and Logger objects for use in the tests
    Faker faker;
    user_payload userdata;
    public static Logger logger;
    
    @BeforeClass                                       // Setting up the test data before each test starts
    public void generateTestData() {
        faker = new Faker();                          // Initialize Faker library to generate random test data
        userdata = new user_payload();                // Initialize user payload object
        
 
        userdata.setId(faker.idNumber().hashCode());    // Generating random user data using Faker library
        userdata.setUsername(faker.name().username());
        userdata.setFirstName(faker.name().firstName());
        userdata.setLastName(faker.name().lastName());
        userdata.setEmail(faker.internet().safeEmailAddress());
        userdata.setPassword(faker.internet().password(5, 10)); // Password with length between 5 and 10
        userdata.setPhone(faker.phoneNumber().cellPhone());

        // Initialize logger for logging test steps
        logger = LogManager.getLogger("RestAssuredAutomationFramework_test");
    }


    @Test(priority = 1)                                        // Test case to create a user and validate the response
    public void testCreateUser() {
       
    	// Calling the createUser method from UserEndPoints and passing the user data
    	Response response = UserEndPoints.createUser(userdata);
        
    	response.then().log().all();                           // Log the full response to the console      
        Assert.assertEquals(response.getStatusCode(), 200);    // Validate that the status code returned is 200 (Success)
        logger.info("Create user operation is executed");      // Log the successful execution of the Create User test case
    }


    
    @Test(priority = 2)                                      // Test case to get a user by username and validate the response
    public void testGetUser() {
    	
        // Calling the getUser method from UserEndPoints using the generated username
        Response response = UserEndPoints.getUser(this.userdata.getUsername());
      
        System.out.println("\nRead user data\n");
        response.then().log().all();                                // Log the full response to the console
        Assert.assertEquals(response.getStatusCode(), 200);         // Validate that the status code returned is 200 (Success)
        logger.info("Get user operation is executed");             // Log the successful execution of the Get User test case
    }

    

    @Test(priority = 3)                                     // Test case to update a user's first name and validate the update
    public void testUpdateUser() {
    	
        userdata.setFirstName(faker.name().firstName());          // Update the first name of the user with new random data
        
        // Call the updateUser method from UserEndPoints to update the user data
        Response response = UserEndPoints.updateUser(this.userdata.getUsername(), userdata);

        response.then().log().all();                           // Log the full response to the console
        Assert.assertEquals(response.getStatusCode(), 200);    // Validate that the status code returned is 200 (Success)
        
        // After updating, retrieve the user data again to confirm if the update was successful
        Response responsePostUpdate = UserEndPoints.getUser(this.userdata.getUsername());
        System.out.println("\nThe After update user data is\n");
        responsePostUpdate.then().log().all();                   // Log the full response to the console to verify the update
        logger.info("Update user operation is executed");        // Log the successful execution of the Update User test case
    }

    
    
    @Test(priority = 4)                                   // Test case to delete a user and validate the deletion
    public void testDeleteUser() {
    	
        // Call the deleteUser method from UserEndPoints to delete the user by username
        Response response = UserEndPoints.deleteUser(this.userdata.getUsername());
        
        System.out.println("\nDelete user data\n");
        response.then().log().all();                               // Log the full response to the console
        Assert.assertEquals(response.getStatusCode(), 200);        // Validate that the status code returned is 200 (Success)
        logger.info("Delete user operation is executed");          // Log the successful execution of the Delete User test case
    }
}
