package com.pojo;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.google.gson.Gson;

public class Runner3 {

	public static void main(String[] args) {

		CreateJobPOJO fakePOJO = getFakeCreateJobPOJO();
		String data = convertPOJOToJSON(fakePOJO);
		System.out.println(data);
	}

	public static String convertPOJOToJSON(Object createJobPOJO) { // Tightly Coupled!! --------Loosely Coupled!!
		Gson gson = new Gson();
		String json = gson.toJson(createJobPOJO);
		return json;
	}

	public static CreateJobPOJO getFakeCreateJobPOJO() {
		Faker faker = new Faker();

		String data = faker.name().firstName();
		String ldata = faker.name().lastName();
		String mobileNumber = faker.numerify("A#B#C#");
		String emailAddress = faker.internet().emailAddress();

		CustomerPOJO customerPOJO = new CustomerPOJO(faker.name().firstName(), faker.name().lastName(),
				faker.numerify("9#########"), "", faker.internet().emailAddress(), "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO(faker.address().buildingNumber(), "abc",
				"street road", "abc mall", "MG road", "411005", "Maharastra", "India");
		Customer_Product_POJO customer_Product_POJO = new Customer_Product_POJO("2023-06-10T18:30:00.000Z",
				"40486011257803", "40486011257803", "40486011257803", "2023-06-10T18:30:00.000Z", 1, 1);

		Problem problems[] = new Problem[3]; // Array of NON PRIMITIVE DATA: CLASS
		// each index is a reference variable!!

		problems[0] = new Problem(1, "Camera not working");
		problems[1] = new Problem(2, "Battery not working");
		problems[2] = new Problem(3, "Display not working");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(1, -2, 1, 2, customerPOJO, customerAddressPOJO,
				customer_Product_POJO, problems);

		return createJobPOJO;
	}

}
