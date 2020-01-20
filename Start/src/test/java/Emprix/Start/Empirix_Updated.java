package Emprix.Start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Empirix_Base;
import com.util.Parameter;

public class Empirix_Updated extends Empirix_Base{
	public Properties prop;
	//	Empirix_Updated eu = new Empirix_Updated();
	
	@BeforeMethod
	public void readfile()
	{
		System.out.println("Before Method");
		try {
			prop = new Properties();
			String Path_xpath="xpath.properties";
			FileInputStream fs=new FileInputStream(Path_xpath);
			prop.load(fs);
//			System.out.println(prop.getProperty("title"));
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	public void waitFor(int sec, String object) {
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(object)))).isDisplayed();
	}
	
/*	public void Element(String object)
	{
		SoftAssert sa1 = new SoftAssert();
		try
		{
			driver.findElement(By.xpath(prop.getProperty(object))).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			sa1.fail();
//			Assert.fail();
		}
		
	}*/

	@Test(priority=1)
	public void launch()
	{
		try
		{
			System.out.println("In launch method");
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			waitFor(20, "title");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception is :- "+e.getMessage());
			Assert.fail();
		}
	}
	@Test(priority=2)
	public void login() throws Exception
	{
		try {
		     System.out.println("In login Method");
		     driver.findElement(By.xpath(prop.getProperty("usernamefield"))).sendKeys("QA_traininguser8");
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("passwordfield"))).sendKeys("Empirix!");
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("login"))).click();
			waitFor(30, "message");
			System.out.println("logion to Empirix done successfully");
			Thread.sleep(2000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception is :- "+e.getMessage());
			Assert.fail("Login is unsuccessful");
		}
		
	}
	@Test(priority=3)
	public void Select_English_language() throws Exception
	{boolean jap=true;
		SoftAssert sa = new SoftAssert();
		try {
			driver.findElement(By.xpath(prop.getProperty("message"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("dropdown"))).click();
			Thread.sleep(6000);
		    jap=driver.findElement(By.xpath(prop.getProperty("jap_link"))).isDisplayed();
		 System.out.println("Website language is English");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception is :- "+e.getMessage());	
			sa.assertEquals(jap, true);
		}

		try {
		   boolean eng=driver.findElement(By.xpath(prop.getProperty("eng_link"))).isDisplayed();
		   System.out.println("Website language is Japanese");
			driver.findElement(By.xpath(prop.getProperty("eng_link"))).click();
			driver.switchTo().alert().accept();
			Thread.sleep(6000);
			System.out.println("English language selected sucessfully");
		   }
		  catch(Exception e)
		  {
			  e.printStackTrace();
				System.out.println("Exception is :- "+e.getMessage()); 
		  }
		  
		}
	@Test(priority=4)
	public void tabs()
	{   
		try
		{
//			Element("dashboard");Element("alerts");Element("tests");Element("variables1");Element("notifi");
			waitFor(10,"dashboard");
//		    driver.findElement(By.xpath(prop.getProperty("dashboard"))).isDisplayed();
        	driver.findElement(By.xpath(prop.getProperty("alerts"))).isDisplayed();
        	driver.findElement(By.xpath(prop.getProperty("tests"))).isDisplayed();
        	driver.findElement(By.xpath(prop.getProperty("variables"))).isDisplayed();
        	driver.findElement(By.xpath(prop.getProperty("notifi"))).isDisplayed();
        	System.out.println("Dashboard, Alerts, Tests, Variable and Notification tabs are present in English locale");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}	
		@Test(priority=5)
		public void information()
		{
			try
			{ 
				Thread.sleep(2000);
				driver.findElement(By.xpath(prop.getProperty("alerts"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(prop.getProperty("dropdown"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(prop.getProperty("client"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(prop.getProperty("clientname"))).isDisplayed();
				driver.findElement(By.xpath(prop.getProperty("description"))).isDisplayed();
				driver.findElement(By.xpath(prop.getProperty("subsstartdate"))).isDisplayed();
				driver.findElement(By.xpath(prop.getProperty("subsenddate"))).isDisplayed();
				driver.findElement(By.xpath(prop.getProperty("load"))).isDisplayed();
				driver.findElement(By.xpath(prop.getProperty("voice"))).isDisplayed();
				driver.findElement(By.xpath(prop.getProperty("scanarios"))).isDisplayed();
				driver.findElement(By.xpath(prop.getProperty("schedule"))).isDisplayed();
				Thread.sleep(5000);
			}
			catch(Exception e)
			   {
				e.printStackTrace();
				Assert.fail();
				} }
			@Test(priority=6)
			public void Select_Japense_language()
			{

				try
				{
					driver.findElement(By.xpath(prop.getProperty("dropdown"))).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//a[contains(text(),'Japanese')]")).click();
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
					Thread.sleep(8000);
					System.out.println("Japaense language selected on webpage");
//					waitFor(10, "japalert");
					driver.findElement(By.xpath(prop.getProperty("japalert"))).click();
					Thread.sleep(5000);
				}
				catch(Exception e)
				   {
					e.printStackTrace();
					Assert.fail();
					}
			}
			@Test(priority=6)
			public void logout()
			{
				try
				{
					driver.findElement(By.xpath(prop.getProperty("dropdown"))).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath(prop.getProperty("japlogout"))).click();
				}
				catch(Exception e)
				   {
					e.printStackTrace();
					Assert.fail();
					}
			}
	
//        @AfterTest
//        public void teardown()
//        {
//        	driver.close();
//        }
        }

	/*@AfterMethod
	public void closebroswer() throws Exception{
		driver.findElement(By.xpath(prop.getProperty("dropdown"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("logoutbutton"))).click();
		System.out.println("In After Method");
		//		driver.close();
		try {
			System.out.println(driver.getTitle());
			if (driver!= null) 
			{
				driver.close();
				driver = null;
			}
			System.out.println("Successfully closed Browser");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to close browser");

		}}

*/
	

