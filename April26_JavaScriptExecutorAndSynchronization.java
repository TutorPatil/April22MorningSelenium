package com.selenium.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class April26_JavaScriptExecutorAndSynchronization extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		explicitWait();

	}
	
	
	public static void explicitWait() throws InterruptedException
	{
		launchActiTimeApplication("http://demo.actitime.com/");		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		
		
		// WebDriver wait is used for explicit wait create the object of WebDriverWait class
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));		
		
		
		boolean logoutDisaplyed = driver.findElement(By.xpath("//a[@id='logoutLink']")).isDisplayed();		
		System.out.println(logoutDisaplyed);
		driver.quit();
	}	
	
	public static void implicitWaitEx() throws InterruptedException
	{
		launchActiTimeApplication("http://demo.actitime.com/");
		
		// implicit wait is applied only once and is applicable for the life span of the driver.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		
		// To get the implicit wait time which is applied , by default it will be zero
		Duration  d = driver.manage().timeouts().getImplicitWaitTimeout();
		System.out.println(d.getSeconds());
		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();		
		boolean logoutDisaplyed = driver.findElement(By.xpath("//a[@id='logoutLink']")).isDisplayed();
		
		System.out.println(logoutDisaplyed);
		driver.quit();
	}

	
	public static void threadSleepEx() throws InterruptedException
	{
		launchActiTimeApplication("http://demo.actitime.com/");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		
		Thread.sleep(8000);		
		
		boolean logoutDisaplyed = driver.findElement(By.xpath("//a[@id='logoutLink']")).isDisplayed();
		
		System.out.println(logoutDisaplyed);
	}

}
