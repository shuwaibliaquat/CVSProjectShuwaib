package com.cvs.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cvs.qa.pages.SignUpPage4Savings;
import com.cvs.qa.testbase.TestBase;
import com.cvs.qa.utilities.TestUtil;

public class SignUp4DealTest extends TestBase {

	SignUpPage4Savings signUp;
	String sheetName = "SignUpPage";
	static Logger log = Logger.getLogger(SignUp4DealTest.class);

	public SignUp4DealTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUp = new SignUpPage4Savings();
		log.info("Beginnning of Test Case");
	}

	@DataProvider
	public Object[][] getCVSTestDataSignUp4Savings() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {
		String pageTitle = signUp.verifySignUpDealpageTitle();
		Assert.assertEquals(pageTitle, "CVS Pharmacy Email");
	}

	@Test(priority = 2)
	public void verifySignUp4DealsTest() {
		signUp.verifySignUp("shuwaibliaquat@hotmail.com", "shuwaibliaquat@hotmail.com", "123456", "Shuwaib", "Liaquat",
				"07035", "01291989", "8", "Chapel hill rd", "Lincoln Park", "NJ", "07035");
	}

	@Test(priority = 3, dataProvider = "getCVSTestDataSignUp4Savings")
	public void verifySignU4DealsExcelDataTest(String emailAddress, String reEnterEmailAddress, String ExtraCareNum,
			String FirstName, String LastName, String zipCode, String DOB, String addLine1, String addLine2,
			String city, String state, String zipCode2) {
		log.info("Beginnning of Excel Data Test");
		signUp.verifySignUp(emailAddress, reEnterEmailAddress, ExtraCareNum, FirstName, LastName, zipCode, DOB,
				addLine1, addLine2, city, state, zipCode2);
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
		log.info("End of Test Case");
	}
}
