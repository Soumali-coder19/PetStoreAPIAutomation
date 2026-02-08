package api.endpoints;

/*
 * Swagger URI: https://petstore.swagger.io/
 * 
 * Create User(POST): https://petstore.swagger.io/v2/user
 * Get User(GET): https://petstore.swagger.io/v2/user/{username}
 * Update user(PUT): https://petstore.swagger.io/v2/user/{username}
 * Delete user(DELETE): https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	//we only maintain the URLs in the class
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user module
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String update_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
	//store module
		//create store module URLs
	
	//Pet module
		//create pet module URLs
}
