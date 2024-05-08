package com.selenium.day1;

import com.utility.BrowserUtil;
import static com.selenium.day1.PhoenixLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BrowserUtil {

	private static final By USER_ICON_BUTTON_LOCATOR = locateByXPATH("//mat-icon[@data-mat-icon-name=\"user-circle\"]");
	private static final By USER_NAME_LOCATOR = locateByXPATH("//span[contains(text(), \"Signed in as\")]/../span[2]");

	
	public DashboardPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		super(wd);
	}
	public String getUserName() {
		// TestStep
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String data = getVisibileText(USER_NAME_LOCATOR);
		return data;
	}
}
