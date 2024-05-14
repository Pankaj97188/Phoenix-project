package com.selenium.day1;

import com.utility.Browser;

public class FetchCreateJobTableData {
public static void main(String[] args) {
	
	SignInPage signInPage = new SignInPage(Browser.CHROME);
	CreateJobTable data=signInPage.doSignInWith("iamfd", "password").openCreateJobTable();
	System.out.println(data.getOEM());
	System.out.println(data.getImei_Serial_No());
}
}
