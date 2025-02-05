
//Routes class to store all the Request URLs

package api.endpoints;

public class Routes {
    
    /*
    //Endpoints for the User module:
     
    1. Create User      - POST  https://petstore.swagger.io/v2/user
    2. Get User         - GET   https://petstore.swagger.io/v2/user/{username}
    3. Update User      - PUT   https://petstore.swagger.io/v2/user/{username}
    4. Delete User      - DELETE https://petstore.swagger.io/v2/user/{username}
    */
    
    // Base URL for the API
    public static String base_URL = "https://petstore.swagger.io/v2";
    
    // User module URLs
    public static String post_URL = base_URL + "/user";             // URL to create a new user
    public static String get_URL = base_URL + "/user/{username}";   // URL to get details of a specific user
    public static String put_URL = base_URL + "/user/{username}";   // URL to update a specific user's details
    public static String delete_URL = base_URL + "/user/{username}"; // URL to delete a specific user
    
    // Pet module URLs - (Not implemented yet)
    
    // Store module URLs - (Not implemented yet)
}
