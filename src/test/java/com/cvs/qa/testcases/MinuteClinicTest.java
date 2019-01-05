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
		Assert.assertEquals(minuteClinicTitle, "CVS Walk-in Clinics | MinuteClinic");
		try {
			driver.findElement(By.xpath("//*[@id=\"acsMainInvite\"]/div/a[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyZipCodeLocaterTest() throws Exception {
		/*Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@id=\"acsMainInvite\"]/div/a[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		minuteClinic.verifyZipCodeLocater("07503");
		Thread.sleep(2000);
		minuteClinic.clickBtnVisitToday();

	}

	@Test(priority = 2)
	public void verifyClinicLocatorPageTitleTest() throws Exception {
	/*	try {
			driver.findElement(By.xpath("//*[@id=\"acsMainInvite\"]/div/a[1]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		minuteClinic.verifyZipCodeLocater("07503");
		Thread.sleep(2000);
		minuteClinic.clickBtnVisitToday();
		Thread.sleep(2000);
		String ClinicLocatorPageTitle = locator.verifyClinicLocatorPageTitle();
		Assert.assertEquals(ClinicLocatorPageTitle, "Walk In Clinic Locator | MinuteClinic - CVS.com");
		locator.verifyChkBox();
		

	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
