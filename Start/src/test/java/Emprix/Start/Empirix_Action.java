package Emprix.Start;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Empirix_Action extends Empirix_Base{
	
		public boolean waitFor(int sec, String object) {
			WebDriverWait wait=new WebDriverWait(driver,sec);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((object)))).isDisplayed();
			
			}	
	
	
	
	}	
