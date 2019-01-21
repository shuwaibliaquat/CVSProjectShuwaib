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
		Assert.assertEquals(title, "CVS Photo: Photo Prints | Passport Photos | Photo Cards | Photo Books");
		// TEST Failed: java.lang.AssertionError: expected [Photo Printing Services |
		// Print Photos Online | CVS Photo] but found [CVS Photo: Photo Prints |
		// Passport Photos | Photo Cards | Photo Books]
	}

	@Test(priority = 2)
	public void verifyShopNowPicLinkTest() {
		photo.verifyPrintNowLink();
	}

	@Test(priority = 3)
	public void verifyPhotoPageHomeTitleTest() {
		String title1 = photo.verifyPhotoLinkHomePageTitle("shuwaibliaquat@hotmail.com", "hhb12345");
		Assert.assertEquals(title1, "Photo Printing Services | Print Photos Online | CVS Photo");
	}

	@Test(priority = 0)
	public void verifyPhotoUploadTest() throws Exception {
		photo.verifyPhotoLinkHomePageTitle("shuwaibliaquat@hotmail.com", "hhb12345");
		photo.uploadPhoto();
		
		//This test passed multiple times but CVS has some kind of blockage which makes testing difficult
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
