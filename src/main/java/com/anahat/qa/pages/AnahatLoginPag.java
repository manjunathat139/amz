package com.anahat.qa.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class AnahatLoginPag

{
	WebDriver driver;
	public AnahatLoginPag(WebDriver driver)
	{
		this.driver=driver;
	}
		@FindBy(id="demoemail")
		WebElement username;
		
		
		@FindBy(how=How.ID, using="demopass")
		WebElement password;
		
		@FindBy(how=How.XPATH, using="//div[@id='submit-button']")
		WebElement submit_button;

	public void loginPage(String un, String pwd)
	{
		//Fill user name
		username.sendKeys(un);
		
		//Fill user password
		password.sendKeys(pwd);
		
		 //Click Login button
		submit_button.click();
		
	}
}
	
	
