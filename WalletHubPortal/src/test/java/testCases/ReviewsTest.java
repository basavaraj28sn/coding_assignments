package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driverUtils.DriverUtils;
import driverUtils.Log;
import pageObjects.StarRatingPageObjects;

public class ReviewsTest extends BaseTest{
	
	StarRatingPageObjects sr =null;
	@BeforeClass
	public void setup(){
		driver = DriverUtils.getWebDriver(config.getBrowserType());
		sr = new StarRatingPageObjects(driver);
	}
	
	@Test
	public void validateReviews() throws InterruptedException{
		Log.startReport("validateReviews");
		
		Log.info("launching application");
		DriverUtils.launchApp(driver, config.getApplicationsubUrl());
		
		Log.info("Click on Login Link Text");
		sr.clickonloginLink();

		Log.info("Enter User Name");
		sr.EnterUserName(config.getusername());
		
		Log.info("Enter Password");
		sr.EnterPwd(config.getpassword());
		
		Log.info("Click on Login Button Text");
		sr.clickonloginButton();
		
		Log.info("Click on Profile Reviews");
		sr.ClickonProfileReviews();
				
		Log.info("Verify Reviews");
		String sucess = "WalletHub is the first-ever website to offer free credit scores and full credit reports that are updated on a daily basis. But we consider that just an appetizer, as we’ve built the brain of an artifi";
		sr.VerifyReviews(sucess);
	}
}
