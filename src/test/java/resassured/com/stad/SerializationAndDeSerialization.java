package resassured.com.stad;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import io.restassured.module.jsv.JsonSchemaValidator;
import tools.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class SerializationAndDeSerialization {
	
	//Serialization
	@Test
	public void pojoToJson() {
		
		POJOclass data = new POJOclass();
		Faker fake = new Faker();
		
		data.setName(fake.name().fullName());
		data.setJob(fake.funnyName().name());
		data.setCountry(fake.address().country());
		data.setCity(fake.address().city());
		
		ObjectMapper objMapper= new ObjectMapper();
	String NameJsonData =	objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	
	System.out.println("Details :"+NameJsonData);
		
		
	}
	
	//DeSeralization json to pojo
	@Test
	public void jsonToPojo() {
		/*
		 * String jsonData = "{\r\n" + "  \"City\" : \"Ryanstad\",\r\n" +
		 * "  \"country\" : \"Equatorial Guinea\",\r\n" +
		 * "  \"job\" : \"Max E. Mumm\",\r\n" + "  \"name\" : \"Wade Schoen\"\r\n" +
		 * "}";
		 */
		
		
		File file = new File("src/test/resources/testdata.json");
		ObjectMapper objMapper= new ObjectMapper();
		
	POJOclass dataa =	objMapper.readValue(file, POJOclass.class);
	System.out.println("Name is :"+dataa.name);
	System.out.println("Job is :"+dataa.job);
	System.out.println("country is :"+dataa.country);
	System.out.println("City is :"+dataa.City);
	
		
	}
	

}
