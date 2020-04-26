package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPageObjects {
	
	@FindBy(xpath ="//input[@name='email']")
	private WebElement WebEleemailtextfield;
	
	@FindBy(xpath ="//input[@name='pass']")
	private WebElement WebElepasswordtextfield;
	
	@FindBy(xpath ="//label[@id='loginbutton']")
	private WebElement WebEleloginButton;
	
	@FindBy(xpath="//span[text()='Create Post']")
	private WebElement WebEleCreatePost;
				
	@FindBy(xpath="//div[@role='textbox']")
	private WebElement WebEleEnterPost;
	
	@FindBy(xpath="//span[text()='Post']")
	private WebElement WebElePost;
	
	public void EnterUserName(String UserName){		
		WebEleemailtextfield.sendKeys(UserName);
	}
	public void EnterPwd(String Password){		
		WebElepasswordtextfield.sendKeys(Password);
	}
	public void clickonloginButton(){
		WebEleloginButton.click();
	}
	public void clickonCreatePost(){
		WebEleCreatePost.click();
	}
	public void WebEleEnterPost(String posttext){
		WebEleEnterPost.sendKeys(posttext);
	}
	public void clickonPostButton() throws InterruptedException{
		WebElePost.click();
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//div[@data-click='profile_icon']")
	private WebElement WebEleprofile;

	@FindBy(xpath="//div/p[text()='Hello World']")
	private WebElement WebEleHello;
	public void clickonprofile(){
		WebEleprofile.click();
	}
	
	public void Verifytext(String sucess) {
		if (WebEleHello.getText().equals(sucess))
			{System.out.println("Sucess");}
		else
			{System.out.println("Fail");}	
		}

	public FacebookPageObjects(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
}
