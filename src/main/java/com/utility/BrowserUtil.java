package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserUtil {
	/*
	 * A very special class which will holding all the Selenium WebDriver methods It
	 * will created a way that my team members or Non tech person can understand it
	 * 
	 * DDD : Domain Driven Design
	 * 
	 */
	protected WebDriver wd;// webdriver cannot be static!!
	// Then you cannot do parallel testing
	//

	public BrowserUtil(WebDriver wd) {
		super();
		this.wd = wd; //assigning the session!! [LoginPage ------> Other page Classes
	}
	
	public BrowserUtil(){
		
	}
	

	public void launchBrowser(Browser browser) {
		if (browser == Browser.CHROME) {
			wd = new ChromeDriver();
		}

		else if (browser == Browser.FIREFOX) {
			wd = new FirefoxDriver();

		}
	}

	public void goToWebSite(String url) {
		wd.get(url);
		sleepFor(5);
	}

	public void maximizeTheWindow() {
		wd.manage().window().maximize();
	}

	public void enterTextInto(By locator, String textToEnter) {
		WebElement element = wd.findElement(locator);
		element.clear();
		element.sendKeys(textToEnter);
	}

	public void clickOn(By locator) {
		WebElement element = wd.findElement(locator);
		element.click();
	}

	public void sleepFor(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getVisibileText(By locator) {
		WebElement element = wd.findElement(locator);
		String data = element.getText();
		return data;

	}

	public WebDriver getWd() {
		return wd;
	}

}
