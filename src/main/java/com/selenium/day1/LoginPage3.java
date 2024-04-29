package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Browser;
import com.utility.BrowserUtil;

public class LoginPage3 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); // Tight Coupling!! Loose Coupling
		wd.get("http://phoenix.testautomationacademy.in/sign-in");

		// Locators 8
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		By userNameTextBoxLocator = By.id("username");
		WebElement userNameTextBoxElement = wd.findElement(userNameTextBoxLocator);
		userNameTextBoxElement.clear();
		userNameTextBoxElement.sendKeys("iamfd");

		By passwordTextBoxLocator = By.id("password");
		WebElement passwordTextBoxElement = wd.findElement(passwordTextBoxLocator);
		passwordTextBoxElement.clear();
		passwordTextBoxElement.sendKeys("password");

		By signInButtonLocator = By.xpath("//span[contains(text(),\"Sign in\")]/../..");
		WebElement signInButtonElement = wd.findElement(signInButtonLocator);
		signInButtonElement.click();

	}

}
