package com.selenium.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static String url = "";
	static WebDriver driver = null;
	

	public static void launchActiTimeApplication(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.get(url);
		driver.manage().window().maximize();
		
	}

}
