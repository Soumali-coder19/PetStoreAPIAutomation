package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints2 {
	
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //loads all the methods from properties file
		return routes;
	}
	
	public static Response createUser(User payload){	//creating endpoints (not TCs)
		
		String post_url = getURL().getString("post_url");									
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		
		return response;
	}
	
	public static Response readUser(String userName){				//reading endpoints (not TCs)
		
		String get_url = getURL().getString("get_url");
		Response response = given()
			.pathParam("username", userName)
		.when()
			.post(get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload){				//updating endpoints (not TCs)
		
		String update_url = getURL().getString("update_url");
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(update_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName){				//deleting endpoints (not TCs)
		
		String delete_url = getURL().getString("delete_url");
		Response response = given()
				.pathParam("username", userName)
		.when()
			.delete(delete_url);
		
		return response;
	}
}
