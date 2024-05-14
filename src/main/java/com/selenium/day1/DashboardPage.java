package com.selenium.day1;

import com.utility.BrowserUtil;
import static com.selenium.day1.PhoenixLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BrowserUtil {

	private static final By USER_ICON_BUTTON_LOCATOR = locateByXPATH("//mat-icon[@data-mat-icon-name=\"user-circle\"]");
	private static final By USER_NAME_LOCATOR = locateByXPATH("//span[contains(text(), \"Signed in as\")]/../span[2]");
	private static final By CREATE_JOB_BUTTON_LOCATOR = locateByXPATH("//*[contains(text(),\" Created today\")]/../div/button");
	private static final By CREATE_JOB_TABLE_LOCATOR = locateByXPATH("//mat-table");
	public DashboardPage(WebDriver wd) {
	
		super(wd);
	}
	public String getUserName() {
		// TestStep
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String data = getVisibileText(USER_NAME_LOCATOR);
		return data;
	}
	
	public CreateJobTable openCreateJobTable() {
		clickOn(CREATE_JOB_BUTTON_LOCATOR);
	return 	getAllElements(CREATE_JOB_TABLE_LOCATOR);
		
	}
}
