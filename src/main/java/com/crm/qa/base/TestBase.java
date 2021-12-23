package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	//create constructor for file location of config.properties
	public TestBase() 
	{
		try {
			prop = new Properties();
			//String path="/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties";
			
			String path="C:/Users/veena_toughta/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties";
			
			System.out.println("in try..." +path);
			
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
			
			System.out.println("after path");
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("2");
			}
	}
	
	//read properties from config.properties file
	public static void initialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/veena_toughta/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			
			//Logger logger= Logger.getLogger("FreeCRMTest");
			//PropertyConfigurator.configure("log4j.properties");
			
			
		}else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/veena_toughta/geckodriver");
			driver = new FirefoxDriver();
		}
		
		
		/*e_driver=new EventFiringWebDriver(driver);
		//create object of eventlistener handler to register it with eventfiringwebdriver
		//for messages in console---selenium action logs
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;*/
			
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//instead of hardcoding timeout and implicit wait we get them from testutil class
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		/*try {
			System.out.println("IN TRY......TESTBASE");
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*DateFormat DF=DateFormat.getDateTimeInstance();
			
		Date dte=new Date();
		String DateValue=DF.format(dte);
		
		System.out.println("DATEVALUE..." +DateValue);
		String dateFormat = "";
		
		SimpleDateFormat dt = new SimpleDateFormat(dateFormat);
		Date dateObj = new Date();
		System.out.println("Today's date and time--->"+dt.format(dateObj));*/
		
		
		driver.get(prop.getProperty("url"));
	}
	
}
