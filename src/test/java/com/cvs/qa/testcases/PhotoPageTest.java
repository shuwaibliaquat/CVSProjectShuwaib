package com.cvs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cvs.qa.pages.Photo;
import com.cvs.qa.testbase.TestBase;

public class PhotoPageTest extends TestBase {
	Photo photo;

	public PhotoPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		photo = new Photo();
	}

	@Test(priority = 1)
	public void verifyPhotoPageTitleTest() {
		String title = photo.verifyPhotoPageTitle();
		Assert.assertEquals(title, "Photo Printing Services | Print Photos Online | CVS Photo");
	//TEST Failed: java.lang.AssertionError: expected [Photo Printing Services | Print Photos Online | CVS Photo] but found [CVS Photo: Photo Prints | Passport Photos | Photo Cards | Photo Books]
	}

	@Test(priority = 2)
	public void verifyShopNowPicLinkTest() {
		photo.verifyPrintNowLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
