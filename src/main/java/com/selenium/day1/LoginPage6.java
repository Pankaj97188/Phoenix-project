package com.selenium.day1;

import com.utility.Browser;

public class LoginPage6 {
public static void main(String[] args) {
	
	SignInPage signInPage = new SignInPage(Browser.CHROME);
	String data=  signInPage.doSignInWith("iamfd", "password").getUserName();
	System.out.println(data);
}
}
