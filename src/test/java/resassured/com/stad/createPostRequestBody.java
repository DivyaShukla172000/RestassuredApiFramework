package resassured.com.stad;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class createPostRequestBody {
	int id;
	
	//POST using POJO
	@Test
	public void testPOSTrequestUsingPOJO() {
		POJOclass data = new POJOclass();
		data.setName("Divya");
		data.setJob("Sr. QA");
		data.setCountry("India");
		data.setCity("Delhi");
		
		
	id=	given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id")
		
	/*
	 * .then() .statusCode(201) .log().all()
	 */
		
		;
		
	
		
	}
	
	

}
