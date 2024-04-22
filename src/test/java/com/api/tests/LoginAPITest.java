package com.api.tests;

import static io.restassured.RestAssured.*; //in RA all methods are stattic

import static org.hamcrest.Matchers.*; // What is hamcrest --->Matchers in your Frameworks?? Matchers (Class) unit tests [range check]

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Env; //Enums?? Class store Constants?? 3[properties, enum, Interface]
import com.pojo.LoginRequestPOJO; // Design Pattern POJO [ encapsultation, transfer pojo design ----> POJO --- JSON (Serialization
// Gson 
import static com.utility.TestUtility.*; //Reusable [read file prop, json, tokens TU]

import io.restassured.response.Response;

@Listeners(com.listeners.APITestListener.class) //Listeners ---- ITestListeners
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
		//JOB of the retry analyzer re run falky test!!!
		
		String a[] = {"abc", "pe"};
		/*Small 
		 * Independent
		 * Category 
		 * Conditional Statments 
		 * Loops 
		 * No decalaration 
		 */
		
	
data=	  given()
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
			.time(lessThan(2800L))
		.and()
				.body("message",equalTo("Success"))
				.and()
				.extract()
				.jsonPath().getString("data.token");// Comparsion
	System.out.println(data);
	
	Reporter.getCurrentTestResult().setAttribute("response", data);
	}
}
