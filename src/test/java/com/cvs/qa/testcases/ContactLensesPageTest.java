package com.cvs.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cvs.qa.pages.ContactLenses;
import com.cvs.qa.pages.HomePage;
import com.cvs.qa.testbase.TestBase;

public class ContactLensesPageTest extends TestBase {
	ContactLenses contactLenses;
	HomePage homePage;
	static Logger log = Logger.getLogger(ContactLensesPageTest.class);
	
	public ContactLensesPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		contactLenses = new ContactLenses();
		homePage = new HomePage();
		log.info("Beginnning of ContactLensesPageTest Test Case");
	}

	@Test(priority = 1)
	public void veriyContactLensesPageTitleTest() {
		homePage.verifyContactLensesLink();
		String cLtitle = contactLenses.verifyContactLensesPageTitle();
		Assert.assertEquals(cLtitle, "Contact Lenses Online - CVS/pharmacy Optical");
	}

	@Test(priority = 2)
	public void verifyDropDownMenuContactLensBrandsTest() throws InterruptedException {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
	}

	@Test(priority = 3)
	public void verifyAcuvueDefine30PKTest() throws InterruptedException {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
		Thread.sleep(5000);
		contactLenses.verifyAcuvueLenseBrand("1-DAY ACUVUE DEFINE 30 Pack");
	}

	@Test(priority = 4)
	public void verifyAcuvueDefine90PKTest() throws InterruptedException {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
		Thread.sleep(2000);
		contactLenses.verifyAcuvueLenseBrand("1-DAY ACUVUE MOIST for ASTIGMATISM 90 Pack");
	}

	@Test(priority = 5)
	public void veriyAirOptixBrandTest() {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
		contactLenses.verifyAirOptixBrandElement("AIR OPTIX AQUA Multifocal");
	}

	@Test(priority = 6)
	public void veriyAirOptixBrandMouseHoverTest() {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
		contactLenses.verifyAirOptixBrandMouseHover();
	}

	@Test(priority = 7)
	public void veriyAcuvueElementListTest() throws Exception {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
		contactLenses.verifyAcuvueLenseBrand("");
		java.util.List<WebElement> acuvueLinks = driver.findElements(By.xpath("//*[@id='acuvue-links']/a"));
		int acuvueLinksSize = acuvueLinks.size();
		System.out.println(acuvueLinksSize);

		for (int i = 0; i < acuvueLinksSize; i++) {
			String acuvueBrand = acuvueLinks.get(i).getText();
			System.out.println(acuvueBrand);
			Thread.sleep(2000);
			System.out.println(i);
		}
	}

	@Test(priority = 8)
	public void veriyAirOptixAquaElementListTest() throws Exception {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
		contactLenses.verifyAirOptixBrandElement("");
		java.util.List<WebElement> airOptixLinks = driver.findElements(By.xpath("//*[@id='air-optix-links']/a"));
		int airOptixLinksSize = airOptixLinks.size();
		System.out.println(airOptixLinksSize);

		for (int i = 0; i < airOptixLinksSize; i++) {
			String airOptixBrand = airOptixLinks.get(i).getText();
			System.out.println(airOptixBrand);
			// Thread.sleep(2000);
			// System.out.println(i);
		}
	}

	@Test(priority = 9)
	public void veriyAirOptixBrandLabelClickTest() {
		homePage.verifyContactLensesLink();
		contactLenses.verifyDropDownLensBrands();
		contactLenses.verifyAirOptixBrand();
	}

	@Test(priority = 10)
	public void veriyLensTypeTest() {
		homePage.verifyContactLensesLink();
		contactLenses.verifyLensType("Colored Contacts");
	}

	@Test(priority = 11)
	public void veriyLensTypeElementListTest() throws Exception {
		homePage.verifyContactLensesLink();
		contactLenses.verifyLensType("");

		java.util.List<WebElement> lensTypeLinks = driver.findElements(By.xpath("//*[@id='type-dropdown']/div"));
		int size = lensTypeLinks.size();
		System.out.println(size);

		for (int i = 0; i < size; i++) {
			String lensType = lensTypeLinks.get(i).getText();
			System.out.println(lensType);
			Thread.sleep(2000);
			System.out.println(i);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
