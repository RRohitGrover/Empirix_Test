package Emprix.Start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login{
	
WebDriver driver=null;	
	@Test
	public void login() throws Exception
	{
//		System.out.println("First Thread | "+Thread.currentThread().getId());	
		System.setProperty("webdriver.chrome.driver","D:\\code\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void login1() throws Exception
	{
//		System.out.println("Second Thread | "+Thread.currentThread().getId());		
		System.setProperty("webdriver.chrome.driver","D:\\code\\IEdriver\\IEDriverServer.exe");
//		driver = initIEDriver();
		driver.get("https://www.gmail.com/");
		Thread.sleep(3000);
		driver.close();
	}
	
	

}

