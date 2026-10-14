package api.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import tools.jackson.databind.ObjectMapper;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import resassured.com.stad.POJOclass;

public class UserTest {
	
	Faker fake;
	User userpayload;
	int UserID;
	
	@BeforeClass
	public void setup() {
		fake = new Faker();
		userpayload = new User();
		
		userpayload.setName(fake.name().fullName());
		userpayload.setJob(fake.funnyName().name());
		userpayload.setCountry(fake.address().country());
		userpayload.setCity(fake.address().city());
	
	}	
	
	//@Test(priority=1)
	/*
	 * public void testPostUser() { Response response =
	 * UserEndPoints.testPostRequestUsingPojo(userpayload);
	 * 
	 * response.then().log().all();
	 * 
	 * Assert.assertEquals(response.getStatusCode(), 201);; }
	 */
	
	
	//Post method jkgui
	@Test(priority=1)
	public void testPostuserWithReturnID() {
		UserID = UserEndPoints.testPostRequestWithReturnID(userpayload);
		
	}
	//PUT method
	@Test(priority=2)
	public void updateUser() {
		
		userpayload.setName(fake.name().fullName());
		userpayload.setJob(fake.funnyName().name());
		Response response = UserEndPoints.testPut(userpayload,String.valueOf(UserID));
		response.then().log().all();
		
	}

}
