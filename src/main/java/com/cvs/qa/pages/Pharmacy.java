package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;
import com.sun.corba.se.spi.orbutil.fsm.Action;

public class Pharmacy extends TestBase {

	static Logger log = Logger.getLogger(Pharmacy.class);

	@FindBy(xpath = "//*[@id=\"headCVS\"]/div[3]/div/div[1]/ul/li[1]/a")
	WebElement pharmacyLink;

	@FindBy(xpath = "//a[@id='menu-myrx']")
	WebElement myPrescriptionLink;

	@FindBy(xpath = "//a[@id='pharmacy_rxTransfer']")
	WebElement transferRXtoCVSLink;

	public Pharmacy() {
		PageFactory.initElements(driver, this);
	}

	public void transferPrescription() {
		pharmacyLink.click();
		// driver.findElement(By.xpath("//a[@id='menu-myrx']"));
		Actions act = new Actions(driver);
		act.moveToElement(myPrescriptionLink).build().perform();
		transferRXtoCVSLink.click();

	}
}
