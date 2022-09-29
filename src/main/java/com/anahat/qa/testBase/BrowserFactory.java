package com.anahat.qa.testBase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url)
	{
		// Open the browser
		if(browserName.equalsIgnoreCase("firefox"))
				{
				String key="webdriver.gecko.driver";
				String value="./software/geckodriver.exe";
				System.setProperty(key, value);
				driver=new FirefoxDriver();
				}
		else if(browserName.equalsIgnoreCase("chrome"))
				{
				String key="webdriver.chrome.driver";
				String value="./software/chromedriver.exe";
				System.setProperty(key, value);
				driver=new ChromeDriver();
	}
		else if(browserName.equalsIgnoreCase("IE"))
				{
			    driver=new InternetExplorerDriver();
				}
		
				//To maximize the window	
				driver.manage().window().maximize();
				
				//delete all cookies
				driver.manage().deleteAllCookies();
				
				//To launch a site
				driver.get(url);
				
				//To set the script timeout to 5 seconds
				driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
				
				return driver;
	}
	
	
}
