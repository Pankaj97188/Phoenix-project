package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.selenium.day1.PhoenixLocator.*;
import com.utility.Browser;
import com.utility.BrowserUtil;

public class LoginPage5 {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		bu.launchBrowser(Browser.CHROME);
		bu.maximizeTheWindow();
		bu.goToWebSite("http://phoenix.testautomationacademy.in/sign-in");
		bu.sleepFor(5);
		bu.enterTextInto(locateByID("username"), "iamfd");
		bu.enterTextInto(locateByID("password"), "password");
		bu.clickOn(locateByXPATH("//span[contains(text(),'Sign in')]/../.."));

	}

}
