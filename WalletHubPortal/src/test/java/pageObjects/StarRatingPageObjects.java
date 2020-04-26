package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverUtils.Log;
import testCases.BaseTest;

public class StarRatingPageObjects extends BaseTest{
	
	@FindBy(xpath="//span[@class='brgm-button brgm-signup']")
	private WebElement WebEleloginLink;
	
	public void clickonloginLink(){
		WebEleloginLink.click();
	}
	
	@FindBy(name="em")
	private WebElement WebEleUserName;
	
	public void EnterUserName(String UserName){		
		WebEleUserName.sendKeys(UserName);
	}
	
	@FindBy(name="pw")
	private WebElement WebElePwd;
	
	public void EnterPwd(String Password){		
		WebElePwd.sendKeys(Password);
	}
	
	@FindBy(xpath="//button/span")
	private WebElement WebEleloginButton;
	
	public void clickonloginButton() throws InterruptedException{
		WebEleloginButton.click();
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//review-star[@class='rvs-svg']")
	private WebElement WebEleCheck;
	
	public void CheckElementDisplyaed() {
		boolean Status = WebEleCheck.isDisplayed();
		Log.info("Check Element Displayed"+ Status);
	}
	
	@FindBy(xpath = "//review-star[@class='rvs-svg']")
	private WebElement WebEleStars;
	
	public void MoveMouseClick() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(WebEleStars,60,0).perform();
	}
		
	@FindBy(xpath = "//review-star[@class='rvs-svg']//*[@class='rvs-star-svg'][5]")
	private WebElement WebEle5thStart;
	
	public void Clickon5thStart() throws InterruptedException {
		WebEle5thStart.click();
		Thread.sleep(4000);
	}
	
	@FindBy(xpath = "//ng-dropdown[@class='wrev-drp']")
	private WebElement WebEleDropDownlist;
	
	public void ClickonDropDownlist() {
		WebEleDropDownlist.click();
	}
	
	@FindBy(xpath = "//ul[@class='dropdown-list ng-enter-element']//li[text()='Health Insurance']")
	private WebElement WebEleSelectValue;
	
	public void ClickonValue() {
		WebEleSelectValue.click();
	}
	
	@FindBy(xpath = "//div/textarea[@class='textarea wrev-user-input validate']")
	private WebElement WebEleaddReviews;
	
	public void EnterReviews(String Reviews){		
		WebEleaddReviews.sendKeys(Reviews);
	}
	
	@FindBy(xpath = "//div[text()='Submit']")
	private WebElement WebEleSubmit;
	
	public void ClickonSubmit() {
		WebEleSubmit.click();
	}
	
	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement WebEleContinue;
	
	public void ClickonContinue() {
		WebEleContinue.click();
	}

	@FindBy(xpath="//a[text()='Test Insurance Company']")
	private WebElement WebEleprofileReviews;
	
	public void ClickonProfileReviews() {
		WebEleprofileReviews.click();
	}
	
	@FindBy(xpath="//div[text()='WalletHub is the first-ever website to offer free credit scores and full credit reports that are updated on a daily basis. But we consider that just an appetizer, as we’ve built the brain of an artifi']")
	private WebElement WebEleVerifyReviews;
	
	public void VerifyReviews(String sucess) {
	if (WebEleVerifyReviews.getText().equals(sucess))
		{System.out.println("Sucess");}
	else
		{System.out.println("Fail");}	
	}
	
	public StarRatingPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
		
}
