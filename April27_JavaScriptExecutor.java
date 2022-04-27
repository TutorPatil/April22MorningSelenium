package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class April27_JavaScriptExecutor extends BaseClass {

	public static void main(String[] args) {
		
		replacingTextInXPath();
		
		driver.quit();

	}
	
	public static void javaScriptExecutorEx1()
	{
		
		launchActiTimeApplication("http://demo.actitime.com/");
		
		JavascriptExecutor jsEx = (JavascriptExecutor)driver;
		
		String title = (String) jsEx.executeScript("return document.title");
		
		System.out.println(title);
		
		driver.quit();
		
	}
	

	public static void javaScriptExecutorEx2()
	{
		
		launchActiTimeApplication("http://demo.actitime.com/");
		
		JavascriptExecutor jsEx = (JavascriptExecutor)driver;
		long links = (Long) jsEx.executeScript("return document.getElementsByTagName('a').length");
		
		System.out.println(links);
		
		driver.quit();
		
	}
	
	public static void javaScriptExecutorEx3()
	{
		
		launchActiTimeApplication("http://demo.actitime.com/");		
		JavascriptExecutor jsEx = (JavascriptExecutor)driver;
		
		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("pwd"));
		WebElement loginBtn = driver.findElement(By.id("loginButton"));
		
		// all arguments in one line..
		//jsEx.executeScript("arguments[0].value='admin',arguments[1].value='manager'", userName,password);	
		jsEx.executeScript("arguments[0].value='admin'", userName);
		jsEx.executeScript("arguments[0].value='manager'", password);
		jsEx.executeScript("arguments[0].click()", loginBtn);			
	
	}
	
	public static void replacingTextInXPath()
	{
		// Xpath for all the links in the page		
		String link = "//a[text()='--TEXTTOREPLACE--']";
		
		
		launchActiTimeApplication("file:///D:/Morning_Selenium_April22/Login2.html");		
		
		String  locator = "//td[text()='--TEXTTOREPLACE--']/../td[3]";		
		// Generaing the xpath after replacing the Text
		String locator1 = locator.replace("--TEXTTOREPLACE--", "Krishna");
		
		//String s = "India is a great country";
		//System.out.println(s.replace("great", "cultural"));
		
	
		
		System.out.println(locator);
		System.out.println(locator1);
		
		String mobile = driver.findElement(By.xpath(locator1)).getText();
		
		System.out.println(mobile);
		
		
		
		
		
		
	}
	
	

}
