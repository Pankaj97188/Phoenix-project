package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class LoginAPIRequest2 {
	public static void main(String[] args) {
		
		baseURI = "http://139.59.91.96:9000/v1";
		
	String data=	 given()
		 		.header("Content-type", "application/json")
		.and()
				.body("{\r\n"
						+ "    \"username\": \"iamfd\",\r\n"
						+ "    \"password\": \"password\"\r\n"
						+ "}")
		.when()		
				.post("login")
				
		.then()
			.assertThat()
			.statusCode(200)
		.and()
				.body("message",equalTo("Success"))
				.and()
				.extract()
				.jsonPath().getString("data.token");// Comparsion
	System.out.println(data);
	}
}
