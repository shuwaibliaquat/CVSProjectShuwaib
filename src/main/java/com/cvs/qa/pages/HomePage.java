package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class HomePage extends TestBase {

	static Logger log = Logger.getLogger(HomePage.class);

	// Page Object Repository

	@FindBy(linkText = "CVS pharmacy™ homepage")
	WebElement homePageLogo; //CVS HomePage logo

	@FindBy(css = ".main-nav li:nth-of-type(1) [target]")
	WebElement pharmacyLink; //Pharmacy Link Tab

	@FindBy(css = ".main-nav li:nth-of-type(2) [target]")
	WebElement minuteClinicLink; //minuteClinicLink Link Tab

	@FindBy(css = ".main-nav li:nth-of-type(3) [target]")
	WebElement shopLink; //shopLink Link Tab

	@FindBy(css = ".main-nav li:nth-of-type(4) [target]")
	WebElement extraCareLink; //extraCareLink Link Tab

	@FindBy(css = ".main-nav li:nth-of-type(5) [target]")
	WebElement contactLensesLink; //contactLensesLink Link Tab

	@FindBy(css = ".main-nav li:nth-of-type(6) [target]")
	WebElement photoLink; //photoLink Link Tab

	@FindBy(xpath = "//input[@id='searchbox']")
	WebElement searchBox; //searchBox for searching in cvs.com

	@FindBy(css = "#mobile-off__base")
	WebElement searchBoxBtn; //button to click item from search box

	@FindBy(css = ".head-c1-links-right .head-links:nth-of-type(1)")
	WebElement storeLocatorLink; //storeLocatorLink to locate store nearby

	@FindBy(xpath = "//input[@id='search']")
	WebElement storeLocatorSearchBox; //SearchBox to locate store in store locator page

	@FindBy(xpath = "//input[@id='srchstorebtn']")
	WebElement storeLocatorSearchBtn; //storeLocatorSearchBtn to locate store in store locator page

	@FindBy(css = "[for='Hr24_Flag'] .storeLocator_checkBox")
	WebElement storeLocator24HrsChkBox; //storeLocator Store open for 24 in store locator page

	// Initializing the page object using constructor 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Action

	public String verifyHomeTitle() {
		return driver.getTitle();
	}

	public boolean verifyHomePageLogo() {
		return homePageLogo.isDisplayed();
	}

	public void verifySearchBox(String searchItem) {
		searchBox.sendKeys(searchItem);
		searchBoxBtn.click();
	}

	public String verifyPharmacyPageLink() {
		pharmacyLink.click();
		return driver.getTitle();
		//return new Pharmacy();
	}

	public MinuteClinic verifyMinuteClinicLink() {
		minuteClinicLink.click();
		return new MinuteClinic();
	}

	public Shop verifyShopLink() {
		shopLink.click();
		return new Shop();
	}

	public ExtraCare verifyExtraCareLink() {
		extraCareLink.click();
		return new ExtraCare();
	}

	public ContactLenses verifyContactLensesLink() {
		contactLensesLink.click();
		return new ContactLenses();
	}

	public Photo verifyPhotoLink() {
		photoLink.click();
		return new Photo();
	}

	public void verifyStoreLocator(String storeLocatorSearchItem) {
		storeLocatorLink.click();
		storeLocatorSearchBox.sendKeys(storeLocatorSearchItem);
		storeLocatorSearchBtn.click();
	}

	public void verifyStoreLocatorUsing24Hrs(String storeLocatorSearchItem1) {
		storeLocatorLink.click();
		storeLocator24HrsChkBox.click();
		storeLocatorSearchBox.sendKeys(storeLocatorSearchItem1);
		storeLocatorSearchBtn.click();
	}
}
