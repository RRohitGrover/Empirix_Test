package Emprix.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_Report {
	
	private static WebDriver driver = null;
	private static String projectpath = System.getProperty("user.dir");
	
	public static void main(String[] args) throws Exception {
		
		ExtentHtmlReporter  htmlReporter = new ExtentHtmlReporter("extentreport.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Google Search 1", " this is used to google functinality ");
		
        System.setProperty("webdriver.chrome.driver",projectpath+"/drivers/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		test1.log(Status.INFO,"Starting the testcases");
		driver.get("https://www.google.com");
		test1.pass("Navigated to google");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(2000);
		test1.pass("Entered the search text");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		test1.fail("Pressed the enter key");
		
		
		driver.close();
		test1.pass("Browser Closed");
		driver.quit();
		
		test1.info("Test Completed");
		
		extent.flush();
		
		
		
	}
	
	
	
	
	
	

}
