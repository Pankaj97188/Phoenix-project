package com.api.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.pojo.LoginRequestPOJO;
import com.utility.TestUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJobSD2 {
	private String token;
	private Response response;
	private RequestSpecification request ;
	private LoginRequestPOJO loginRequestPOJO;

	@Given("the base URL of the application is {string}")
	public void the_base_url_of_the_application_is(String url) {
		RestAssured.baseURI = url;
		request = RestAssured.given();
	}

	@Given("FD used the credentials {string} and {string}")
	public void fd_used_the_credentials(String username, String password) {
		loginRequestPOJO = new LoginRequestPOJO(username, password);
	}

	@When("a post request is made to the endpoint {string}")
	public void a_post_request_is_made_to_the_endpoint(String endpoint) {
		response = RestAssured.given().contentType(ContentType.JSON)
				.body(TestUtility.convertPOJOToJSON(loginRequestPOJO)).post(endpoint);
	}
	
	

	@Then("a JWT token is created")
	public void a_jwt_token_is_created() {
		response.then().log().all();
		//	response.then().assertThat().body("data.token", Matchers.not(null));
	token=	response.then().extract().body().jsonPath().getString("data.token");
	System.out.println("TOKEN-------------" +token);
	}

	@Given("the Header for the request is")
	public void the_header_for_the_request_is(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("TOKEN-------------" +token);

		List<Map<String, String>> dataMap = dataTable.asMaps();
		for (Map<String, String> data : dataMap) {
			String key = data.get("Key");
			String value = data.get("Value");
			request.header(key, value);
		}

		request.header("Authorization", token);
	}

	@When("I make a POST request to the endpoint {string} with the following request body:")
	public void i_make_a_post_request_to_the_endpoint_with_the_following_request_body(String endpoint,
			String requestBody) {
		response = request.body(requestBody).log().all().post(endpoint);
	}

	@Then("a job number needs to be created")
	public void a_job_number_needs_to_be_created() {
	}

	@Then("the job number should be an integer")
	public void the_job_number_should_be_an_integer() {
	}

	@Then("a customer ID should be created")
	public void a_customer_id_should_be_created() {
	}

	@Then("the customer ID should be an integer")
	public void the_customer_id_should_be_an_integer() {
	}

	@Then("the status code should be {int}")
	public void the_status_code_should_be(int statusCode) {
		response.then().log().all().statusCode(statusCode);
	}
}
