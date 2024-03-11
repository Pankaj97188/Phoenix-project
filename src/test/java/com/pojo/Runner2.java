package com.pojo;

import com.google.gson.Gson;

public class Runner2 {

	public static void main(String[] args) {
		CustomerPOJO customerPOJO = new CustomerPOJO("Ali", "A", "9999999999", "", "ali@gmail.com", "");
		CustomerAddressPOJO customerAddressPOJO = new CustomerAddressPOJO("101", "abc", "street road", "abc mall",
				"MG road", "411005", "Maharastra", "India");
		Customer_Product_POJO customer_Product_POJO = new Customer_Product_POJO("2023-06-10T18:30:00.000Z",
				"40486011257803", "40486011257803", "40486011257803", "2023-06-10T18:30:00.000Z", 1, 1);

		Problem problems[] = new Problem[3]; // Array of NON PRIMITIVE DATA: CLASS
		// each index is a reference variable!!

		problems[0] = new Problem(1, "Camera not working");
		problems[1] = new Problem(2, "Battery not working");
		problems[2] = new Problem(3, "Display not working");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(1, -2, 1, 2, customerPOJO, customerAddressPOJO,
				customer_Product_POJO, problems);
		System.out.println(createJobPOJO);

		Gson gson = new Gson();
		String data = gson.toJson(createJobPOJO);
		System.out.println(data);

	}

}
