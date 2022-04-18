package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleWebDriver {

	public static void main(String[] args) {
		/*
		System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver.exe");		
		
		WebDriver driver = new ChromeDriver();		
		
		driver.get("https://google.com");
		
		String title = driver.getTitle();
		
		String cUrl = driver.getCurrentUrl();
		
		System.out.println(title);
		
		System.out.println(cUrl);
		
		String pageSource = driver.getPageSource();
		
		System.out.println(pageSource);
		
		driver.quit();
		
		*/
		
		System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver.exe");		
		
		WebDriver driver = new ChromeDriver();		
		
		driver.get("https://demo.actitime.com");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		
		userName.sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		
		driver.quit();
		
		
		
 
	}

}
