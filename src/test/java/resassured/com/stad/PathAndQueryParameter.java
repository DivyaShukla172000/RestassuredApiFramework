package resassured.com.stad;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameter {
	
	
	@Test
	public void testpathandQueryPara() {
		
		
		given()
		.pathParam("myPath1","api")
		.pathParam("myPath2","users")
		.queryParam("page",2)
		
		.when()
		.get("https://reqres.in/{myPath1}/{myPath2}")
		
		.then()
		.statusCode(200)
		.log().all()
		
		;
	}
	
	

}
