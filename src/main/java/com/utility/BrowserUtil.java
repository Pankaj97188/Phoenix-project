package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	/*
	 * A very special class which will holding all the Selenium WebDriver methods It
	 * will created a way that my team members or Non tech person can understand it
	 * 
	 * DDD : Domain Driven Design
	 * 
	 */
	private WebDriver wd;// webdriver cannot be static!!
	// Then you cannot do parallel testing
	//

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
	}

	
	public void maximizeTheWindow() {
		wd.manage().window().maximize();
	}
}
