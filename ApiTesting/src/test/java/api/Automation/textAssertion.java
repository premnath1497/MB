package api.Automation;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class textAssertion {
	
	@Test
	public void textAssert() {
		RestAssured.baseURI="https://reqres.in/";
		
		given().get("/api/users").then().assertThat()
		
		.body("total", equalTo(12))
		
		.and()
		
		.body("data[0].first_name", is(equalTo("George")));
		
		//base URI with Rest Assured class
	      RestAssured.baseURI = "https://reqres.in/";

	      //obtain Response from GET request
	      Response res = given()
	      .when()
	      .get("/api/users");

	      //convert JSON to string
	      JsonPath j = new JsonPath(res.asString());

	      //Zip for 2nd Location array
	      String secondLocationOfArray = j.getString("data[0].last_name");
	      System.out.println("Zip for 2nd Location array: " + secondLocationOfArray);

	}

}
