package com.cvs.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class ClinicLocatorTest extends TestBase {

	static Logger log = Logger.getLogger(ClinicLocatorTest.class);

	@FindBy(xpath = "//label[.='Only show clinics that accept my insurance. ']")
	WebElement clinicLocaterInsurancheckBox;

	public ClinicLocatorTest() {
		PageFactory.initElements(driver, this);
	}

	public String verifyClinicLocatorPageTitle() {
		return driver.getTitle();
	}

	public void verifyChkBox() {
		clinicLocaterInsurancheckBox.click();
	}

}