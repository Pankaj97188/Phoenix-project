package com.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class APITestListener implements ITestListener {

	public void onTestStart(ITestResult result) { // ITestResult information about the test method? Desc, name, group
		// TODO Auto-generated method stub

		System.out.println("*********************************" + result.getName()
				+ "Test Started ********************************* ");
		System.out.println("DESCRIPTION:" + result.getMethod().getDescription());
		System.out.println("GROUPS:" + Arrays.toString(result.getMethod().getGroups()));
		System.out.println("START TIME" + result.getStartMillis());

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********************************" + result.getName()
				+ " Test Passed!! ********************************* ");
		System.out.println("End TIME" + result.getEndMillis());

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********************************" + result.getName()
				+ " Test Failed!! ********************************* ");
		System.out.println("End TIME" + result.getEndMillis());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********************************" + result.getName()
				+ " Test Skipped!!! ********************************* ");
		System.out.println("End TIME" + result.getEndMillis());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("********************************* TestSuite Started********************************* ");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(
				"********************************* TestSuite Completed!!!!!!********************************* ");

	}

}
