

package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.user_payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("Routes");   //LOADING THE PROPERTY FILE Routes.properties
		return routes;
	}
	
	
	
	public static Response createUser(user_payload payload) 
	
	{	
		String create_url=getURL().getString("post_url");
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(create_url);
	
        return response;
	}
	
	
	public static Response getUser(String username) 
	
	{	
		String fetch_url=getURL().getString("get_url");
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				
				.when()
				.get(fetch_url);
		
		return response;
	}
	
	
	public static Response updateUser(String username, user_payload payload) 
	
	{	
		String put_url=getURL().getString("update_url");
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				
				.when()
				.put(put_url);
		
		return response;
	}
	
	
	public static Response deleteUser(String username) 
	
	{	
		String del_url=getURL().getString("delete_url");
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)

				
				.when()
				.delete(del_url);
		
		return response;
	}
}
