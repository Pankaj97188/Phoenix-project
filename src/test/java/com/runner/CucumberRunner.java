package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { "src/test/resources/api_features/" }, 
		glue = { "com.api.stepdefinitions" },
		plugin = { "pretty",
		"html:reports/cucumber-html-report.html", "json:reports/cucumber.json" },
		monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
}
