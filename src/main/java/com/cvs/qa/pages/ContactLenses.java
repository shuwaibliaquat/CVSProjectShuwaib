package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cvs.qa.testbase.TestBase;

public class ContactLenses extends TestBase {
	static Logger log = Logger.getLogger(ContactLenses.class);

	@FindBy(xpath = "//*[@id='brand-option']")
	WebElement lensBrandDropDownLink;

	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE DEFINE 30 Pack')]")
	WebElement acuvueDefine30Pack;

	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE DEFINE 90 Pack')]")
	WebElement acuvueDefine90Pack;

	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE MOIST 30 Pack')]")
	WebElement acuvueMOIST30Pack;

	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE MOIST 90 Pack')]")
	WebElement acuvueMOIST90Pack;

	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE MOIST for ASTIGMATISM 30 Pack')]")
	WebElement acuvueASTIGMATISM30Pack;

	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE MOIST for ASTIGMATISM 90 Pack')]")
	WebElement acuvueASTIGMATISM90Pack;
	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE MOIST Multifocal 30 Pack')]")
	WebElement acuvueMultifocal30Pack;

	@FindBy(xpath = "//*[contains(text(),'1-DAY ACUVUE MOIST Multifocal 90 Pack')]")
	WebElement acuvueMultifocal90Pack;

	@FindBy(xpath = "//a[@id='brand-air-optix-option']")
	WebElement airOptixBrand;

	@FindBy(xpath = "//*[@id=\"air-optix-links\"]/a[1]")
	WebElement airOptixAquaPack;

	@FindBy(xpath = "//div[@id='air-optix-links']/a[@href='/Lens/329']")
	WebElement airOptixAquaMultifocalPack;

	@FindBy(xpath = "//*[@id=\"type-option\"]")
	WebElement lensTypeDropDownLink;

	@FindBy(xpath = "//*[@id='type-dropdown']/div/a[1]")
	WebElement dailyDisposables;

	@FindBy(xpath = "//*[@id='type-dropdown']/div/a[4]")
	WebElement coloredContacts;

	public ContactLenses() {
		PageFactory.initElements(driver, this);
	}

	public String verifyContactLensesPageTitle() {
		return driver.getTitle();
	}

	public void verifyDropDownLensBrands() {
		lensBrandDropDownLink.click();
	}

	public void verifyAcuvueLenseBrand(String acuvueBrandType) {
		if (acuvueBrandType == "1-DAY ACUVUE DEFINE 30 Pack") {
			acuvueDefine30Pack.click();
		} else if (acuvueBrandType == "1-DAY ACUVUE DEFINE 90 Pack") {
			acuvueDefine90Pack.click();
		} else if (acuvueBrandType == "1-DAY ACUVUE MOIST 30 Pack") {
			acuvueMOIST30Pack.click();
		} else if (acuvueBrandType == "1-DAY ACUVUE MOIST 90 Pack") {
			acuvueMOIST90Pack.click();
		} else if (acuvueBrandType == "1-DAY ACUVUE MOIST for  30 Pack") {
			acuvueASTIGMATISM30Pack.click();
		} else if (acuvueBrandType == "1-DAY ACUVUE MOIST for ASTIGMATISM 90 Pack") {
			acuvueASTIGMATISM90Pack.click();
		} else if (acuvueBrandType == "1-DAY ACUVUE MOIST Multifocal 30 Pack") {
			acuvueMultifocal30Pack.click();
		} else if (acuvueBrandType == "1-DAY ACUVUE MOIST Multifocal 90 Pack") {
			acuvueMultifocal90Pack.click();
		} else {
			System.out.println("Wrong Brand inserted");
		}
	}

	public void verifyAirOptixBrand() {
		airOptixBrand.click();
	}

	public void verifyAirOptixBrandMouseHover() {
		Actions actions = new Actions(driver);
		actions.moveToElement(airOptixBrand).build().perform();
	}

	public void verifyAirOptixBrandElement(String airOptixBrandType) {
		Actions actions = new Actions(driver);
		actions.moveToElement(airOptixBrand).build().perform();

		if (airOptixBrandType == "AIR OPTIX AQUA") {
			Actions actions1 = new Actions(driver);
			actions.moveToElement(airOptixBrand).build().perform();
			airOptixAquaPack.click();
		} else if (airOptixBrandType == "AIR OPTIX AQUA Multifocal") {
			Actions actions2 = new Actions(driver);
			actions.moveToElement(airOptixBrand).build().perform();
			airOptixAquaMultifocalPack.click();
		} else {
			System.out.println("Enter correct lens brand or check your spelling");
		}
	}

	public void verifyLensType(String lensType) {
		lensTypeDropDownLink.click();

		if (lensType == "Daily Disposables") {
			dailyDisposables.click();
		} else if (lensType == "Colored Contacts") {
			coloredContacts.click();
		} else {
			System.out.println("Enter correct contact lens type or check your spelling");
		}
	}
}
