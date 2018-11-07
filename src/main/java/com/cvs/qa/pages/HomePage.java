package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class HomePage extends TestBase {

	static Logger log = Logger.getLogger(HomePage.class);

	// Page Object Repository

	@FindBy(xpath = "//html[@id='homepage']")
	WebElement homePageLogo;

	@FindBy(xpath = "//*[@id=\"headCVS\"]/div[3]/div/div[1]/ul/li[1]/a")
	WebElement pharmacyLink;

	@FindBy(xpath = "//*[@id=\"headCVS\"]/div[3]/div/div[1]/ul/li[2]/a")
	WebElement minuteClinicLink;

	@FindBy(xpath = "//*[@id=\"headCVS\"]/div[3]/div/div[1]/ul/li[3]/a")
	WebElement shopLink;

	@FindBy(xpath = "//*[@id=\"headCVS\"]/div[3]/div/div[1]/ul/li[4]/a")
	WebElement extraCareLink;

	@FindBy(xpath = "//*[@id=\"headCVS\"]/div[3]/div/div[1]/ul/li[5]/a")
	WebElement contactLensesLink;

	@FindBy(xpath = "//*[@id=\"headCVS\"]/div[3]/div/div[1]/ul/li[6]/a")
	WebElement photoLink;

	@FindBy(xpath = "//input[@id='searchbox']")
	WebElement searchBox;

	@FindBy(css = "#mobile-off__base")
	WebElement searchBoxBtn;

	@FindBy(xpath = "//*[@title=\"Find CVS Store Locations\"]")
	WebElement storeLocatorLink;

	@FindBy(xpath = "//input[@id='search']")
	WebElement storeLocatorSearchBox;

	@FindBy(xpath = "//input[@id='srchstorebtn']")
	WebElement storeLocatorSearchBtn;

	@FindBy(css = "[for='Hr24_Flag'] .storeLocator_checkBox")
	WebElement storeLocator24HrsChkBox;

	// Initializing the page object
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

	public Pharmacy verifyPharmacyPageLink() {
		pharmacyLink.click();
		// return driver.getTitle();
		return new Pharmacy();
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
