package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class ExtraCare extends TestBase{
	
	static Logger log = Logger.getLogger(ExtraCare.class);	
	
	@FindBy(xpath="//navigation//div//div//li//a[contains(text(),'ExtraCare')]")
	WebElement extraCareLink;
	
	@FindBy(xpath="//button[@value='Sign in']")
	WebElement extraCareSignIn;
	
	@FindBy(xpath="//input[@id='loginPopup']")
	WebElement extraCareSignInUserName;
	
	@FindBy(xpath="//input[@id='passwordPopup']")
	WebElement extraCareSignInPwd;
	
	@FindBy(xpath="//button[@id='create']")
	WebElement extraCareSignInSubmitBtn;
	
	@FindBy(xpath="//*[@id=\"basket\"]")
	WebElement extraCareShoppingCart;
	
	public ExtraCare(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyExtraCarePageTitle() {
		return driver.getTitle();
	}
	public void verifyExtraCareLink() {
		extraCareLink.click();
	}
	public void verifyExtraCareSignIn(String extraCareUserName, String ExtraCarePwd) throws Exception {
		extraCareSignIn.click();
		Thread.sleep(2000);
		extraCareSignInUserName.sendKeys(extraCareUserName);	
		extraCareSignInPwd.sendKeys(ExtraCarePwd);
		extraCareSignInSubmitBtn.click();
	}
	
	public void verifyExtraCareShoppingCart() {
		extraCareShoppingCart.click();
	}
}
