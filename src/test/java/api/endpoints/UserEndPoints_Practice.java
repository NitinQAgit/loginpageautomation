package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.List;

import api.payload.User_payloadPractice;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints_Practice {

	
	public static Response createUser(User_payloadPractice userdata) 
	
	{	
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(userdata)
		
		.when()
		.post(RoutesPractice.createUser_URL);
	
        return response;
	}
	
	
	public static Response createUsersWithList(List<User_payloadPractice> payload) 
	{
	    Response response = given()
	        .accept(ContentType.JSON)
	        .contentType(ContentType.JSON)
	        .body(payload)
	        
	        .when()
	        .post(RoutesPractice.createWithList_URL);
	    
	    return response;
	}
	
	
	public static Response createUsersWithArray(List<User_payloadPractice> payload) 
	{
	    Response response = given()
	        .accept(ContentType.JSON)
	        .contentType(ContentType.JSON)
	        .body(payload)
	        
	        .when()
	        .post(RoutesPractice.createWithArray_URL);
	    
	    return response;
	}
	
	
	public static Response getUser(String username) 
	
	{	
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				
				.when()
				.get(RoutesPractice.getUser_URL);
		
		return response;
	}
	
	
	public static Response getUser_InvalidInput(String username) {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .pathParam("username", username)
	            .when()
	            .get(RoutesPractice.getUser_URL);
	    return response;
	}
	
	
	public static Response getUser_NotFound(String username) {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .pathParam("username", username)
	            .when()
	            .get(RoutesPractice.getUser_URL);
	    return response;
	}
	
	
	public static Response updateUser(String username, User_payloadPractice payload) 
	
	{	
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				
				.when()
				.put(RoutesPractice.updateUser_URL);
		
		return response;
	}
	
	
	public static Response updateUser_InvalidInput(String username, User_payloadPractice invalidPayload) {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .contentType(ContentType.JSON)
	            .pathParam("username", username)
	            .body(invalidPayload)
	            .when()
	            .put(RoutesPractice.updateUser_URL);
	    return response;
	}
	
	
	public static Response updateUser_NotFound(String username, User_payloadPractice payload) {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .contentType(ContentType.JSON)
	            .pathParam("username", username)
	            .body(payload)
	            .when()
	            .put(RoutesPractice.updateUser_URL);
	    return response;
	}
	
	
	public static Response deleteUser(String username) 
	
	
	
	{	
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)

				
				.when()
				.delete(RoutesPractice.deleteUser_URL);
		
		return response;
	}
	
	
	public static Response deleteUser_InvalidInput(String username) {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .pathParam("username", username)
	            .when()
	            .delete(RoutesPractice.deleteUser_URL);
	    return response;
	}
	
	
	public static Response deleteUser_NotFound(String username) {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .pathParam("username", username)
	            .when()
	            .delete(RoutesPractice.deleteUser_URL);
	    return response;
	}
	
	
	public static Response loginUser(String username, String password) {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .queryParam("username", username)
	            .queryParam("password", password)
	            .when()
	            .get(RoutesPractice.loginUser_URL);
	    
	    return response;
	}
	
	
	public static Response logoutUser() {
	    Response response = given()
	            .accept(ContentType.JSON)
	            .when()
	            .get(RoutesPractice.logoutUser_URL);
	    
	    return response;
	}

	

}
