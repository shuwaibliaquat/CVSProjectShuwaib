package com.cvs.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.cvs.qa.pages.HomePage;
import com.cvs.qa.pages.Pharmacy;
import com.cvs.qa.testbase.TestBase;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	Pharmacy pharmacy;
	static Logger log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		log.info("Beginnning of Home Page Test Case");
	}

	@Test(priority = 0)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomeTitle();
		Assert.assertEquals(homePageTitle, "CVS - Online Drugstore, Pharmacy, Prescriptions & Health Information");
	}

	@Test(priority = 1)
	public void verifyHomePageLogoTest() {
		boolean logo = homePage.verifyHomePageLogo();
		Assert.assertTrue(logo);
	}

	@Test(priority = 2)
	public void verifySearchBoxTest() {
		homePage.verifySearchBox("Toys");

	}

	@Test(priority = 3)
	public void verifyPharmacyLinkTest() throws Exception {
		//homePage.verifyPharmacyPageLink();
		Thread.sleep(2000);
		String pharmacyPageTitle = homePage.verifyPharmacyPageLink();
		Assert.assertEquals(pharmacyPageTitle, "Pharmacy | Manage, Transfer, & Refill Prescriptions Online | CVS Pharmacy");
		log.info(pharmacyPageTitle);
	}

	@Test(priority = 4)
	public void verifyMinuteClinicLinkTest() {
		homePage.verifyMinuteClinicLink();
	}

	@Test(priority = 5)
	public void verifyShopLinkTest() {
		homePage.verifyShopLink();
	}

	@Test(priority = 6)
	public void verifyExtraCareLinkTest() {
		homePage.verifyExtraCareLink();
	}

	@Test(priority = 7)
	public void verifyContactLensesTest() {
		homePage.verifyContactLensesLink();
	}

	@Test(priority = 8)
	public void verifyPhotoLinkTest() {
		homePage.verifyPhotoLink();
	}

	@Test(priority = 9)
	public void verifyStoreLocatorTest() {
		homePage.verifyStoreLocator("07503, NJ");
	}

	@Test(priority = 10)
	public void verifyStoreLocator24HrsStoreTest() {
		homePage.verifyStoreLocatorUsing24Hrs("07035, NJ");
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
