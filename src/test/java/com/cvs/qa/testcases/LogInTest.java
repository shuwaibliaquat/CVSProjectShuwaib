package com.cvs.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cvs.qa.pages.LogInPage;
import com.cvs.qa.testbase.TestBase;
import com.cvs.qa.utilities.TestUtil;

public class LogInTest extends TestBase {
	LogInPage logIn;
	String sheetName = "loginPage";
	static Logger log = Logger.getLogger(LogInTest.class);

	public LogInTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		logIn = new LogInPage();
		log.info("Beginnning of Test Case");
	}

	@DataProvider
	public Object[][] getCVSTestDataLogIn() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 0, dataProvider = "getCVSTestDataLogIn")
	public void verifyLogInExcelData(String emailAddress, String password) throws Exception {
		logIn.userLogIn(emailAddress, password);
	}

	@Test(priority = 1)
	public void verifyLogInTest() throws Exception {
		logIn.userLogIn("shuwaibliaquat@hotmail.com", "hhb12345");
	}

	@Test(priority = 2, dataProvider = "getCVSTestDataLogIn")
	public void verifyTopPanelLogInTestExcelDataTest(String emailAddress, String password) throws Exception {
		logIn.userTopPanelLogIn(emailAddress, password);
	}

	@Test(priority = 3)
	public void verifyTopPanelLogInTest() throws Exception {
		logIn.userTopPanelLogIn("shuwaibliaquat@hotmail.com", "hhb12345");
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
