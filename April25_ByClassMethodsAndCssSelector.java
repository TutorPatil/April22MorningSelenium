package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class April25_ByClassMethodsAndCssSelector extends BaseClass
{

	public static void main(String[] args) {
//		
		differentWaysOfLocatingElements();
	}
	
	public static void cssSelectorExampls()
	{
		
		
		
	}
	
	public static void differentWaysOfLocatingElements()
	{
		launchActiTimeApplication("https://demo.actitime.com/");
//		
//		By by = By.xpath("//input[@id='username']");
//		driver.findElement(by).sendKeys("admin");
//		
//		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
//		
		//locating by using id
		driver.findElement(By.id("username")).sendKeys("admin");
		
		// locating by using name
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		//locating by tagName ( usually gives a list of WebElement )
		driver.findElement(By.tagName("a"));
		
		// locating the elements using class Name ( class attribute , usually gives list)
		driver.findElement(By.className("textField"));
		
		//locating by using Link Text ( Equalent in xpath -> //a[text()='actiTIME Inc.'])
		WebElement linkText = driver.findElement(By.linkText("actiTIME Inc."));
		linkText.click();	
		
		
		//locating by usig partial link Text, portion of the Text , just like contains(text(), - Eualent in xpath --//a[contains(text(),'Forgot')]
		driver.findElement(By.partialLinkText("Forgot")).click();
		
		driver.findElement(By.cssSelector("input[id='forgetPasswordEmailOrUsername']")).sendKeys("tutorpatil@gmail.com");

		
		
		
		
		
		
		
		
	}

}
