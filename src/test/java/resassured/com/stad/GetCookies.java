package resassured.com.stad;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetCookies {
		
		
		@Test
		public void cookiesdatastore() {
			
			
		Response response =	given()
	
			
			.when()
			.get("https://www.google.com/");
			
			String headerValue = response.getHeader("Content-Type");
			System.out.println(headerValue);
			Assert.assertTrue(headerValue.equals("text/html; charset=ISO-8859-1"));
			
			String cookiesValue = response.getCookie("AEC");
			System.out.println(cookiesValue);
		//	Assert.assertTrue(cookiesValue.equals("Aaa9EJq6_wA9agH2NQ7x5Z6MtiKwBPZKYs4Tr-0YxA6Nf3yLb5uXSzHAVbk"))
			
/*			.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.header("Transfer-Encoding", "chunked")
			.log().all()
			*/
			;
		}
		


}
