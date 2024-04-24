package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class HTTPRequest {
    int id;
	@Test(priority = 1)
	public void listUsers() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2))

				.log().all();

	}

	@Test(priority=2)
	public void createUser() {
		Map<String, Object> hm = new HashMap<>();
//		hm.put("name", "Premnath");
//		hm.put("job", "Software Test Engineer");
		
		JSONObject request=new JSONObject(hm);
//		System.out.println(request);
		request.put("name", "Premnath Suryawanshi");
		request.put("job", "Software Engineer");
		System.out.println(request.toJSONString());
		
		id=given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).when().post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
//		.then()
//		.statusCode(201).log().all();
		
//		given()
//		.header("Content-Type", "application/json").body(hm)
//		.when().post("https://reqres.in/api/users")
//		.then()
//		.statusCode(201).log().all();
//		
//		RestAssured.baseURI="https://reqres.in/api/users";
//		String json="{\r\n"
//				+ "    \"name\": \"Premnath\",\r\n"
//				+ "    \"job\": \"leader\"\r\n"
//				+ "}";
//		RestAssured.given().body(json).post().then().log().all()
//		   .assertThat().statusCode(201);
	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	public void UpdateUser() {
		JSONObject request=new JSONObject();
//		System.out.println(request);
		request.put("name", "Premnath Suryawanshi");
		request.put("job", "Software Engineer");
		System.out.println(request.toJSONString());
		
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).when().put("https://reqres.in/api/users/"+id)
		
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

}
