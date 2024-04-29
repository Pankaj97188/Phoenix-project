package com.selenium.day1;

import static com.selenium.day1.PhoenixLocator.locateByID;
import static com.selenium.day1.PhoenixLocator.locateByXPATH;

import org.openqa.selenium.By;

import com.utility.Browser;
import com.utility.BrowserUtil;

public final class SignInPage extends BrowserUtil {
	/*
	 * Locators are always going to the class variables!! private static final
	 * [constant] page methods!! public ------ indicate the functionality of that
	 * page [1 method] doSigninWith() Page Methods will always return something!!!
	 * You cannot have void return type in Page Classes!!
	 * 
	 * 
	 * 
	 */

	private static final By USER_NAME_LOCATOR = locateByID("username");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = locateByID("password");
	private static final By SIGN_IN_BUTTON_LOCATOR = locateByXPATH("//span[contains(text(),'Sign in')]/../..");

	public SignInPage(Browser browser) {
		super();//
		launchBrowser(browser);
		goToWebSite("http://phoenix.testautomationacademy.in/sign-in");

	}

	public DashboardPage doSignInWith(String userName, String password) {
		// TEST STEPS!!!!
		enterTextInto(USER_NAME_LOCATOR, userName);
		enterTextInto(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);

		DashboardPage xx = new DashboardPage(getWd());
		return xx;

	}

}
