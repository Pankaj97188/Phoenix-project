package com.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.day1.CreateJobTable;
import com.selenium.day1.PhoenixLocator;

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

	public CreateJobTable getAllElements(By locator) {
		// wd.findElements(locator);
		WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		WebElement rowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PhoenixLocator.locateByXPATH("//mat-row")));
		List<WebElement> cellList = rowElement.findElements(PhoenixLocator.locateByXPATH("//mat-cell"));

		CreateJobTable data = new CreateJobTable(cellList.get(0).getText(), cellList.get(1).getText(),
				cellList.get(2).getText(), cellList.get(3).getText(), cellList.get(4).getText(),
				cellList.get(5).getText(), cellList.get(6).getText());
		return data;
	}

}
