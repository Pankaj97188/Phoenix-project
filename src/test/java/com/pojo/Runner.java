package com.pojo;

import com.google.gson.Gson;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// STEP 1:
		LoginRequestPOJO loginRequestPOJO = new LoginRequestPOJO("iamfd", "password");
		System.out.println(loginRequestPOJO);

		// SAW JSON ------> POJO CLASS ------> POJO OBJECT ??
		// DYNAMICALLY CREATE JSON OBJECTS for us...
		// POJO Object loginRequestPOJO ------ into JSON by JAVA ---- JSON SERIALIZATION
		// IQ
		// FILE-- WORD---- CONVERT POJO OBJECT (Serialized)

		// 3rd party: POJO to JSON? -----> JAXSON and GSON (Google JSON)
		// WRITE SNIPPET ON how to convert JAVA OBJECT to JSON??

		Gson gson = new Gson();
		String data = gson.toJson(loginRequestPOJO);// pass reference variable of your POJO OBJECT
		System.out.println(data);
		
		// JSON to POJO is called DE SERIALIZATION
		
		String jsondata = "{ \"name\": \"Ali\"}";
		
		// Convert the JSON to POJO
		// DEserialization
		
		User user= gson.fromJson(jsondata, User.class);
		System.out.println(user);

		System.out.println(user.getName());
	}

}
