package resassured.com.stad;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJASONResponse {

	// https://mocki.io/v1/5bd0e59b-ac0b-4932-a4c4-2f738477a116

	@Test
	public void parseJASONResponseTest() {
		Response res = given().contentType(ContentType.JSON)

				.when().get("https://mocki.io/v1/5bd0e59b-ac0b-4932-a4c4-2f738477a116");

		JSONObject jo = new JSONObject(res.asString()); // Converting Response as Jason Object

		// Print response via indexing print all books Title
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String JSONObject = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(JSONObject);
		}

		// Print all book price
		double totalprice = 0;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String bookPrice = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			double price = Double.parseDouble(bookPrice);
			System.out.println(price);
			totalprice = totalprice + price;

		}
		System.out.println("Toatl price : " + totalprice);

		

		// Specific book is Available or not
		String bookCheck = "Sayings of the Century";
		boolean isFound = false;
		
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String JSONObject = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(JSONObject);

			if (JSONObject.equals(bookCheck)) {
				isFound = true;
			}
			if (isFound) {
				System.out.println("Book is Available");
			} else {
				System.out.println("Book is not Available");
			}

		}

		// .then()

		// ;

	}
}
