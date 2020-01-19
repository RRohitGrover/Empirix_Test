package Emprix.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_Report_TestNg {
	ExtentHtmlReporter extenthtml;
	ExtentReports extent;
	private static WebDriver driver = null;
	private static String projectpath = System.getProperty("user.dir");
	ExtentTest test1;
	
	@BeforeSuite
	public void seup()
	{
		extenthtml= new ExtentHtmlReporter("extentreport.html");
		extent= new ExtentReports();
		extent.attachReporter(extenthtml);
	}
	
	@BeforeTest
	public void setuptest()
	{
		  System.setProperty("webdriver.chrome.driver",projectpath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
	}	
	@Test
	public void login() throws Exception
	{
		test1 = extent.createTest("Google Search 1", " this is used to test google search functionality ");
		test1.log(Status.INFO,"Starting the testcases");
		driver.get("https://www.google.com");
		test1.pass("Navigated to google");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(2000);
		test1.pass("Entered the search text");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		test1.pass("Pressed the enter key");
		
		
	}


	@AfterTest
	public void teardowntest()
	{
		driver.close();	
		test1.pass("Browser Closed");
		test1.info("Test Completed");
	}
	
	@AfterSuite
	public void teardown()
	{
	    extent.flush();
	}
	
	
}
