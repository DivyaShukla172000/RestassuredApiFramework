package resassured.com.stad;
	import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
	import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;

	public class GetHeaderTest {
		
		
		@Test
		public void testpathandQueryPara() {
			
			
		Response response =	given()
			.pathParam("myPath1","api")
			.pathParam("myPath2","users")
			.queryParam("page",2)
			
			.when()
			.get("https://reqres.in/{myPath1}/{myPath2}");
			
			String headerValue = response.getHeader("Content-Type");
			Assert.assertTrue(headerValue.equals("application/json; charset=utf-8"))
			
/*			.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.header("Transfer-Encoding", "chunked")
			.log().all()
			*/
			;
		}
		

}
