package com.selenium.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDataFromPage {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); // Tight Coupling!! Loose Coupling
		// ie
		// One of the important of OOP is that objects are always created of child
		// classes!!!
		// thats final
		// WebDriver p =new ChromeDriver();
		/*
		 * Why do I need to write this WebDriver wd = new ChromeDriver(); ChromeDriver
		 * c= new ChromeDriver();
		 * 
		 */
		
		System.out.println(wd);
		
		wd.get("http://139.59.91.96:5001/selenium-workbook/hello-webdriver.html");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
