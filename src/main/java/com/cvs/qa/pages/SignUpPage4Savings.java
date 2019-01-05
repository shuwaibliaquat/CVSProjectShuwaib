package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

import sun.util.logging.resources.logging;

public class SignUpPage4Savings extends TestBase {

	static Logger log = Logger.getLogger(SignUpPage4Savings.class);

	@FindBy(css ="[class='caret-white-hlightgray-14 fontsize14']")
	WebElement signUpLinkHomePage;
	
	@FindBy(xpath = "//*[contains(text(),'Sign up for email')]")
	WebElement signUpDealsLink;

	@FindBy(xpath = "//input[@name='EMAILADDRESS_']")
	WebElement signUpEmailAddress;

	@FindBy(xpath = "//input[@name='REENTER_EMAILADDRESS_']")
	WebElement signUpReEnterEmailAddress;

	@FindBy(xpath = "//input[@name='XTRACARDNBR']")
	WebElement signUpXtraCardNum;

	@FindBy(xpath = "//input[@name='FIRST_NAME']")
	WebElement signUpFName;

	@FindBy(xpath = "//input[@name='LAST_NAME']")
	WebElement signUpLName;

	@FindBy(xpath = "//input[@name='POSTAL_CODE_1']")
	WebElement signUpZipCode;

	@FindBy(xpath = "//input[@name='BIRTHDATE']")
	WebElement signUpDOB;

	@FindBy(xpath = "//label[@class='mail-disc']")
	WebElement signUpCheckBox;

	@FindBy(xpath = "//input[@name='POSTAL_STREET_1_']")
	WebElement signUpPostalAddress1;

	@FindBy(xpath = "//input[@name='POSTAL_STREET_2_']")
	WebElement signUpPostalAddress2;

	@FindBy(xpath = "//input[@name='CITY_']")
	WebElement signUpCity;

	@FindBy(xpath = "//input[@name='STATE_']")
	WebElement signUpState;

	@FindBy(xpath = "//input[@name='POSTAL_CODE_']")
	WebElement signUpZipCode2;

	@FindBy(xpath = "//input[@name='Submit']")
	WebElement signUpSubmitBtn;

	public SignUpPage4Savings() {
		PageFactory.initElements(driver, this);
	}

	public String verifySignUpDealpageTitle() {
		log.info("Verifying Title of the signup webpage");
		signUpLinkHomePage.click();
		signUpDealsLink.click();
		return driver.getTitle();
	}

	public void verifySignUp(String emailAddress, String reEnterEmailAddress, String ExtraCareNum, String FirstName,
			String LastName, String zipCode, String DOB, String addLine1, String addLine2, String city, String state,
			String zipCode2) throws Exception {

		log.info("Verifying signup steps in signup webpage");

		signUpLinkHomePage.click();
		signUpDealsLink.click();
		Thread.sleep(2000);
		signUpEmailAddress.sendKeys(emailAddress);
		signUpReEnterEmailAddress.sendKeys(reEnterEmailAddress);
		signUpXtraCardNum.sendKeys(ExtraCareNum);
		signUpFName.sendKeys(FirstName);
		signUpLName.sendKeys(LastName);
		signUpZipCode.sendKeys(zipCode);
		signUpDOB.sendKeys(DOB);
		signUpCheckBox.isSelected();

		signUpPostalAddress1.sendKeys(addLine1);
		signUpPostalAddress2.sendKeys(addLine2);
		signUpCity.sendKeys(city);
		signUpState.sendKeys(state);
		signUpZipCode2.sendKeys(zipCode2);
		signUpSubmitBtn.click();
	}

}
