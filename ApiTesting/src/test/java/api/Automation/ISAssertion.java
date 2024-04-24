package api.Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ISAssertion {

	@Test
	public void isOperator() {
		
        RestAssured.baseURI="https://reqres.in/";
		
		given().get("/api/users").then().assertThat()
		
		.body("total", equalTo(12))
		
		.and()
		
		.body("data[0].first_name", is(("George")));
		
		
	}
	

}
