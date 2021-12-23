package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends TestBase {
	
	@FindBy(name="m")
	WebElement m;
	
	@FindBy(name="btnK")
	WebElement btnK;
	
	//inspect and use of xpath for submit button
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	//customised xpath for link opened in google when I search selenium java
	@FindBy(xpath="//h3[contains(text(), 'Selenium with Java : Getting Started to Run Automated Tests')]")
	WebElement userLabel;
	
	//customised xpath for <a href> when that link is opened
	@FindBy(xpath="//h3[@class='LC20lb MBeuO DKV0Md']")
	@CacheLookup
	WebElement linkClickLabel;
	
	//customised xpath for link opened in google when I search maven
			@FindBy(xpath="//h3[@class='LC20lb MBeuO DKV0Md']")
			@CacheLookup
			WebElement userLabelForClick;
	
	//customised xpath for link opened in google when I search maven
			@FindBy(xpath="//h3[@class='LC20lb MBeuO DKV0Md']")
		WebElement userLabelMaven;
	
	//initializing page objects
	public HomePage() {
		PageFactory.initElements(driver,this);//this means pointing to current class
	}
	
	//checks the title of page
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage Login(String data)
	{
		m.sendKeys(data);
		btnK.click();
		
		return new HomePage();
	}
	
	public boolean verifyMavenLabel()
	{
		System.out.println("MAVEN LABEL..." +userLabelMaven.isDisplayed());
		return userLabelMaven.isDisplayed();
	}
	
	//click on the link selenium with java
	public TaskPage clickOnLink() {
		linkClickLabel.click();
		return new TaskPage();
	}
	
	//Action class is used for mouse movement,rightclick,dragand drop etc
	public void clickOndisplayedLinkSelenium()
	{
		Actions action=new Actions(driver);
		action.moveToElement(linkClickLabel).build().perform();
		linkClickLabel.click();
	}
	
	//Action class is used for mouse movement,rightclick,dragand drop etc
	public void clickOndisplayedLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(userLabelForClick).build().perform();
		userLabelForClick.click();
	}

	
	/*
	public void selectFromDropdown(String title)
	{
		//if we need to select any data from dropdown
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		//for clicking on save button
		saveBtn.click();
	}
	
	*/	
		

}
