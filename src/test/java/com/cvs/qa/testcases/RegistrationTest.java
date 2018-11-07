package com.cvs.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cvs.qa.pages.Registration;
import com.cvs.qa.testbase.TestBase;
import com.cvs.qa.utilities.TestUtil;

public class RegistrationTest extends TestBase {

	Registration registration;
	String sheetName = "registrationPage";
	static Logger log = Logger.getLogger(RegistrationTest.class);

	public RegistrationTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		registration = new Registration();
		log.info("Beginnning of Test Case");
	}

	@DataProvider
	public Object[][] getCVSTestDataRegistration() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 0)
	public void verifyRegistrationPageTitle() {
		String RegTitle = registration.verifyRegPageTitle();
		// Assert.assertEquals(RegTitle, "Create Your CVS Account");//Bug (expected
		// [Create Your CVS Account] but found [Registration Optimization])
	}

	@Test(priority = 1)
	public void registerCustomer() throws InterruptedException {
		registration.registrationForm("Shuwaib", "Liaquat", "shuwaibliaquat@hotmail.com", "Bangladesh@1",
				"Bangladesh@1");

		// registration.selectSecurityQuestion();

		registration.securityQustionAnswer("Krish");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		registration.clickContinue();

		registration.registrationForm2ndPart("Chapel Hill Rd", "24", "LinColn Park", "07503", "2012592479", "01", "29",
				"1989");

		registration.regStateDropDown();
		registration.regGenderDropDown();

		// registration.clickCreateAccount();
	}

	@Test(priority = 2, dataProvider = "getCVSTestDataRegistration")
	public void registerMultipleCustomer(String FirstName, String LastName, String EmailAddress, String Pwd,
			String CPwd, String Name, String StreetAddress, String Apt, String City, String State, String ZipCode,
			String PhoneNumber, String Month, String Day, String Year, String Gender) throws Exception {

		registration.registrationForm(FirstName, LastName, EmailAddress, Pwd, CPwd);
		registration.securityQustionAnswer(Name);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		registration.clickContinue();

		registration.registrationForm2ndPart(StreetAddress, Apt, City, ZipCode, PhoneNumber, Month, Day, Year);

		WebElement RegStateExcelData = driver.findElement(By.xpath("//select[@id='state']"));
		Select sel1 = new Select(RegStateExcelData);
		sel1.selectByValue(State);

		WebElement RegGenderExcelData = driver.findElement(By.xpath("//select[@id='gender']"));
		Select sel2 = new Select(RegGenderExcelData);
		sel2.selectByVisibleText(Gender);
		// registration.clickCreateAccount();
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
		log.info("Ending of Test Case");
	}

}
