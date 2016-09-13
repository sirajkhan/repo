package com.app.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethod {

	public static WebDriver driver;

	public static void setUpDriver()
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Work\\Selenium_jars\\firefox_driver\\geckodriver-v0.10.0-win64\\geckodriver.exe");
//		driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium_jars\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	public static void goto_url(String url)
	{
		driver.get(url);
	}

	public static void terminateDriver()
	{
		driver.quit();
	}
}
