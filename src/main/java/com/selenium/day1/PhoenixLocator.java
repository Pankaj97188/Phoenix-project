package com.selenium.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class PhoenixLocator extends By {

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static By locateByID(String id) {
		return id(id);
	}
	
	public static By locateByXPATH(String xpath) {
		return xpath(xpath);
	}

}
