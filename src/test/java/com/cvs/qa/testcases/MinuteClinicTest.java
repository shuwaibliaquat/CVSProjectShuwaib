package com.cvs.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cvs.qa.pages.ClinicLocator;
import com.cvs.qa.pages.MinuteClinic;
import com.cvs.qa.testbase.TestBase;

public class MinuteClinicTest extends TestBase {
	MinuteClinic minuteClinic;
	ClinicLocator locator;

	public MinuteClinicTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		minuteClinic = new MinuteClinic();
		locator = new ClinicLocator();
	}

	@Test(priority = 0)
	public void verifyMinuteClinicPageTitleTest() {
		String minuteClinicTitle = minuteClinic.verifyMinuteClinicPageTitle();
		Assert.assertEquals(minuteClinicTitle, "MinuteClinic | CVS Walk In Clinics");
		try {
			driver.findElement(By.xpath("//*[@id=\"acsMainInvite\"]/div/a[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyZipCodeLocaterTest() {
		// Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@id=\"acsMainInvite\"]/div/a[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minuteClinic.verifyZipCodeLocater("07503");
		minuteClinic.clickBtnVisitToday();

	}

	@Test(priority = 2)
	public void verifyClinicLocatorPageTitleTest() {
		try {
			driver.findElement(By.xpath("//*[@id=\"acsMainInvite\"]/div/a[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minuteClinic.verifyZipCodeLocater("07503");
		minuteClinic.clickBtnVisitToday();
		locator.verifyChkBox();
		String ClinicLocatorPageTitle = locator.verifyClinicLocatorPageTitle();
		Assert.assertEquals(ClinicLocatorPageTitle, "Walk In Clinic Locator | MinuteClinic - CVS.com");

	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
