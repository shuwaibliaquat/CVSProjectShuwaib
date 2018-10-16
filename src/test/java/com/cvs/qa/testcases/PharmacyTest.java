package com.cvs.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cvs.qa.pages.LogInPage;
import com.cvs.qa.pages.Pharmacy;
import com.cvs.qa.testbase.TestBase;

public class PharmacyTest extends TestBase {
	
	Pharmacy pharmacy;
	LogInPage logIn;
	public PharmacyTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		pharmacy = new Pharmacy();
		logIn = new LogInPage();
	}
	
	@Test(priority=0)
	public void verifyTransferingRX2CVS() {
		//logIn.userLogIn("shuwaib@yahoo.com", "hhb12345");
		pharmacy.transferPrescription();
	}
	
	@AfterMethod
	public void tearDown() {
	
		driver.quit();
	}
}
