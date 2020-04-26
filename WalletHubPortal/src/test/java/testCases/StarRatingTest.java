package testCases;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driverUtils.DriverUtils;
import driverUtils.Log;
import pageObjects.StarRatingPageObjects;

public class StarRatingTest extends BaseTest{

	StarRatingPageObjects sr =null;
	@BeforeClass
	public void setup(){
		driver = DriverUtils.getWebDriver(config.getBrowserType());
		sr = new StarRatingPageObjects(driver);
	}
	
	@Test
	public void validateLogin_StarRating() throws InterruptedException{
		Log.startReport("validateUserLogin");
		
		Log.info("launching application");
		DriverUtils.launchApp(driver, config.getApplicationUrl());
		
		Log.info("Click on Login Link Text");
		sr.clickonloginLink();

		Log.info("Enter User Name");
		sr.EnterUserName(config.getusername());
		
		Log.info("Enter Password");
		sr.EnterPwd(config.getpassword());
		
		Log.info("Click on Login Button Text");
		sr.clickonloginButton();
		
		Log.info("Click To Scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Log.info("Verfiy Element Displayed");
		sr.CheckElementDisplyaed();
		
		Log.info("Move on to 4TH Star");
		sr.MoveMouseClick();
		
		Log.info("Click on to 5TH Star");
		sr.Clickon5thStart();
		
		Log.info("Click on DropDownlist");
		sr.ClickonDropDownlist();
		
		Log.info("Select Health Insurance");
		sr.ClickonValue();
		
		Log.info("Enter Review Comments");
		String sucess = "WalletHub is the first-ever website to offer free credit scores and full credit reports that are updated on a daily basis. But we consider that just an appetizer, as we’ve built the brain of an artifi";
		sr.EnterReviews(sucess);
		
		Log.info("Click on Submit Button");
		sr.ClickonSubmit();
		
		Log.info("Click on Continue Button");
		sr.ClickonContinue();
	}
	
}
