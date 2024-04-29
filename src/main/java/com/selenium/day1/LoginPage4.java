package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Browser;
import com.utility.BrowserUtil;

public class LoginPage4 {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		bu.launchBrowser(Browser.CHROME);
		bu.maximizeTheWindow();
		bu.goToWebSite("http://phoenix.testautomationacademy.in/sign-in");
		bu.sleepFor(5);
		By userNameTextBoxLocator = By.id("username");
		bu.enterTextInto(userNameTextBoxLocator, "iamfd");
		By passwordTextBoxLocator = By.id("password");
		bu.enterTextInto(passwordTextBoxLocator, "password");
		By signInButtonLocator = By.xpath("//span[contains(text(),\"Sign in\")]/../..");
		bu.clickOn(signInButtonLocator);

	}

}
