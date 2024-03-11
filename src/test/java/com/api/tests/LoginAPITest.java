package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Env;
import com.pojo.LoginRequestPOJO;
import static com.utility.TestUtility.*;

import io.restassured.response.Response;

public class LoginAPITest {
	
	
	private LoginRequestPOJO loginRequestPOJO ;
	private String data;
	//either Slow or falky.... .
	@BeforeMethod(description = "Setting up the Base URL and Test Data Pojo")
	public void setup() {
//		baseURI = readConfigFile(Env.QA, "BASE_URL"); //3 years
		baseURI = readJsonFile(Env.QA, "base_url");
		loginRequestPOJO = new LoginRequestPOJO("iamfd", "password");
	}
	
	
	
	/*
	 * Test NG and JUNIT 5
	 * @ ----- Labels -----------  Extra information about a particular method or class!!
	 */
	@Test(description = "Verify if the FD is able to Login using Login API", groups ={"sanity", "smoke", "api"} , retryAnalyzer = com.listeners.ReTestListener.class)
	public void loginAPITest() {
		
		String a[] = {"abc", "pe"};
		/*Small 
		 * Independent
		 * Category 
		 * Conditional Statments 
		 * Loops 
		 * No decalaration 
		 */
		
	
	  given()
		 		.header("Content-type", "application/json")
		 		
		.and()
				.header("ABC","123")
		.and()
				.body(convertPOJOToJSON(loginRequestPOJO))
		.when()		
		.log().all() //Log Request
				.post("login")
				
		.then()
		.log().all() ////Log Response
			.assertThat()
			.statusCode(200)
			.time(lessThan(800L))
		.and()
				.body("message",equalTo("Success"))
				.and()
				.extract()
				.jsonPath().getString("data.token");// Comparsion
	System.out.println(data);
	}
}
