package com.app.pageobjects;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.app.utils.ObjectRepository;
import com.app.utils.ObjectRepository;


public class Aboutpage extends Basepage{

	ObjectRepository obj;

	public Aboutpage(){
		obj = new ObjectRepository("C:\\Users\\Siraj Khan\\workspace\\UI Automation\\src\\UI Map\\aboutpage.properties");
	}

	public void click_create_an_account(){
		String current_window_handle = driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("create_an_account_link")));
		driver.findElement(obj.getLocator("create_an_account_link")).click();

		for(String el : driver.getWindowHandles()){
			if (el.equals(current_window_handle)){
				driver.switchTo().window(current_window_handle);
				driver.close();
			}
		}
	}
}
