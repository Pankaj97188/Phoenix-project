package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

import com.constants.Component;
import com.constants.TestType;

public class Runner {
//This is a very Important feature for your Framework!!!
// USP J
	public static void main(String[] args) {

		// Running your ATF
		// Testng XML Dynamically created Java

		Component component = Component.valueOf(args[0].toUpperCase()) ; // ui api mobile
		TestType testType = TestType.valueOf(args[1].toUpperCase());// SMOKE SANITY E2E regression

		// USE TestNG Class
		// Create Dynamical XML for us
		TestNG testNG = new TestNG();

		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName(component + " " + testType + "Suite");// suite name="All API Test Suite
		xmlSuite.setParallel(ParallelMode.TESTS); // Parallel= "tests"
		xmlSuite.setThreadCount(2); // thread-count ="2"
//<suite name="All API Test Suite" guice-stage="QA" Parallel= "tests" thread-count ="2">

		XmlTest xmlTest = new XmlTest(xmlSuite);
		xmlTest.setName("Phoenix App Test " + component + " " + testType);
		// <test name="API Tests">

		// ArrayList
		String componentData = component.toString().toLowerCase();// API ------api
		String testTypeData = testType.toString().toLowerCase();// SMOKE----->smoke

		XmlPackage xmlPackage = new XmlPackage("com." + componentData + ".tests");

		List<XmlPackage> packageList = new ArrayList<>();
		packageList.add(xmlPackage);

		xmlTest.setPackages(packageList);
		xmlTest.addIncludedGroup(testTypeData); // smoke

		List<XmlTest> testList = new ArrayList<>();
		testList.add(xmlTest);

		xmlSuite.setTests(testList);

		List<XmlSuite> suiteList = new ArrayList<>();
		suiteList.add(xmlSuite);

		testNG.setXmlSuites(suiteList);
		testNG.run();// Java ---> TestNG Class to Create the above config xml file (in memo) and it will executed!!

	}

}
