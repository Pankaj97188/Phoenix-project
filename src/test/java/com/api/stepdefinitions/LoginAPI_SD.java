package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.pojo.LoginRequestPOJO;
import com.utility.TestUtility;

public class LoginAPI_SD {

	Response response;
	RequestSpecification request;

	@Given("the baseurl of the backend app is {string}")
	public void the_baseurl_of_the_backend_app_is(String url) {
		baseURI = url;
	}

	@Given("the header passed is {string}  {string}")
	public void the_header_passed_is(String name, String value) {

		request = given().header("Content-Type", "application/json");
	}

	@Given("the user credentials are {string} {string}")
	public void the_user_credentials_are(String userName, String password) {
		LoginRequestPOJO login = new LoginRequestPOJO(userName, password);
		System.out.println(login);
		System.out.println(TestUtility.convertPOJOToJSON(login));

		request.body(TestUtility.convertPOJOToJSON(login));
	}

	@When("I make a POST api request to the endpoint {string}")
	public void i_make_a_post_api_request_to_the_endpoint(String endPoint) {

		response = request

				.post(endPoint);
	}

	@Then("the status code needs to be {int}")
	public void the_status_code_needs_to_be(Integer status) {

		response.then().log().all().assertThat().statusCode(status);
	}

	@Then("the response time should be less {int} ms")
	public void the_response_time_should_be_less_ms(Integer time) {

		response.then().assertThat().time(Matchers.lessThan((long) time));

	}

	@Then("the response body should contain message as {string}")
	public void the_response_body_should_contain_message_as(String value) {

		response.then().assertThat().body("message", Matchers.equalTo(value));
	}

	@Then("a token should be generated")
	public void a_token_should_be_generated() {

		response.then().assertThat().body("data.token", Matchers.notNullValue());

	}

	@Then("the response body should be a json body")
	public void the_response_body_should_be_a_json_body() {

		response.then().assertThat().headers("content-type", "application/json; charset=utf-8");
	}

}
