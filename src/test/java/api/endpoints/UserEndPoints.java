package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoints {

	
 static int  id;
	
	
	//post request useing pojo
	public static Response testPostRequestUsingPojo(User payload) {
	
		Response response= given()
			.contentType("application/json")
			.body(payload)
			
			.when()
			.post(Routes.post_url);
			
			return response
			
			;
	}
	
	public static Response testPut(User payload, String UserID) {
		
		Response response= given()
			.contentType("application/json")
			.pathParam("UserID", UserID)
			.body(payload)
			
			.when()
			.put(Routes.put_url);
			
			return response
			
			;
	}
	
	public static int  testPostRequestWithReturnID(User payload) {
		
		 id= given()
			.contentType("application/json")
			.body(payload)
			
			.when()
			.post(Routes.post_url)
			.jsonPath().getInt("id");
		
		return id;
	}
	
	
	
}
