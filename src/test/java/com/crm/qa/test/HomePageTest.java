package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	String sheetName="Sheet1";
	
	public HomePageTest()
	{
		super(); //calls the super class(base class) constructor ie;testbase.java
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); //launch browser
		
		//create object of login page class
		loginPage=new LoginPage();
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		//System.out.println("before verify home page title test.......");
		String homePageTitle = loginPage.validateLoginPage();
		//System.out.println("Inside verify home page title test.......");
		
		//actual and expected value should match
		Assert.assertEquals(homePageTitle, "Google","Home Page Title not matched");
		
		//actual and expected value should not match
		//Assert.assertNotEquals(homePageTitle, "Google");
		
		homePage= loginPage.Login(prop.getProperty("q"));
	}
	
	/*@Test(priority=2)
	public void verifyLinkTest()
	{
		
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Google","Home Page Link not matched");
	}*/
	
	/*@Test(priority=2)
	public void loginTest()
	{
		homePage= loginPage.Login(prop.getProperty("m"));
	}*/
	
	/*@Test(priority=3)
	public void verifyMavenLabelTest()
	{
		
		Assert.assertTrue(homePage.verifyMavenLabel() , "Maven label is missing");
	}*/
	
	@Test(priority=2)
	public void validateLinkClickSelenium()
	{
		homePage= loginPage.Login(prop.getProperty("q"));
		System.out.println("IN TEST 2" +homePage.verifyMavenLabel());
		
		//if the value returned is true,then test is passed else failed
		//Assert.assertTrue(homePage.verifyMavenLabel());
		
		//if the value returned is false,then test is passed else failed
		//Assert.assertFalse(homePage.verifyMavenLabel());
		
		homePage.clickOndisplayedLinkSelenium();
	}
	
	@Test(priority=3)
	public void validateLinkClick()
	{
		homePage= loginPage.Login(prop.getProperty("m"));
		homePage.clickOndisplayedLink();
	}
	
	//method to fetch test data from excel an returns the data(values not hardcoded here)
	
	/*@DataProvider
	public Object[][] getTestDataValues()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getTestDataValues")
	public void validateExcelData(String title,String fname,String lname)
	{
		//pass the parameters here and call method
	}*/
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
