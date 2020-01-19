package Emprix.Start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Emprix_Login extends Base_Setup{
	
		
	@Test
	public void login() throws Exception
	{
	driver.get("https://www.google.com");	
	Thread.sleep(3000);
	}

	
	@AfterClass
	public void teardown()
	{
		driver.close();
		System.out.println("Test Completed Successfully");
		
	}

}
