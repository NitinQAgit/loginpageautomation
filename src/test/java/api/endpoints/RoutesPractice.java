package api.endpoints;

public class RoutesPractice {

	/*
	HTTP Request	URL                                                    Status Code
	POST	        https://petstore.swagger.io/user                           200
	GET	            https://petstore.swagger.io/user/{username}                200
	PUT	            https://petstore.swagger.io/user/{username}                200
	DELETE         	https://petstore.swagger.io/user/{username}                200
	POST	        https://petstore.swagger.io/user/createWithArray           200
	POST        	https://petstore.swagger.io/user/createWithList            200
	GET         	https://petstore.swagger.io/user/login                     200
	GET         	https://petstore.swagger.io/user/login                     400
	GET         	https://petstore.swagger.io/user/logout                    200
	GET         	https://petstore.swagger.io/user/{username}                400
	GET         	https://petstore.swagger.io/user/{username}                404
	DELETE      	https://petstore.swagger.io/user/{username}                400 
	DELETE      	https://petstore.swagger.io/user/{username                 404
	PUT	            https://petstore.swagger.io/user/{username}                400
	PUT	            https://petstore.swagger.io/user/{username}                404


*/
	

	
	  // Base URL
    public static String base_URL = "https://petstore.swagger.io/v2";

    // User module URLs
    public static String createUser_URL = base_URL + "/user"; // POST
    public static String getUser_URL = base_URL + "/user/{username}"; // GET
    public static String updateUser_URL = base_URL + "/user/{username}"; // PUT
    public static String deleteUser_URL = base_URL + "/user/{username}"; // DELETE
    public static String createWithArray_URL = base_URL + "/user/createWithArray"; // POST
    public static String createWithList_URL = base_URL + "/user/createWithList"; // POST
    public static String loginUser_URL = base_URL + "/user/login"; // GET
    public static String logoutUser_URL = base_URL + "/user/logout"; // GET

    // Error scenarios for User module
    public static String invalidGetUser_URL = base_URL + "/user/{username}"; // GET (400, 404)
    public static String invalidDeleteUser_URL = base_URL + "/user/{username}"; // DELETE (400, 404)
    public static String invalidUpdateUser_URL = base_URL + "/user/{username}"; // PUT (400, 404)
}











