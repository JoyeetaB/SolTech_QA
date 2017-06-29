package com.soltechqa.challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Joyeeta Bhattacharyya
 * This class contains the test method for Job description page
 */
public class JobDetailPage {
	
	private WebDriver driver;	
	public static final By jobId = By.className("iCIMS_JobHeaderData");
    
    
	public JobDetailPage(WebDriver driver){
		 this.driver = driver;		 
	}
	
	/**
	 * This method finds the Job ID and fetches the ID
	 * @return
	 */
	public String getJobId(){
		driver.findElement(jobId).getText();
		String actualJobId = (String)driver.findElement(jobId).getText();
		return actualJobId;		
	}
	
}
