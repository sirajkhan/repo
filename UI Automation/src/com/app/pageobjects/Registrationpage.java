package com.app.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.app.utils.ObjectRepository;

public class Registrationpage extends Basepage{

	ObjectRepository obj;

	public Registrationpage(){
		obj = new ObjectRepository("C:\\Users\\Siraj Khan\\workspace\\UI Automation\\src\\UI Map\\Registrationpage.properties");
	}

	public void input_name(String first_name, String last_name){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("firstname")));
		driver.findElement(obj.getLocator("firstname")).sendKeys(first_name);

		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("lastname")));
		driver.findElement(obj.getLocator("lastname")).sendKeys(last_name);
	}

	public void input_username(String user_name){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("username")));
		driver.findElement(obj.getLocator("username")).sendKeys(user_name);
	}

	public void input_password(String password){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("password")));
		driver.findElement(obj.getLocator("password")).sendKeys(password);
	}

	public void input_confirm_password(String confirm_password){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("confirm_password")));
		driver.findElement(obj.getLocator("confirm_password")).sendKeys(confirm_password);
	}

	public void select_birth_month(String month){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("birth_month")));
		driver.findElement(obj.getLocator("birth_month")).click();

		List<WebElement> elements = new ArrayList<WebElement>();
		elements = driver.findElement(obj.getLocator("birth_month")).findElements(obj.getLocator("dropdown_menu"));

		for(WebElement el : elements){
			if (el.getText().equals(month)){
				el.click();
				break;
			}
		}
	}

	public String get_birth_month(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getLocator("birth_month")));
		return driver.findElement(obj.getLocator("birth_month")).getText().replaceAll("\n", "").trim();
	}
}
