package day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Requests {
	
	int id;
	@Test(priority = 1)
	public void listUsers() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2))

				.log().all();

	}

	
	
	@Test(priority = 2)
	public void createUser() {
		HashMap<String, Object> data = new HashMap<>();
		data.put("name", "Mayur");
		data.put("job", "Software Test Engineer");
	    id= given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(data).when().post("https://reqres.in/api/users/2")
		.jsonPath().getInt("id");
		
      }
	
	@Test(priority = 3)
	public void UpdateUser() {
		HashMap<String, Object> data = new HashMap<>();
		data.put("name", "Mayur");
		data.put("job", "Software Test Engineer");
	    
		
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(data).when().put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200).log().all();
	}
	
	@Test(priority = 4)
	public void deleteUser() {
		given()
		
		.when().delete("https://reqres.in/api/users/"+id)
		
		.then().statusCode(204)
		.log().all();
	}
	
        @Test(priority = 5)
	public void deleteUser2() {
		given()
		
		.when().delete("https://reqres.in/api/users/"+id)
		
		.then().statusCode(204)
		.log().all();
	}
	
}
