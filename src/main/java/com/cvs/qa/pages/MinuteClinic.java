package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class MinuteClinic extends TestBase {

	static Logger log = Logger.getLogger(MinuteClinic.class);

	@FindBy(xpath = "//a[@title='MinuteClinic']")
	WebElement minuteClinicLink;

	@FindBy(xpath = "//input[@id='zip']")
	WebElement minuteClinicZipCodeLocator;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnVisitToday;

	public MinuteClinic() {
		PageFactory.initElements(driver, this);
	}

	public String verifyMinuteClinicPageTitle() {
		minuteClinicLink.click();
		return driver.getTitle();
	}

	public void verifyZipCodeLocater(String zipCode) {
		minuteClinicLink.click();
		minuteClinicZipCodeLocator.sendKeys(zipCode);

	}

	public void clickBtnVisitToday() {
		btnVisitToday.click();

	}
}
