package Emprix.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;
//import com.relevantcodes.extentreports.LogStatus;

public class Empirix_Test extends Empirix_Base {
	
	Empirix_Action ea = new Empirix_Action();
	SoftAssert sa= new SoftAssert();
	boolean a,b,c,d;
	
	@Parameters("url")
	@Test
	public void login(String url) throws Exception
	{
//      try {
    	    driver.get(url);
    	    String title=driver.getTitle();
    	    driver.manage().window().maximize();
    	    System.out.println(title);
//    	    Thread.sleep(20000);
    	    
    	    WebDriverWait wait = new WebDriverWait(driver, 30);
  
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Empirix, Inc.']")));
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("QA_traininguser8");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Empirix!");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Got')]")));
            Thread.sleep(2000);
          driver.findElement(By.xpath("//*[contains(text(),'Got')]")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//a[contains(text(),'QA_traininguser8')]")).click();
          Thread.sleep(2000);
         System.out.println("Test-strt");
         
         try {
         a=  driver.findElement(By.xpath("//div[contains(text(),'English')]")).isDisplayed();
        System.out.println(a);
        b= driver.findElement(By.xpath("//a[contains(text(),'Japanese')]")).isDisplayed();
        System.out.println(b);}
         catch(Exception e)
         {
        	 e.printStackTrace();
 			sa.assertAll();
         }
       
         try{
        	 c =  driver.findElement(By.xpath("//a[contains(text(),'English')]")).isDisplayed();
        System.out.println(c);
        d = driver.findElement(By.xpath("//div[contains(text(),'Japanese')]")).isDisplayed();
        System.out.println(d);}
         
         catch(Exception e)
         {
        	 e.printStackTrace();
  			sa.assertAll();
         }
        
        if(a&&b)
        {
        	System.out.println("Page is in English language");
        	
        	driver.findElement(By.xpath("//a[@href='/dashboard' and contains(text(),'Dashboard')]")).isDisplayed();
        	System.out.println("Dashboard-Displayed");
        	driver.findElement(By.xpath("//a[@href='/alerts' and contains(text(),'Alerts')]")).isDisplayed();
        	driver.findElement(By.xpath("//a[@href='/tests' and contains(text(),'Tests')]")).isDisplayed();
        	driver.findElement(By.xpath("//a[@href='/variables' and contains(text(),'Variables')]")).isDisplayed();
        	System.out.println("Variable-Displayed");
        	driver.findElement(By.xpath("//a[@href='/notifi' and contains(text(),'Notifications')]")).isDisplayed();
        	System.out.println("Dashboard, Alerts, Tests, Variable and Notification tabs are present in English locale");
        	driver.findElement(By.xpath("//a[contains(text(),'Japanese')]")).click();
        	driver.switchTo().alert().accept();
            Thread.sleep(2000);    	
        }
        else if(c&&d)
          {
          	System.out.println("Page is in Japanese language");
          	Thread.sleep(1000);
          String Dash=driver.findElement(By.xpath("//a[@href='/dashboard' and contains(text(),'ダッシュボード')]")).getText();
          String Alerts=driver.findElement(By.xpath("//a[@href='/alerts' and contains(text(),'アラート')]")).getText();
          String Tests=driver.findElement(By.xpath("//a[@href='/tests' and contains(text(),'テスト')]")).getText();
          String Variable=driver.findElement(By.xpath("//a[@href='/variables' and contains(text(),'変数')]")).getText();
          String Notifi=	driver.findElement(By.xpath("//a[@href='/notifi' and contains(text(),'通知)]")).getText();
          System.out.println("Dashboard, Alerts, Tests, Variable and Notification tabs are present in Japanese locale"+
              Dash+","+Alerts+","+Tests+","+Variable+","+Notifi);
          	driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
          	driver.switchTo().alert().accept();
            Thread.sleep(2000);
          }
     
        driver.findElement(By.xpath("//a[contains(text(),'QA_traininguser8')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
      	driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'QA_traininguser8')]")).click();
        driver.findElement(By.xpath("//a[@href=\"/client\"]//*[contains(text(),'Client')]")).click();
        
       
          driver.findElement(By.xpath("//*[text()='Empirix_QA_Training']"));        
    
//          driver.findElement(By.xpath("//a[contains(text(),'QA_traininguser8')]")).click();
//          Thread.sleep(2000);
//          driver.findElement(By.xpath("//*[contains(text(),'English')]")).click();
//          Thread.sleep(2000);
//    	    String element="//*[@title='Empirix, Inc.']";
//    	    ea.waitFor(20,element);
//    	    WebDriverWait wait = new WebDriverWait(driver, 20);
//    	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='dls-sh-loader-zone']")));
//    	    driver.findElement(By.xpath("//*[@title='Empirix, Inc.']"));
    	    System.out.println("Navigating to "+url);
    	    
    	    //a[@href='/dashboard' and contains(text(),'Dashboard')]
    	    
//		catch(Exception e) {
//			//write code for reporter class
//			e.printStackTrace();
//			Assert.fail();}
			
		
	// username = //div[@class='group-field-block']//input[@type='text']
      // password= //div[@class='group-field-block']//input[@type='password']
//		Thread.sleep(2000);
//		driver.findElement(By.name("q")).sendKeys("Automation");	
//		Thread.sleep(3000);
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
//		Thread.sleep(3000);
	}
	@AfterTest
	public void teardowntest()
	{
//		driver.close();	
		
	}

}
