package com.selenium.day1;

public class CreateJobTable {
	private String OEM;
	private String Job_Number;
	private String Imei_Serial_No;
	private String Product;
	private String Model;
	private String Warranty_Status;
	private String Action_Status;
	
	public CreateJobTable(String oEM, String job_Number, String imei_Serial_No, String product, String model,
			String warranty_Status, String action_Status) {
		super();
		OEM = oEM;
		Job_Number = job_Number;
		Imei_Serial_No = imei_Serial_No;
		Product = product;
		Model = model;
		Warranty_Status = warranty_Status;
		Action_Status = action_Status;
	}
	
	

	public String getOEM() {
		return OEM;
	}



	public String getJob_Number() {
		return Job_Number;
	}



	public String getImei_Serial_No() {
		return Imei_Serial_No;
	}



	public String getProduct() {
		return Product;
	}



	public String getModel() {
		return Model;
	}



	public String getWarranty_Status() {
		return Warranty_Status;
	}



	public String getAction_Status() {
		return Action_Status;
	}



	@Override
	public String toString() {
		return "CreateJobTable [OEM=" + OEM + ", Job_Number=" + Job_Number + ", Imei_Serial_No=" + Imei_Serial_No
				+ ", Product=" + Product + ", Model=" + Model + ", Warranty_Status=" + Warranty_Status
				+ ", Action_Status=" + Action_Status + "]";
	}
	
	
}
