package com.cvs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cvs.qa.pages.ExtraCare;
import com.cvs.qa.testbase.TestBase;

public class ExtraCareTest extends TestBase {

	ExtraCare extraCare;

	public ExtraCareTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		extraCare = new ExtraCare();
	}

	@Test(priority = 1)
	public void verifyExtraCarePageTitleTest() {
		extraCare.verifyExtraCareLink();
		String ecTite = extraCare.verifyExtraCarePageTitle();
		Assert.assertEquals(ecTite, "CVS ExtraCare | ExtraBucks Rewards | Get Manufacturer Coupons");
	}

	@Test(priority = 2)
	public void verifyExtraCareSignInTest() throws Exception {
		extraCare.verifyExtraCareLink();
		extraCare.verifyExtraCareSignIn("shuwaibliaquat@hotmail.com", "hhb12345");
	}

	@Test(priority = 3)
	public void verifyExtraCareShoppingCartTest() {
		extraCare.verifyExtraCareLink();
		extraCare.verifyExtraCareShoppingCart();
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
