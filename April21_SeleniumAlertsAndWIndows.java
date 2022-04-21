package com.selenium.automation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class April21_SeleniumAlertsAndWIndows extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		multipleFrameHandling();	
		driver.quit();
		
	}
	
	public static void multipleFrameHandling()
	{
		launchActiTimeApplication("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_default");
		//driver.switchTo().frame("iframeResult"); // switching based on Id or Name
		//driver.switchTo().frame(0); // switching based on Index ( from top to bottom starts with 0 )
		//switching by creating the webELement of the frame..
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frame);
		
		String text = driver.findElement(By.xpath("//h1[text()='This is a Heading']")).getText();
		System.out.println(text);
		
		// switicng back to the main tml page from a Frame
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
	}
	
	public static void windowHandleEx1()
	{
		/*
		Set<String> hSet = new TreeSet<String>();
		hSet.add("Selenium");
		hSet.add("Java");
		hSet.add("Automation");
		hSet.add("Testing");
		
		System.out.println(hSet);
		
		Iterator itr = hSet.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		*/
		launchActiTimeApplication("https://demo.actitime.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		Set<String> winHandles = driver.getWindowHandles();
		
		System.out.println(winHandles);		
		Iterator<String> Wids = winHandles.iterator();		
		
		String firstWindowId = Wids.next();
		String secondWindowID = Wids.next();
		
		driver.switchTo().window(secondWindowID);		
		System.out.println(driver.getTitle());		
		driver.close(); 
		
		// Close closes the active window ( where the focus is there )
		//Quit will close all the windows which are opened by Selenium
		
		driver.switchTo().window(firstWindowId);		
		System.out.println(driver.getTitle());
		
	}
	
	
	
	public static void popUpExamp1() throws InterruptedException
	{
		launchActiTimeApplication("https://erail.in/");
		driver.findElement(By.xpath("//a[@title='View the route of the train on the map']")).click();
		Thread.sleep(3000);
		
		WebDriver.TargetLocator wt = driver.switchTo();
		Alert alrt = wt.alert();
		String alrtText = alrt.getText();
		System.out.println(alrtText);
		alrt.accept();
		
		//driver.switchTo().alert().accept();
		
		//to click on No Button of the alert use
		//driver.switchTo().alert().dismiss();	
		
	}

}
