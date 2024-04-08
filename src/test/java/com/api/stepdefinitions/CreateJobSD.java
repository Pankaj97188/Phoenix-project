package com.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import com.pojo.CreateJobPOJO;
import com.pojo.CustomerPOJO;
import com.utility.TestUtility;

public class CreateJobSD {

	RequestSpecification request;
	Response response;

	@Given("the base url of the application is {string}")
	public void the_base_url_of_the_application_is(String baseUrl) {
		baseURI = baseUrl;
		request = given();
	}

	@Given("the Header of for the request is")
	public void the_header_of_for_the_request_is(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> dataMap = dataTable.asMaps();
		for (Map<String, String> data : dataMap) {
			String key = data.get("Key");
			String value = data.get("Value");
			request.header(key, value);
		}

	}

	@Given("the request body is")
	public void the_request_body_is(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> dataMap = dataTable.asMaps();
		CustomerPOJO customer = null;
		String dataJson;
		for (Map<String, String> data : dataMap) {
			String customerName = data.get("CustomerName");
			String customerLastName = data.get("CustomerLastName");
			String imei = data.get("IMEI");
			String ProductName = data.get("ProductName");
			String ModelNumber = data.get("ModelNumber");
			String DOP = data.get("DOP");

			customer = new CustomerPOJO(customerName, customerLastName, imei, ProductName, ModelNumber, DOP);

		}

		dataJson = TestUtility.convertPOJOToJSON(customer);

		request.body(dataJson).log().all();

	}

	@When("I make a post request to the endpoint {string}")
	public void i_make_a_post_request_to_the_endpoint(String endpoint) {
		// Write code here that turns the phrase above into concrete actions
		response = request.post(endpoint);
		response.then().log().all();
	}

	@Then("job number needs to created")
	public void job_number_needs_to_created() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("job number should be int")
	public void job_number_should_be_int() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("customerid should created")
	public void customerid_should_created() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("customerid should be int")
	public void customerid_should_be_int() {

	}

	@Then("status code should be {int}")
	public void status_code_should_be(Integer status) {
		// Write code here that turns the phrase above into concrete actions
		response.then().assertThat().statusCode(status);

	}

}
