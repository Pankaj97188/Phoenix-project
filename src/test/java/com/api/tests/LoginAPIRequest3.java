package com.api.tests;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class LoginAPIRequest3 {
	public static void main(String[] args) {
		
		baseURI = "http://139.59.91.96:9000/v1";
		
		Response response = given()
		.header("Content-type", "application/json")
		.body("{\r\n"
				+ "    \"username\": \"iamfd\",\r\n"
				+ "    \"password\": \"password\"\r\n"
				+ "}")
		.post("login");
		//Buider Design Pattern!!! Selenium WebDriver!!
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());

	}
}
