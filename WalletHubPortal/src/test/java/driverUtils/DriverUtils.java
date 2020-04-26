package driverUtils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import driverUtils.Log;
import driverUtils.ConfigFileReader;

public class DriverUtils {
	
	//Configuring web driver and initialize the driver 
	static WebDriver driver;
	static ConfigFileReader config;
	static Log log;
	
	public static WebDriver getWebDriver() {
		config= new ConfigFileReader();
		System.setProperty("webdriver.gecko.driver", config.getDriverPath());
		Log.info("creating webDriver---");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Log.info("returning webdriver to test");
		return driver;
	}

	public static WebDriver getWebDriver(String type) {
		config= new ConfigFileReader();
		Log.info("Creating a Driver with " + type);
		driver = null;
		switch(type) {
		
		case "FF" :
			Log.info("Creating Firefox driver..");
			System.setProperty("webdriver.gecko.driver",config.getDriverPath());
			driver = new FirefoxDriver();
			Log.info("Configuring driver with implicit wait of 30 sec ");
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Log.info("Maximizing the driver/Browser ");
			driver.manage().window().maximize();
			break;
		case "IE" :
			Log.info("Creating IE Driver ...");
			System.setProperty("webdriver.ie.driver", config.getDriverPath());
			driver = new InternetExplorerDriver();
			Log.info("Configuring driver with implicit wait of 30 sec ");
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Log.info("Maximizing the driver/Browser ");
			driver.manage().window().maximize();
			break;
		case "CHROME" :
			Log.info("Creating chrome Driver...");
			System.setProperty("webdriver.chrome.driver", config.getDriverPath());
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver =new ChromeDriver(options);
						
			Log.info("Configuring driver with implicit wait of 30 sec ");
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Log.info("Maximizing the driver/Browser ");
			driver.manage().window().maximize();
			break;
		
			default :
				Log.info("No matching driver available..");
				driver = null;
				}
		return driver;
	}

	public static void launchApp(WebDriver driver , String url) {
		Log.info("Launching the applicaiton ..." + url);
		driver.get(url);
		Log.info("Application Launched Successfully..");
	}

	public static String getMethodName(){
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
	public static void startTest(WebDriver driver){
		Log.startReport(DriverUtils.getMethodName());
		DriverUtils.launchApp(driver,config.getApplicationUrl());
	}
}
