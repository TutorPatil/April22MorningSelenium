package com.selenium.automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class May2_ActionsClass extends BaseClass{

	public static void main(String[] args) throws Exception {
		actionsEx3();
		
		//driver.quit();

	}
	
	
	
	public static void actionsEx3() throws Exception
	{
	
	launchActiTimeApplication("https://marcojakob.github.io/dart-dnd/basic/");
	
	// Creating the object of actions class to handle mouse and keyboard actions
	Actions actions = new Actions(driver);
	
	WebElement whereToDrop = driver.findElement(By.xpath("//div[@class='trash']"));
	
	WebElement itemToDrag = driver.findElement(By.xpath("//div[@class='trash']/../img[1]"));
	
	actions.dragAndDrop(itemToDrag,whereToDrop).build().perform();
	
	
	
	}
	
	public static void actionsEx2() throws Exception
	{
	
	launchActiTimeApplication("https://erail.in/");
	
	// Creating the object of actions class to handle mouse and keyboard actions
	Actions actions = new Actions(driver);
	
	driver.findElement(By.id("cmbQuota")).click();
	
	
	actions.sendKeys(Keys.DOWN).build().perform();
	Thread.sleep(2000);
	
	
	actions.sendKeys(Keys.DOWN).build().perform();
	Thread.sleep(2000);
	
	
	actions.sendKeys(Keys.DOWN).build().perform();
	
	
	}
	
	public static void actionsEx1() throws Exception
	{
		
		launchActiTimeApplication("https://demo.actitime.com/");	
	
		driver.findElement(By.id("username")).click();
		
			
		// Creating the object of actions class to handle mouse and keyboard actions
		Actions actions = new Actions(driver);
		
		Thread.sleep(2000);		
		
		actions.keyDown(Keys.SHIFT).sendKeys("admin").build().perform();
		Thread.sleep(2000);
		
		actions.keyUp(Keys.SHIFT).build().perform();
		
		driver.findElement(By.id("username")).clear();
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		
		
		// Need to use .build().perform ( from Action class to perform the key baord/mouse operations)
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		actions.sendKeys("manager").build().perform();
		
		actions.sendKeys(Keys.TAB).build().perform();
		
		Thread.sleep(2000);
		actions.sendKeys(Keys.SPACE).build().perform();
		
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).build().perform();
		
		
			
		
		
		
	}

	
}
