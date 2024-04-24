package day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



public class WaysToCreatePostRequestBody {
	
	// 1) Post Request Body Using Hashmap
	@Test
	public void testPostUsingHashMap() {
		
		HashMap<String,Object> data=new HashMap<>();
		data.put("name", "Premnath");
		data.put("location", "India");
		data.put("phone", "8381056749");
		String courseArr[] = {"API","RestAssured"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Premnath"))
		.body("location", equalTo("India"))
		.body("phone", equalTo("8381056749"))
		.body("courses[0]", equalTo("API"))
		.body("courses[1]", equalTo("RestAssured"))
		.header("Content-Type","application/json")
		.log().all();
		
	}
	
	// 2) Post Request Body Using JsonLibrary
	
	@Test
	public void testPostUsingJsonLibrary() {
		
		JSONObject data=new JSONObject();
		data.put("name", "Prem");
		data.put("location", "India");
		data.put("phone", "8381056749");
		String courseArr[] = {"Java","Selenium"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Prem"))
		.body("location", equalTo("India"))
		.body("phone", equalTo("8381056749"))
		.body("courses[0]", equalTo("Java"))
		.body("courses[1]", equalTo("Selenium"))
		.header("Content-Type","application/json")
		.log().all();
	}
	
	// Post Method Create Using POJO Class
	
	@Test
	public void testUsingPojoClass() {
		Pojo_PostRequest data=new Pojo_PostRequest();
		data.setName("Mayur");
		data.setLocation("Nagpur");
		data.setPhone("789654159");
		String courseArr[] = {"Manual","Automation"};
		data.setCourses(courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Mayur"))
		.body("location", equalTo("Nagpur"))
		.body("phone", equalTo("789654159"))
		.body("courses[0]", equalTo("Manual"))
		.body("courses[1]", equalTo("Automation"))
		.header("Content-Type","application/json")
		.log().all();
	}
	
	//Post Method Using External File
	@Test
	public void testUsingExternalFile() throws FileNotFoundException {
		File f=new File(".\\body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject();
		data.put("name", "Premnath");
		data.put("location", "India");
		data.put("phone", "8381056749");
		String courseArr[] = {"API","RestAssured"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Premnath"))
		.body("location", equalTo("India"))
		.body("phone", equalTo("8381056749"))
		.body("courses[0]", equalTo("API"))
		.body("courses[1]", equalTo("RestAssured"))
		.header("Content-Type","application/json")
		.log().all();
		
	}
}
