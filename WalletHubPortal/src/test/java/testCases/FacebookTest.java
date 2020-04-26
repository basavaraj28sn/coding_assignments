package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driverUtils.DriverUtils;
import driverUtils.Log;
import pageObjects.FacebookPageObjects;

public class FacebookTest extends BaseTest {

	FacebookPageObjects fb=null;
	@BeforeClass
	public void setup(){
		driver = DriverUtils.getWebDriver(config.getBrowserType());
		fb = new FacebookPageObjects(driver);
	}
	
	@Test
	public void validateFacebookLogin() throws InterruptedException{
		Log.startReport("validateFacebookLogin");
		
		Log.info("launching application");
		DriverUtils.launchApp(driver, config.getfApplicationUrl());
		
		Log.info("Enter User Name");
		fb.EnterUserName(config.getfusername());
		
		Log.info("Enter Password");
		fb.EnterPwd(config.getfpassword());
		
		Log.info("Click on Login Button Text");
		fb.clickonloginButton();
		
		Log.info("Click on Create Post");
		fb.clickonCreatePost();
		
		Log.info("Click on Enter Post Text");
		fb.WebEleEnterPost("Hello World");
		
		Log.info("Click on Post Button");
		fb.clickonPostButton();
		
		Log.info("Click on profile picture");
		fb.clickonprofile();
		
		Log.info("Verify Hello World text posted on profile");
		String sucess = "Hello World";
		fb.Verifytext(sucess);
	}
}