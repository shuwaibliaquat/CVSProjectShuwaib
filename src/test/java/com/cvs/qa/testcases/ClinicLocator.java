package com.cvs.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class ClinicLocator extends TestBase{
	
	static Logger log = Logger.getLogger(ClinicLocator.class);
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div/div/div/div/div[1]/fieldset/label" )
	WebElement clinicLocaterInsurancheckBox;
	
	public ClinicLocator() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyClinicLocatorPageTitle() {
		return driver.getTitle();
	}
	
	public void verifyChkBox() {
		clinicLocaterInsurancheckBox.click();
	}
	
}