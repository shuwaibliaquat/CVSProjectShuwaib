package com.cvs.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.cvs.qa.pages.LogInPage;
import com.cvs.qa.pages.Pharmacy;
import com.cvs.qa.testbase.TestBase;

public class PharmacyTest extends TestBase {

	Pharmacy pharmacy;
	LogInPage logIn;
	static Logger log = Logger.getLogger(PharmacyTest.class);

	public PharmacyTest() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) {
		// initialization();
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "Resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.get(prop.getProperty("url"));
		pharmacy = new Pharmacy();
		logIn = new LogInPage();
		log.info("Beginnning of Pharmacy Test Case for CrossBrowser and Patallel testing");
	}

	@Test(priority = 0)
	public void verifyTransferingRX2CVS() {
		// logIn.userLogIn("shuwaib@yahoo.com", "hhb12345");
		pharmacy.transferPrescription();
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
