package com.soltechqa.challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author Joyeeta Bhattacharyya
 * This class contains test methods to test the soltech landing page
 *
 */
public class SoltechNetLandingPage {
	private WebDriver driver;	
	public static final By OPEN_POSITIONS = By.xpath("//*[@id=\"navbar\"]/div/ul/li[5]/ul/li[2]/a");

	public SoltechNetLandingPage(WebDriver driver){
		 this.driver = driver;		 
	}
	 
	/**
	 * This method finds the careers link and clicks on the open positions menu item
	 */
	public void clickCareers() throws Exception{
		 WebElement careers = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/ul/li[5]/a"));
		 Actions builder = new Actions(driver);
	     Action mouseOverCareers = builder.moveToElement(careers).build();
	     mouseOverCareers.perform();
	     Thread.sleep(5000);
		 driver.findElement(OPEN_POSITIONS).click();
	}
	 
}
 
