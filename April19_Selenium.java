package com.selenium.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class April19_Selenium {

	public static String url = "http://demo.actitime.com/";
	static WebDriver driver = null;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		findElementsEx3();
		
	}
	
	public static void findElementsEx3() throws InterruptedException
	{
		launchActiTimeApplication();
		driver.get("file:///D:/Morning_Selenium_April22/Login2.html");
		
		
		List<WebElement> links = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		
		System.out.println(links.size());
		
		for(WebElement m : links)
		{
			System.out.println(m.getText());
		}
		
		
		
		
	}
	
	
	public static void findElementsEx2() throws InterruptedException
	{
		launchActiTimeApplication();
		driver.get("https://www.google.com/");
		
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Download Selenium");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='CqAVzb lJ9FBc']/center/input[1]")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//h3"));
		
		System.out.println(links.size());
		
		for(WebElement m : links)
		{
			System.out.println(m.getText());
		}
		
		
		
		
	}
	
	public static void findElementsEx()
	{
		launchActiTimeApplication();
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		System.out.println(links.size());
		
		for(int x=0; x<links.size();x++)
		{
			System.out.println(links.get(x).getText());
		}
		
		
	}
	
	public static void invalidLogin() throws InterruptedException
	{
		String expected_errorMsg = "Username or Password is invalid. Please try again.";
		
		launchActiTimeApplication();
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager123");		
		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		
		Thread.sleep(8000);		
		
		WebElement errorMsg = driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']"));
	
		boolean isDisplayed = errorMsg.isDisplayed();		
			
		
		if(isDisplayed)
		{
			System.out.println("The Test case passed....");
		}
	}
	
	
	
	public static void getTextEx()
	{
		String linkText = driver.findElement(By.xpath("//a[@id='toPasswordRecoveryPageLink']")).getText();
		System.out.println(linkText);
	}
	//Comment
	
	public static void launchActiTimeApplication()
	{
		System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.get(url);
		
	}
	

}
