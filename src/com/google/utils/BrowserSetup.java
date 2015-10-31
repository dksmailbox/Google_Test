package com.google.utils;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {
	
	public enum BrowserType
		{
			FIREFOX, CHROME
		}

	   //  private static String firebugPath = PropertiesReader.getFireBugPath();
	    // private static String remoteMachineURL = PropertiesReader.getRemoteMachineURL();

	    private static BrowserType getBrowser() 
		    {	    	
		    	BrowserType browserType = null;
			    browserType = BrowserType.valueOf(PropertiesReader.getBrowserTypeProperty());
			    System.out.println("..BrowserSetup.getBrowser().." + browserType);
			    return browserType;
		    }	    

	    protected static WebDriver getFirefoxDriver() throws MalformedURLException 
		    {
				FirefoxDriver profile = new FirefoxDriver();		
				System.out.println("..BrowserSetup.getFirefoxDriver()..");
				return profile;
		    }
		    
	    public static WebDriver getWebDriver() throws MalformedURLException 
		    {
		    	System.out.println("..BrowserSetup.getWebDriver()..");
		    	WebDriver driver;
		    	BrowserType browserType = BrowserSetup.getBrowser();

			switch (browserType)
			{
				case FIREFOX:
				    driver = getFirefoxDriver();
				    driver.manage().window().maximize();
				    break;
				/*case CHROME:
					driver=get*/
				default:
				    driver = getFirefoxDriver();
				    driver.manage().window().maximize();
				    break;
			}
			return driver;
		    }
		

	}

