package api.Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAssuredDemo {
	
	@Test
	
	
	public void getUserDetailsUsingQueryParameter() {
		RestAssured.baseURI="https://reqres.in/";
		
		RestAssured.given().param("page", "2")
		.when().get("/api/users").then().statusCode(200);
		
		
	}

}
