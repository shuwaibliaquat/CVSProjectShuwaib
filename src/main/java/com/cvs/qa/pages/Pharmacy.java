package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class Pharmacy extends TestBase {

	static Logger log = Logger.getLogger(Pharmacy.class);

	@FindBy(xpath = "//a[@title='Pharmacy']")
	WebElement pharmacyLink;

	@FindBy(xpath = "//a[@id='menu-myrx']")
	WebElement myPrescriptionLink;

	@FindBy(xpath = "//a[@id='tt_rxt_button']")
	WebElement transferRXtoCVSLink;

	public Pharmacy() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPharmacyPageTitle() {
		return driver.getTitle();
	}

	public void transferPrescription() {
		pharmacyLink.click();
		// driver.findElement(By.xpath("//a[@id='menu-myrx']"));
		Actions act = new Actions(driver);
		act.moveToElement(myPrescriptionLink).build().perform();
		transferRXtoCVSLink.click();

	}
}
