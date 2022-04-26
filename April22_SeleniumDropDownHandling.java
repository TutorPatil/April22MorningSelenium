package com.selenium.automation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class April22_SeleniumDropDownHandling extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		Login_001();
		
		driver.quit();
		
	}
	
	public static void Login_001() throws IOException
	{
		try {
			
		
		launchActiTimeApplication("http://demo.actitime.com");
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='pwd123']")).sendKeys("manager");
		}
		finally
		{
			takeScreenShot("Login_001");
		}
		
		

		
	}
	
	public static void takeScreenShotEx1(String fileName) throws IOException
	{
		launchActiTimeApplication("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		
		//Downcast driver to TakeScreenshot level
		TakesScreenshot ts =	((TakesScreenshot)driver);
		
		// Use the getScreenShotAs method to capture the screenshot
		File srcFile =	ts.getScreenshotAs(OutputType.FILE);

		// Create another file where you want  to copy the screenshot captured.
		File destFile = new File("./results/screenshots/sampleScreenshot.png");
		
		// To copy the screenshot file to destination...
		Files.copy(srcFile, destFile);

		
	}
	
	public static void takeScreenShot(String fileName) throws IOException
	{
		//launchActiTimeApplication("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		
		//Downcast driver to TakeScreenshot level
		TakesScreenshot ts =	((TakesScreenshot)driver);
		
		// Use the getScreenShotAs method to capture the screenshot
		File srcFile =	ts.getScreenshotAs(OutputType.FILE);

		// Create another file where you want  to copy the screenshot captured.
		File destFile = new File("./results/screenshots/"+fileName+".png");
		
		Files.copy(srcFile, destFile);

		
	}
	
	public static void multiSelectDropDownEx1() throws InterruptedException
	{		
		launchActiTimeApplication("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		
		driver.switchTo().frame("iframeResult"); // Switching to the Frame 
		WebElement comboBox = driver.findElement(By.xpath("//select[@id='cars']"));
		
		Select comboSelect = new Select(comboBox);
		
		System.out.println(comboSelect.isMultiple());
		
		comboSelect.selectByIndex(0);
		Thread.sleep(2000);
		comboSelect.selectByValue("opel");
		Thread.sleep(2000);
		comboSelect.selectByVisibleText("Audi");
		Thread.sleep(2000);
		comboSelect.deselectByVisibleText("Opel");
		comboSelect.deselectAll();
		Thread.sleep(2000);
		comboSelect.selectByVisibleText("Audi");
		comboSelect.selectByIndex(0);
		
		// To get all the items which are present in the multi select List
		List<WebElement> items = comboSelect.getOptions();
		System.out.println("No of items present in the Multi Select list is "+items.size());
		
		// To get all the options which are selected from the multiple list
		List<WebElement> SelectedItems=comboSelect.getAllSelectedOptions();
		for ( WebElement m : SelectedItems)
		{
			System.out.println(m.getText());
		}
		
		
		
		
	}
	
	public static void dropDownEx1() throws InterruptedException
	{		
		launchActiTimeApplication("https://erail.in/");
		WebElement comboBox = driver.findElement(By.xpath("//select[@id='cmbQuota']"));
		
		Select comboSelect = new Select(comboBox);
		
		comboSelect.selectByIndex(2); // Selecting by Index
		Thread.sleep(2000);
		comboSelect.selectByValue("DF"); // Selecting by the value Attribute
		Thread.sleep(2000);
		comboSelect.selectByVisibleText("Foreign"); // Selecting using the vissible Text
		
		// To find which Item is selected
		WebElement item =comboSelect.getFirstSelectedOption();
		
		System.out.println(item.getText());		
		List<WebElement> items = comboSelect.getOptions();
		
		int totalItems = items.size();
		System.out.println("Total Number of Items present in the dropdown box "+totalItems);
		
		// looping through the list
		for(WebElement m : items)
		{
			System.out.println(m.getText());
		}
		
		System.out.println(comboSelect.isMultiple());
		
		
	}

}
