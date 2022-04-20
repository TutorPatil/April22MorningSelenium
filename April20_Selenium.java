package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class April20_Selenium {
	
	public static String url = "http://demo.actitime.com";
	static WebDriver driver = null;
	

	public static void main(String[] args) throws InterruptedException {
		windowOperations();
		
		driver.close();
	}
	
	public static void getAttributeEx()
	{
		launchActiTimeApplication();
		driver.get("https://www.flipkart.com");
		String toolip = driver.findElement(By.xpath("//img[@alt='Flipkart']")).getAttribute("title");
		System.out.println(toolip);
	}
	
	public static void webElementMethods() throws InterruptedException
	{
		launchActiTimeApplication();
		driver.get("file:///D:/Morning_Selenium_April22/Login2.html");
		driver.findElement(By.xpath("//input[@id='uname']")).sendKeys("patil");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='uname']")).clear();
		
		boolean enabled = driver.findElement(By.xpath("//button[@id='CanBtn']")).isEnabled();
		System.out.println("The cancel button is enabled "+enabled);
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='remcheck']"));
		
		System.out.println(checkBox.isSelected());
		checkBox.click();
		Thread.sleep(3000);
		System.out.println("After selecting the check box"+checkBox.isSelected());
		
		driver.quit();
		
	}
	
	public static void navigationsEg() throws InterruptedException
	{
		launchActiTimeApplication();
		
		driver.get("https://www.flipkart.com");
		
		
		WebDriver.Navigation wn = driver.navigate();
		
		wn.back();
		Thread.sleep(3000);
		wn.forward();
		Thread.sleep(3000);
		wn.refresh();
		wn.to("file:///D:/Morning_Selenium_April22/Login2.html");
		driver.quit();
	}
	
	public static void windowOperations() throws InterruptedException
	{
		launchActiTimeApplication();
		
		/*
		 * WebDriver.Options wo = driver.manage(); WebDriver.Window ww = wo.window();
		 * ww.maximize(); Thread.sleep(3000); driver.manage().window().minimize();
		 * Thread.sleep(3000); driver.manage().window().maximize(); Thread.sleep(3000);
		 */
		Dimension d = new Dimension(100,100);
		driver.manage().window().setSize(d);
		
		Thread.sleep(3000);
		Point p =new Point(200,200);
		driver.manage().window().setPosition(p);
		
		// another way to minimize window in selenium 3.x
		Thread.sleep(3000);
		Point p1 =new Point(-200,-200);
		driver.manage().window().setPosition(p1);
		
	}
	
	
	public static void launchActiTimeApplication()
	{
		System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.get(url);
		
	}
	

}
