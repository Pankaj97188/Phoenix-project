package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPIRequest {
	public static void main(String[] args) {
		// first API Request!!!

		/*
		 * Baseurl endpoint httpverb body header
		 */

		RestAssured.baseURI = "http://139.59.91.96:9000/v1";// base url is set!!!
		// make an request!!

		// BDD
		RequestSpecification request = RestAssured.given(); //Loosely Coupling!!
		//Controlling how the request will look
		
		request.header("Content-Type", "application/json"); //attaching the header to request!!
		request.body("{\r\n"
				+ "    \"username\": \"iamfd\",\r\n"
				+ "    \"password\": \"password\"\r\n"
				+ "}");
		Response response =request.post("login");
	
		System.out.println(response.asPrettyString());
		
		
		System.out.println(response.statusCode());
	
	}
}
