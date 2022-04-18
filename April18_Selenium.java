package com.selenium.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class April18_Selenium {
	
	public static String url = "http://demo.actitime.com/";
	static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		login_002();
		
		
	}
	
	public static void login_002() throws Exception
	{
		
		String expected_errorMsg = "Username or Password is invalid. Please try again.";
		
		launchActiTimeApplication();
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager123");		
		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		
		Thread.sleep(8000);		
		
		WebElement errorMsg = driver.findElement(By.xpath("//span[contains(text(),'Username or Password')]"));
		
		boolean errorMsgDisplayed = errorMsg.isDisplayed();
		
		String actualErrorMsg = errorMsg.getText();
		System.out.println(actualErrorMsg);
		
		
		if((errorMsgDisplayed) && (actualErrorMsg.equals(expected_errorMsg)))
		{
			System.out.println("Actitime login_002 Test case Passed");
		}
		else
		{
			System.out.println("Actitime login_002 Test case Failed!!");
		}
		
		driver.quit();
		
	}
	
	public static void login_001() throws InterruptedException
	{
		launchActiTimeApplication();
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		
		driver.findElement(By.xpath("//input[@id='keepLoggedInCheckBox']")).click();
		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		
		Thread.sleep(8000);		
		
		boolean logoutDisaplyed = driver.findElement(By.xpath("//a[@id='logoutLink']")).isDisplayed();
		
		
		if(logoutDisaplyed)
		{
			System.out.println("Actitime login_001 Test case Passed");
		}
		else
		{
			System.out.println("Actitime login_001 Test case Failed!!");
		}
		
		driver.close();
	}

	
	public static void launchActiTimeApplication()
	{
		System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.get(url);
		
	}
}
