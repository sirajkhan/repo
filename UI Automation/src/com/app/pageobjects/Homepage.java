package com.app.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.app.utils.ObjectRepository;

public class Homepage extends Basepage{

	ObjectRepository objMap;

	public Homepage(){
		objMap = new ObjectRepository("C:\\Users\\Siraj Khan\\workspace\\UI Automation\\src\\UI Map\\homepage.properties");
	}

	public void enter_search_keyword(String keyword){
		wait.until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("search_input")));
		driver.findElement(objMap.getLocator("search_input")).sendKeys(keyword);
	}

	public List<String> get_search_results(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("search_results")));
		List<WebElement> web_elements = driver.findElements(objMap.getLocator("search_results"));
		ArrayList<String> elements = new ArrayList<String>();
		for (WebElement el : web_elements){
			elements.add(el.getText());
		}
		return elements;
	}

	public void click_gmail(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(objMap.getLocator("gmail_link")));
		driver.findElement(objMap.getLocator("gmail_link")).click();
	}

}
