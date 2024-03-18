package com.api.tests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Env;
import com.constants.Roles;
import com.pojo.CreateJobPOJO;
import com.pojo.LoginRequestPOJO;
import com.utility.TestUtility;

import static com.utility.TestUtility.*;

import static io.restassured.RestAssured.*;

public class CreateJobAPITest {

	CreateJobPOJO createJobPOJO;

	@BeforeMethod(description = "Setting up the Base URL and Test Data Pojo")
	public void setup() {
		baseURI = TestUtility.readConfigFile(Env.QA, "BASE_URL");
		createJobPOJO = getFakeCreateJobPOJO();

	}

	@Test(description = "Verify if the FD is able to create the Inwarranty Job!!!", groups = { "regression",
			"e2e", "api" })
	public void createJobAPITest() {

		jobId = given().header("Content-type", "application/json").and()
				.header("Authorization", TestUtility.generateAuthToken(Roles.FD)).and()
				.body(convertPOJOToJSON(createJobPOJO)).when().log().all().post("job/create").then().log().all()
				.assertThat().statusCode(200).extract().jsonPath().getInt("data.id");

	}

}
