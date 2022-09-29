package com.anahat.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class verifyBrowser
{
WebDriver driver;

@Test
@Parameters("browser")
public void verifyTitle(String browserName)
{
	if(browserName.equalsIgnoreCase("firefox")){
		String key="webdriver.gecko.driver";
		String value="./software/geckodriver.exe";
		System.setProperty(key, value);
		driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("chrome")){
		String key="webdriver.gecko.driver";
		String value="./software/geckodriver.exe";
		System.setProperty(key, value);
		driver=new ChromeDriver();
	}
	
	driver.manage().window().maximize();
	driver.get("http://anahat.axxonet.me/home");
	System.out.println(driver.getTitle());
	driver.quit();	
	
}
	
}
