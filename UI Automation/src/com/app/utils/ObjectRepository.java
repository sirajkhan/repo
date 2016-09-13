package com.app.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectRepository {

	Properties prop;

	public ObjectRepository(String filePath){

		prop = new Properties();

		try	{
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
			fis.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public By getLocator(String getElement){

		String locator = prop.getProperty(getElement);

		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];

		switch (locatorType) {
		case "id":
			return By.id(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "cssSelector":
			return By.cssSelector(locatorValue);
		case "linkText":
			return By.linkText(locatorValue);
		case "className":
			return By.className(locatorValue);
		case "partialLinkText":
			return By.partialLinkText(locatorValue);
		default:
			System.out.println("Unknown locator Type : " + locatorType);
			return null;
		}
	}

}
