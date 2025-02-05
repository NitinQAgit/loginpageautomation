
//To maintain or create methods of  all the requests.

package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.user_payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
    
                                       // Method to create a user with the given payload
    public static Response createUser(user_payload payload) 
    {    
                                                  // Sending POST request to create the user
        Response response = given()
            .accept(ContentType.JSON)             // Accepting JSON response
            .contentType(ContentType.JSON)        // Sending JSON content type
            .body(payload)                        // Sending the user data as request body
            .when()
            .post(Routes.post_URL);               // Using the post URL from Routes class

        return response;                         // Returning the response of the request
    }

    
                                         // Method to get a user by username
    public static Response getUser(String username) 
    {    
                                         // Sending GET request to retrieve the user details
        Response response = given()
            .accept(ContentType.JSON)             // Accepting JSON response
            .pathParam("username", username)      // Setting the username in the path
            .when()
            .get(Routes.get_URL);                 // Using the get URL from Routes class
        
        return response;                         // Returning the response of the request
    }

    
                                       // Method to update user details with the given payload
    public static Response updateUser(String username, user_payload payload) 
    {    
                                                   // Sending PUT request to update user details
        Response response = given()
            .accept(ContentType.JSON)             // Accepting JSON response
            .contentType(ContentType.JSON)        // Sending JSON content type
            .pathParam("username", username)      // Setting the username in the path
            .body(payload)                        // Sending the updated user data as request body
            .when()
            .put(Routes.put_URL);                 // Using the put URL from Routes class
        
        return response;                         // Returning the response of the request
    }

    
                                          // Method to delete a user by username
    public static Response deleteUser(String username) 
    {    
                                                    // Sending DELETE request to delete the user
        Response response = given()
            .accept(ContentType.JSON)             // Accepting JSON response
            .pathParam("username", username)      // Setting the username in the path
            .when()
            .delete(Routes.delete_URL);           // Using the delete URL from Routes class
        
        return response;                         // Returning the response of the request
    }
}
