package com.soltechqa.challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Joyeeta Bhattacharyya
 * This class contains test methods for testing open job listings page
 */
public class OpenJobListingsPage {

	private WebDriver driver;
	public static final By FRAME_KEYWORD = By.id("icims_content_iframe");
	public static final By KEYWORD = By.id("jsb_f_keywords_i");
	public static final By SEARCH = By.id("jsb_form_submit_i");
	public static final By QUALITY_AUTOMATION = By.linkText("Quality Assurance Automation Engineer");
	public static final String KEYWORD_TO_SEARCH = "QA";
    
    

	public OpenJobListingsPage(WebDriver driver){
		this.driver = driver;		 
	}
	 
	 /**
	  * This method 
	  * <li>switches the driver to point to the new tab </li> 
	  * <li>finds the search textbox</li>
	  * <li>Sets the search string as QA</li>
	  * <li>Clicks the Search button</li>
	  */
	 public void searchKeyword(){
		 for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
		 }
		 driver.switchTo().frame("icims_content_iframe").findElement(KEYWORD).sendKeys("QA");
	 }
	 
	 /**
	  * This method clicks the search button once the search string is set
	  */
	 public void clickSearch(){
		 driver.findElement(SEARCH).click();
	 }
    
	 /**
	  * This method find the Quality Automation link and clicks on the link
	  */
	 public void clickQualityAutomationEngg(){
		 driver.findElement(QUALITY_AUTOMATION).click();
	 }

}
