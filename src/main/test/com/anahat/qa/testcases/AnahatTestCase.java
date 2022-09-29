package com.anahat.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Anahat_Pages.AnahatHomePage;
import Anahat_Pages.AnahatLoginPag;
import Anahat_Pages.Reports;
import Anahat_Pages.anahatDemographicPage;
import Browser.BrowserFactory;

public class AnahatTestCase 
{

	static WebDriver driver;

	@Test
	public void checkValidUser() throws Exception
	{
		driver= BrowserFactory.startBrowser("firefox", "http://anahat.axxonet.me/home");
		 
//		//Verify login page title
//		String loginTitle = driver.getTitle();
//		String ExpectedLoginTitle ="Welcome - Anahat";
//		Assert.assertEquals(ExpectedLoginTitle,loginTitle);
//	
		AnahatLoginPag login=PageFactory.initElements(driver, AnahatLoginPag.class);
		
		//login to application
		login.loginPage("anahatadmin@axx.com", "axxonet");
		
//		//Verify home page
//		String HomeTitle = driver.getTitle();
//		String ExpectedHomeTitle ="Adult - Dashboard - Anahat";
//		Assert.assertEquals(ExpectedHomeTitle,HomeTitle);
		
		
	// go the next page
//		AnahatHomePage homePage = PageFactory.initElements(driver, AnahatHomePage.class);
//		homePage.selectgender();

//		anahatDemographicPage Demographic = PageFactory.initElements(driver, anahatDemographicPage.class);
//		
//		Demographic.selectpatient();
		
		

//		Verify Health Screening page
//		String ActualTitle = driver.getTitle();
//		String ExpectedTitle ="Health Screening - Anahat";
//		Assert.assertEquals(ExpectedTitle, ActualTitle);
		
//		Thread.sleep(10000);
//		
//		
//		Reports reportDetails = PageFactory.initElements(driver, Reports.class);
//		reportDetails.ReportPatient();
		
	}
	
	
//	@AfterTest
//	public void closer() 
//		{
//		//close the browser
//		driver.quit();	
//	}
}
