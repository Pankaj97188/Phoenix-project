package com.selenium.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	private WebDriverWait wait;
	//

	public BrowserUtil(WebDriver wd) {
		super();
		this.wd = wd; // assigning the session!! [LoginPage ------> Other page Classes
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}

	public BrowserUtil() {

	}

	public void launchBrowser(Browser browser) {
		if (browser == Browser.CHROME) {
			wd = new ChromeDriver();

		}

		else if (browser == Browser.FIREFOX) {
			wd = new FirefoxDriver();

		}
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));

	}

	public void goToWebSite(String url) {
		wd.get(url);
//		sleepFor(5);
	}

	public void maximizeTheWindow() {
		wd.manage().window().maximize();
	}

	public void enterTextInto(By locator, String textToEnter) {
		// WebElement element = wd.findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(textToEnter);
	}

	public void clickOn(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
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
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String data = element.getText();
		return data;

	}

	public WebDriver getWd() {
		return wd;
	}

}
