package api.Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ObjectAssertion {
	
	@Test
	public void objectAssertion() {
		RestAssured.baseURI="https://reqres.in/";
		given().get("/api/unknown").then().statusCode(200).and()
		.assertThat().body("data[0]", hasKey("name"))
		.body("data[2]",hasValue(2002))
		.body("data[0]",hasEntry("color","#98B2D1"));
		
		
	}
	
	@Test
	public void hasitemAssertion() {
		RestAssured.baseURI="https://reqres.in/";
		given().get("/api/unknown").then().statusCode(200).and()
		.assertThat().body("data[0]", hasItems("cerulean"));
	}

}
