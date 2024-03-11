package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.TestUtility;

public class ReTestListener implements IRetryAnalyzer {
	private static int count = 1;
	private static final int MAX_ATTEMPT = Integer.parseInt(TestUtility.readConfigFile(Env.QA, "MAX_ATTEMPT")); // CONSTANTS........
//Convert String to integer...  Wrapper Classes
	
	@Override
	public boolean retry(ITestResult result) {
		// Logic for this retry method!!!
		// retry is true----- the failed method will be re executed....

		// retry is false------ testng will not reexecute the failed method!!!

		if (count <= MAX_ATTEMPT) {
			count = count + 1;
			return true;
		} else {

			return false;
		}
	}

}
/*
 * 
 * RequestSpecfication ------ How the request looks Response ------ info of your
 * api response Listeners IRetryAnalyzer ------- How you will rerun the failed
 * tests.....
 */
