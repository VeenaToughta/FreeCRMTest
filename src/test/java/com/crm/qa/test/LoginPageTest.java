package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super(); //calls the super class(base class) constructor ie;testbase.java
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		
		//create object of login page class
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTest()
	{
		String title = loginPage.validateLoginPage();
		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homePage= loginPage.Login(prop.getProperty("q"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
