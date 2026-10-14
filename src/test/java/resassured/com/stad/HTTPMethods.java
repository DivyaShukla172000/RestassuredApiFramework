package resassured.com.stad;

//Core Rest Assured methods like given(), when(), get(), etc.
import static io.restassured.RestAssured.*;

//Rest Assured XML/JSON matchers
import static io.restassured.matcher.RestAssuredMatchers.*;

//Hamcrest matchers for assertions like equalTo(), hasItems(), etc.
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


public class HTTPMethods {
	int id;
	//@Test
	public void getUser() {
		given()
		
		.when().get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//@Test
	public void listUsers() {
given()
		
		.when().get("https://reqres.in/api/users?page=2\"\r\n")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all()
		
		;
	}

	
	//POST method
	
	@Test(priority=1)
	public void createUser() {
		
		Map<String, String> data = new HashMap<>();
		data.put("name", "Divya");
		data.put("Job", "QA");
		
 id = given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://reqres.in/api/users")
	.jsonPath().getInt("id")
	
//	.then()
//	.statusCode(201)
//	.log().all()
	;
	
	}
	
	
	@Test(priority=2)
	public void updateUser() {
		
		Map<String, String> data = new HashMap<>();
		data.put("name", "Divya Shukla");
		data.put("Job", "Sr. QA");
		
	 given()
	.contentType("application/json")
	.body(data)
	
	
	.when()
	.put("https://reqres.in/api/users/"+id)

	.then()
	.statusCode(200)
	.log().all()
	
	;
	
	}
	
	@Test(priority=3)
	public void deleteUser() {
		
		given()
		
		.when().delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all()
		

		;
	}
	
	
	
	/*
	 * given() 
	 Content-type , set cookies ,Authorization , parameters, headers
	 
	 
	 * when()
	 get , put , post ,patch , delete 
	  
	 *  then()
	 Validate Status Code , extract response body , extract header , cookies
	   
	 *  
	 */
	
}
