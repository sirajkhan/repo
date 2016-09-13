package com.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.utils.DriverMethod;

public class Basepage extends DriverMethod{

	WebDriver driver;
	WebDriverWait wait;

	public Basepage(){
		this.driver = DriverMethod.driver;
		wait = new WebDriverWait(driver, 5);
	}

	public void get(String url){
		driver.get(url);
	}

	public String getPageTitle(){
		return driver.getTitle();
	}
}
