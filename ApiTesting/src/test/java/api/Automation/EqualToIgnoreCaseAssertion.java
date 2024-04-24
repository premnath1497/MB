package api.Automation;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class EqualToIgnoreCaseAssertion {
	
	@Test
	public void equalToIgnoreCase() {
		RestAssured.baseURI="https://reqres.in/";
		
		given().get("/api/users").then().assertThat()
		
		.body("data[1].first_name", equalToIgnoringCase("janet"))
		
		.and()
		
		.body("data[3].avatar",startsWith("https"))
		
		.body("data[3].avatar",endsWith("jpg")).and()
		
		.body("data[1].email",containsString("janet"));
		
		
		
		
				
	}

}
