package com.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class APITestListener implements ITestListener {

	private ExtentReports extentReports;
	private ExtentTest extentTest;
	private ExtentSparkReporter extentSparkReporter;

	public void onTestStart(ITestResult result) { // ITestResult information about the test method? Desc, name, group
		// TODO Auto-generated method stub
		extentTest = extentReports.createTest(result.getName());
		System.out.println("*********************************" + result.getName()
				+ "Test Started ********************************* ");
		System.out.println("DESCRIPTION:" + result.getMethod().getDescription());
		System.out.println("GROUPS:" + Arrays.toString(result.getMethod().getGroups()));
		System.out.println("START TIME" + result.getStartMillis());
		extentTest.log(Status.INFO, "DESCRIPTION:" + result.getMethod().getDescription());
		extentTest.log(Status.INFO, "GROUPS:" + Arrays.toString(result.getMethod().getGroups()));

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********************************" + result.getName()
				+ " Test Passed!! ********************************* ");
		System.out.println("End TIME" + result.getEndMillis());
		extentTest.pass("Test passed!!");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********************************" + result.getName()
				+ " Test Failed!! ********************************* ");
		System.out.println("End TIME" + result.getEndMillis());
		Markup m = MarkupHelper.createCodeBlock(result.getThrowable().toString());
		extentTest.fail(m);

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********************************" + result.getName()
				+ " Test Skipped!!! ********************************* ");
		System.out.println("End TIME" + result.getEndMillis());
		extentTest.skip("Test Skipped!!!");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("********************************* TestSuite Started********************************* ");
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//report.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(

				"********************************* TestSuite Completed!!!!!!********************************* ");
		extentReports.flush();
	}

}
