package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//define page factory (object repository)
	
	@FindBy(name="q")
	WebElement q;
	
	//@FindBy(name="username")
	//WebElement username;
	
	//customised xpath if name is not found in <input> tag
	//@FindBy(xpath="//input[@type='submit']")
	//WebElement loginBtn;
	
	@FindBy(name="btnK")
	WebElement btnK;
	
	//initializing page objects
	public LoginPage() {
		
		PageFactory.initElements(driver,this);//this means pointing to current class
	}
	
	//Actions
	public String validateLoginPage()
	{
		return driver.getTitle();
	}
	
	public HomePage Login(String data)
	{
		q.sendKeys(data);
		btnK.click();
		
		return new HomePage();
	}
	

}
