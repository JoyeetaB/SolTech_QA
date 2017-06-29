package com.soltechqa.challenge;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * 
 * @author Joyeeta Bhattacharyya
 * 
 * This is the main caller class for testing Soltech Careers Site.
 * There are three tests defined as part of this test class
 * <ul>
 * 	<li>Soltech Landing Page</li>
 * 	<li>Open Job Listings</li>
 * 	<li>Verify Job ID</li>
 * </ul>
 *
 */
public class SoltechQAChallenge {
	
	WebDriver driver;
	public static final String DRIVER_KEY ="webdriver.chrome.driver";
	public static final String DRIVER_PATH ="C:\\gecko\\chromedriver.exe";
	public static final String BASE_URL = "http://soltech.net";
	String expectedJobId = "2017-1958";
	
	
	@BeforeTest
	public void getBaseUrl(){
		System.setProperty(DRIVER_KEY,DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(BASE_URL);	
		driver.manage().window().setSize(new Dimension (1814, 974));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@Test(priority = 0)
	public void clickCareers() throws Exception{
		SoltechNetLandingPage soltechNetLandingPage = new SoltechNetLandingPage(driver);
		soltechNetLandingPage.clickCareers();	
		driver.navigate().refresh();
	}
	
	@Test(priority = 1)
	public void searchQA(){
		OpenJobListingsPage openJobListings = new OpenJobListingsPage(driver);
		openJobListings.searchKeyword();	
		openJobListings.clickSearch();
		openJobListings.clickQualityAutomationEngg();
		
	}
	
	@Test (priority = 2)
	public void verifyJobId(){
		String expectedJobId = "2017-1958";
		JobDetailPage verifyJobId = new JobDetailPage(driver);
		System.out.println("The actual jobid is: " + verifyJobId.getJobId());
		if (expectedJobId.equals(verifyJobId.getJobId())){
			System.out.println("The actual and expected job id's match");
		}
		else {
			System.out.println("The actual jobid: " +  verifyJobId.getJobId() + " and expected jobid: " + expectedJobId + " do not match");
		}
	}
			
	@AfterTest
	public void closeBrowsers(){
		driver.quit();
	}
	
		
}
	


