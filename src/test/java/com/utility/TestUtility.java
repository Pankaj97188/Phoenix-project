package com.utility;

import static com.utility.TestUtility.convertPOJOToJSON;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;
import com.constants.Roles;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.pojo.CreateJobPOJO;
import com.pojo.CustomerAddressPOJO;
import com.pojo.CustomerPOJO;
import com.pojo.Customer_Product_POJO;
import com.pojo.LoginRequestPOJO;
import com.pojo.Problem;

import io.restassured.path.json.JsonPath;

public class TestUtility {
	// all the methods and all the variables are STATIC in nature!!!!
	public static int jobId;

	public static String convertPOJOToJSON(Object object) { // Tightly Coupled!! --------Loosely Coupled!!
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}

	public static String readConfigFile(String env, String keyName) {
		/*
		 * Tell Java where the file is present? Perform the read operation
		 * 
		 * 
		 */

		File configFile = new File(
				"C:\\Users\\Admin\\Desktop\\Batches\\PhoenixAutomationFramework-Aug\\config\\" + env + ".properties");
		FileReader fileReader = null;
		Properties properties = new Properties(); // Read Propetities

		try {
			fileReader = new FileReader(configFile);

			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String data = properties.getProperty(keyName);

		return data;

	}

	public static String readConfigFile(Env env, String keyName) {
		/*
		 * Tell Java where the file is present? Perform the read operation
		 * 
		 * 
		 */

		// How to Convert an ENUM to String
//		//String to Enum  
//		
//		env.valueOf("QA"); //ENUM
		File configFile = new File(
				"C:\\Users\\Admin\\Desktop\\Batches\\PhoenixAutomationFramework-Aug\\config\\" + env + ".properties");
		FileReader fileReader = null;
		Properties properties = new Properties(); // Read Propetities

		try {
			fileReader = new FileReader(configFile);

			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String data = properties.getProperty(keyName);

		return data;

	}

	public static CreateJobPOJO getFakeCreateJobPOJO() {
		Faker faker = new Faker();

		String data = faker.name().firstName();
		String ldata = faker.name().lastName();
		String mobileNumber = faker.numerify("A#B#C#");
		String emailAddress = faker.internet().emailAddress();
		String imeiNumber = faker.numerify("##############");
		CustomerPOJO customerPOJO = new CustomerPOJO(faker.name().firstName(), faker.name().lastName(),
				faker.numerify("9#########"), "", faker.internet().emailAddress(), "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO(faker.address().buildingNumber(), "abc",
				"street road", "abc mall", "MG road", "411005", "Maharastra", "India");
		Customer_Product_POJO customer_Product_POJO = new Customer_Product_POJO("2023-06-10T18:30:00.000Z", imeiNumber,
				imeiNumber, imeiNumber, "2023-06-10T18:30:00.000Z", 1, 1);

		Problem problems[] = new Problem[3]; // Array of NON PRIMITIVE DATA: CLASS
		// each index is a reference variable!!

		problems[0] = new Problem(1, "Camera not working");
		problems[1] = new Problem(2, "Battery not working");
		problems[2] = new Problem(3, "Display not working");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(0, 2, 1, 1, customerPOJO, customerAddressPOJO,
				customer_Product_POJO, problems);

		return createJobPOJO;

	}

	// how to read a json file in your project??
	// where you have use a json file in your ATF...
	// dynamic

	public static String readJsonFile(Env env, String keyName) {
		// RA
		File file = new File(
				"C:\\Users\\Admin\\Desktop\\Batches\\PhoenixAutomationFramework-Aug\\data\\" + env + ".json");

		JsonPath jsonPath = new JsonPath(file);

		String data = jsonPath.getString(keyName);
		return data;

	}

	public static String generateAuthToken(String roles) {
		/*
		 * I will the roless.... Generate Token and return back!! ---- LOGIN API REquest
		 * ----- Fetch value of token and i will return back FD SUP ENG QC CC FST
		 */
		LoginRequestPOJO loginPOJO = null;
		if (roles.equalsIgnoreCase("FD")) {
			loginPOJO = new LoginRequestPOJO("iamfd", "password");
		} else if (roles.equalsIgnoreCase("QC")) {
			loginPOJO = new LoginRequestPOJO("iamqc", "password");
		}

		else if (roles.equalsIgnoreCase("SUP")) {
			loginPOJO = new LoginRequestPOJO("iamsup", "password");
		}

		else if (roles.equalsIgnoreCase("ENG")) {
			loginPOJO = new LoginRequestPOJO("iameng", "password");
		}

		else if (roles.equalsIgnoreCase("FST")) {
			loginPOJO = new LoginRequestPOJO("iamfst2", "password");
		}

		else if (roles.equalsIgnoreCase("CC")) {
			loginPOJO = new LoginRequestPOJO("iamcc", "password");
		}

		else {
			System.err.print("Invalid Roles.... Valid Roles CC QC FST FS SUP ENG");
		}

		String authtoken = given().header("Content-type", "application/json")

				.and().header("ABC", "123").and().body(convertPOJOToJSON(loginPOJO)).when()

				.post("login")

				.then()

				.extract().jsonPath().getString("data.token");// Comparsion

		return authtoken;
	}

	public static String generateAuthToken(Roles roles) {
		/*
		 * I will the roless.... Generate Token and return back!! ---- LOGIN API REquest
		 * ----- Fetch value of token and i will return back FD SUP ENG QC CC FST
		 */
		LoginRequestPOJO loginPOJO = null;
		if (roles == Roles.FD) {
			loginPOJO = new LoginRequestPOJO("iamfd", "password");
		} else if (roles == Roles.QC) {
			loginPOJO = new LoginRequestPOJO("iamqc", "password");
		}

		else if (roles == Roles.SUP) {
			loginPOJO = new LoginRequestPOJO("iamsup", "password");
		}

		else if (roles == Roles.ENG) {
			loginPOJO = new LoginRequestPOJO("iameng", "password");
		}

		else if (roles == Roles.FST) {
			loginPOJO = new LoginRequestPOJO("iamfst2", "password");
		}

		else if (roles == Roles.CC) {
			loginPOJO = new LoginRequestPOJO("iamcc", "password");
		}

		else {
			System.err.print("Invalid Roles.... Valid Roles CC QC FST FS SUP ENG");
		}

		String authtoken = given().header("Content-type", "application/json")

				.and().header("ABC", "123").and().body(convertPOJOToJSON(loginPOJO)).when()

				.post("login")

				.then()

				.extract().jsonPath().getString("data.token");// Comparsion

		return authtoken;
	}

}
