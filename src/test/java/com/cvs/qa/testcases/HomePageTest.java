package com.cvs.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cvs.qa.pages.HomePage;
import com.cvs.qa.testbase.TestBase;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority=0)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomeTitle();
		Assert.assertEquals(homePageTitle, "CVS - Online Drugstore, Pharmacy, Prescriptions & Health Information");
	}
	
	@Test(priority=1)
	public void verifyHomePageLogoTest() {
		boolean logo = homePage.verifyHomePageLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=2)
	public void verifySearchBoxTest() {
		homePage.verifySearchBox("Toys");
	
	}
	
	@Test(priority=3)
	public void verifyPharmacyLinkTest() {
		homePage.verifyPharmacyPageLink();
		//Assert.assertEquals(pharmacyTitle, "Pharmacy | Manage, Transfer, & Refill Prescriptions Online | CVS Pharmacy");
	}
	
	@Test(priority=4)
	public void verifyMinuteClinicLinkTest() {
		homePage.verifyMinuteClinicLink();
	}
	@Test(priority=5)
	public void verifyShopLinkTest() {
		homePage.verifyShopLink();
	}
	@Test(priority=6)
	public void verifyExtraCareLinkTest() {
		homePage.verifyExtraCareLink();
	}
	
	@Test(priority=7)
	public void verifyContactLensesTest() {
		homePage.verifyContactLensesLink();
		}
	@Test(priority=8)
	public void verifyPhotoLinkTest() {
		homePage.verifyPhotoLink();
			}
	
	@Test(priority=9)
	public void verifyStoreLocatorTest() {
		homePage.verifyStoreLocator("07503, NJ");
	}
	
	
	@Test(priority=10)
	public void verifyStoreLocator24HrsStoreTest() {
		homePage.verifyStoreLocatorUsing24Hrs("07035, NJ");
	}
	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
