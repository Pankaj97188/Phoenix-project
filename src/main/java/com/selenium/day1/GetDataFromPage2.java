package com.selenium.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utility.Browser;
import com.utility.BrowserUtil;

public class GetDataFromPage2 {

	public static void main(String[] args) {
		Browser b = new Browser();
		util.launchBrowser(Browser.CHROME);
		util.goToWebSite("https://www.google.com");
		util.maximizeTheWindow();
	}

}
