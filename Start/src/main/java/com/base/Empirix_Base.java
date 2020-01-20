package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Empirix_Base{
	
	public WebDriver driver;

	
	String projectpath = System.getProperty("user.dir");
	
	@Parameters("BrowserName")
	@BeforeTest
	public void setuptest(String BrowserName)
	{
          System.out.println("Browser Name is:"+ BrowserName);
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			try {
			System.setProperty("webdriver.chrome.driver",projectpath+"/drivers/chromedriver/chromedriver.exe");
			System.out.println("Thread-Number"+Thread.currentThread().getId());
			driver = new ChromeDriver();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception is :- "+e.getMessage());
			}
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			try{
				System.setProperty("webdriver.gecko.driver",projectpath+"/drivers/geckodriver/geckodriver.exe");
				System.out.println("Thread-Number"+Thread.currentThread().getId());
				driver = new FirefoxDriver(); 
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception is :- "+e.getMessage());
			}
		}
		else if(BrowserName.equalsIgnoreCase("ie"))
		{
			try {
			System.setProperty("webdriver.ie.driver",projectpath+"/drivers/iedriver/IEDriverServer.exe");
			System.out.println("Thread-Number"+Thread.currentThread().getId());
			driver = new InternetExplorerDriver();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception is :- "+e.getMessage());
			}
		}}  }


