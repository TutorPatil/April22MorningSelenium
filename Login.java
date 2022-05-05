package com.actitime.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v100.page.Page.CaptureScreenshotFormat;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.base.BaseClass;
import com.actitime.utils.CommonUtils;

public class Login extends BaseClass{
	
	@Test
	public static void login_001() throws Exception
	{
		boolean result = false;		
		
		
		writeLogs("Starting the Test Case Login_001");		
	    launchApplication("");
		
		writeLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.loginToActiTimeApplication();
		
		// Checking the result to be equal to true
		Assert.assertTrue(result, "Could not login to ActiTime application..");	
		
		//Assert.assertFalse(result, "aadDWDAD"); // To check a condition to be false.
		
		int expectedCount = 10;
		int actualCount = 10;
		
		// Used for checking two values or strings for equality
		Assert.assertEquals(expectedCount, actualCount,"Both counts does not match");	
		
		writeResultsToFile("Login_001", "Pass");	
		
		closeBrowser();	
		
	}
	
	// InValid login Test Case -login_002
	public static void login_002() throws Exception
	{
		boolean result = false;			
		try {	
		writeLogs("Starting the Test Case Login_002");		
		launchApplication("");
		
		writeLogs("Trying to login to the actitime application by calling login method..");		
		result = CommonUtils.loginToActiTimeApplication("admin"	,"manager123");
		}catch (Exception e)
		{		
			e.printStackTrace();			
		}	
		finally {
			if(result)
			{			
				writeResultsToFile("Login_002", "Failed");
				captureScreenShotOnFailure("Login_002");
				
			}
			else
			{
				writeResultsToFile("Login_002", "Pass");
				
			}			
			closeBrowser();
		}
		
	}
	
	
	
	
	
}
