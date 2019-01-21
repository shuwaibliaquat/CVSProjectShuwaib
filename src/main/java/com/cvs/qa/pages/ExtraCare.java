package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class ExtraCare extends TestBase {

	static Logger log = Logger.getLogger(ExtraCare.class);

	@FindBy(xpath = "//a[@title='ExtraCare']")
	WebElement extraCareLink;

	@FindBy(xpath = "//button[@value='Sign in']")
	WebElement extraCareSignIn;

	@FindBy(xpath = "//input[@id='email']")
	WebElement extraCareSignInEmailAddress;

	@FindBy(xpath = "//button[@role='status']")
	WebElement extraCareSignInContinueBtn;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement extraCareSignInPwd;
	
	@FindBy(css = ".twoStep-create-account")
	WebElement extraCareSignInSubmitBtn;

	@FindBy(xpath="//li//p[text()=\"Welcome abdur!\"]")
	WebElement signInLabel;
	
	@FindBy(xpath = "//*[@id=\"basket\"]")
	WebElement extraCareShoppingCart;

	public ExtraCare() {
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
		extraCareSignInEmailAddress.sendKeys(extraCareUserName);
		extraCareSignInContinueBtn.click();
		extraCareSignInPwd.sendKeys(ExtraCarePwd);
		extraCareSignInSubmitBtn.click();
		
	}

	public String verifyExtraCareSignInName() {
		//signInLabel.isDisplayed();
		return signInLabel.getText();
	}
	
	public void verifyExtraCareShoppingCart() {
		extraCareShoppingCart.click();
	}
}
