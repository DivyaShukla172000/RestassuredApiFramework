package resassured.com.stad;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.annotations.Test;

public class JSONSchemaValidation {
	
	@Test
	public void testJSONSchemaValidation() {
		
		given()
		
		.when().get("https://mocki.io/v1/5bd0e59b-ac0b-4932-a4c4-2f738477a116")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"))
		
		;
		
		
	}

}
