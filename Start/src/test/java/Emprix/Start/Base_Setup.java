package Emprix.Start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base_Setup {

	WebDriver driver=null;
	String projectpath = System.getProperty("user.dir");
	
	@Parameters("BrowserName")
	@BeforeTest
	public void setup(String BrowserName)
	{
		System.out.println("Browser Name is:"+ BrowserName);
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",projectpath+"/drivers/chromedriver/chromedriver.exe");
			System.out.println("Thread-Number"+Thread.currentThread().getId());
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",projectpath+"/drivers/geckodriver/geckodriver.exe");
			System.out.println("Thread-Number"+Thread.currentThread().getId());
			driver = new FirefoxDriver();
//			int i=1; int k=i/0;
		}
		else if(BrowserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",projectpath+"/drivers/iedriver/IEDriverServer.exe");
			System.out.println("Thread-Number"+Thread.currentThread().getId());
			driver = new InternetExplorerDriver();
		}}
}
