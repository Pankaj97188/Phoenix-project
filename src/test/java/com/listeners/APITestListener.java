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
import com.aventstack.extentreports.reporter.configuration.Theme;

public class APITestListener implements ITestListener {

    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private ExtentSparkReporter extentSparkReporter;

    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getName()).assignCategory(result.getMethod().getGroups()).assignDevice(System.getProperty("os.name") + "  "+ System.getProperty("os.arch") + " "  +System.getProperty("os.version"))
        		.assignAuthor(System.getProperty("user.name"));
        logTestDetails(result);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*********************************" + result.getName()
                + " Test Passed!! ********************************* ");
        System.out.println("End TIME" + result.getEndMillis());
        extentTest.pass("Test passed!!");
      String  response = (String) result.getAttribute("response");
        System.out.println("Response from Test Failure:");
        extentTest.log(Status.INFO,"Test passed!!" +response);
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*********************************" + result.getName()
                + " Test Failed!! ********************************* ");
        System.out.println("End TIME" + result.getEndMillis());
        Markup m = MarkupHelper.createCodeBlock(result.getThrowable().getMessage());
        extentTest
        .fail(new RuntimeException("A runtime exception occurred!"));
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("*********************************" + result.getName()
                + " Test Skipped!!! ********************************* ");
        System.out.println("End TIME" + result.getEndMillis());
        extentTest.skip("Test Skipped!!!");
    }

    public void onStart(ITestContext context) {
        System.out.println("********************************* TestSuite Started********************************* ");
        initializeExtentReports();
    }

    public void onFinish(ITestContext context) {
        System.out.println("********************************* TestSuite Completed!!!!!!********************************* ");
        extentReports.flush();
    }

    private void logTestDetails(ITestResult result) {
        System.out.println("*********************************" + result.getName()
                + "Test Started ********************************* ");
        System.out.println("DESCRIPTION:" + result.getMethod().getDescription());
        System.out.println("GROUPS:" + Arrays.toString(result.getMethod().getGroups()));
        System.out.println("START TIME" + result.getStartMillis());
        extentTest.log(Status.INFO, "DESCRIPTION:" + result.getMethod().getDescription());
        extentTest.log(Status.INFO, "GROUPS:" + Arrays.toString(result.getMethod().getGroups()));
    }

    private void initializeExtentReports() {
    	
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//report.html");
        extentSparkReporter.config().setCSS("css-string");
        extentSparkReporter.config().setDocumentTitle("Phoenix API Test Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("API Test Reports");


        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }
}
