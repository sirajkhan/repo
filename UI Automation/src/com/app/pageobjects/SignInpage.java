package com.app.pageobjects;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.app.utils.ObjectRepository;

public class SignInpage extends Basepage{

	ObjectRepository obj;

	public SignInpage(){
		obj = new ObjectRepository("C:\\Users\\Siraj Khan\\workspace\\UI Automation\\src\\UI Map\\SignInpage.properties");
	}

	public void click_create_account(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("create_account")));
		driver.findElement(obj.getLocator("create_account")).click();
	}
}
