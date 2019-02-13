package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cvs.qa.testbase.TestBase;

public class Registration extends TestBase {

	static Logger log = Logger.getLogger(Registration.class);
	//WebDriverWait wait=new WebDriverWait(driver, 20); //Explicit Wait
	// Registration 1st Step:>>

	@FindBy(css = ".sign-in-block [value]")
	WebElement CreateAnAccountLink;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement RegFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement RegLastName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement RegEmailAddress;

	@FindBy(xpath = "//input[@id='password']")
	WebElement RegPassword;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement RegConfirmPassword;

	@FindBy(xpath = "//input[@id='securityAns']")
	WebElement RegSecurityQuestionAnswer;

	@FindBy(xpath = "//*[@id=\"continueAccount\"]")
	WebElement RegContinueBtn;

	// Registration 2nd Step:>>

	@FindBy(xpath = "//input[@id='street']")
	WebElement RegStreetAddress;

	@FindBy(xpath = "//input[@id='aptBldg']")
	WebElement RegAptAddress;

	@FindBy(xpath = "//input[@id='city']")
	WebElement RegCity;

	@FindBy(xpath = "//input[@id='zip']")
	WebElement RegZipCode;

	@FindBy(xpath = "//input[@id='phoneNum']")
	WebElement RegPhoneNum;

	@FindBy(xpath = "//input[@id='month']")
	WebElement RegDateOfBirthMonth;

	@FindBy(xpath = "//input[@id='day']")
	WebElement RegDateOfBirthDay;

	@FindBy(xpath = "//input[@id='year']")
	WebElement RegDateOfBirthYear;

	@FindBy(xpath = "//form[@id='profileForm']/div[11]/div[@class='col-xs-12']")
	WebElement RegCreateAccountBtn;

	// Initializing the page object
	public Registration() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		// PageFactory.initElements(driver, this);
	}

	public String verifyRegPageTitle() {
		CreateAnAccountLink.click();
		return driver.getTitle();
	}

	public void registrationForm(String FirstName, String LastName, String EmailAddress, String Pwd, String CPwd) {

		CreateAnAccountLink.click();

		RegFirstName.sendKeys(FirstName);
		RegLastName.sendKeys(LastName);
		RegEmailAddress.sendKeys(EmailAddress);
		RegPassword.sendKeys(Pwd);
		RegConfirmPassword.sendKeys(CPwd);

	}

	public void registrationForm2ndPart(String StreetAddress, String Apt, String City, String ZipCode,
			String PhoneNumber, String Month, String Day, String Year) {

		RegStreetAddress.sendKeys(StreetAddress);
		RegAptAddress.sendKeys(Apt);
		RegCity.sendKeys(City);

		// Drop Down Menu
		// WebElement RegState = driver.findElement(By.xpath("//select[@id='state']"));
		// Select sel1 = new Select(RegState);
		// sel1.selectByValue("NJ");

		RegZipCode.sendKeys(ZipCode);
		RegPhoneNum.sendKeys(PhoneNumber);
		RegDateOfBirthMonth.sendKeys(Month);
		RegDateOfBirthDay.sendKeys(Day);
		RegDateOfBirthYear.sendKeys(Year);

		// Drop Down Menu
		// WebElement RegGender =
		// driver.findElement(By.xpath("//select[@id='gender']"));
		// Select sel2 = new Select(RegGender);
		// sel2.selectByVisibleText("Male");
	}

	public void regStateDropDown() {

		WebElement RegState = driver.findElement(By.xpath("//select[@id='state']"));
		Select sel1 = new Select(RegState);
		sel1.selectByValue("NJ");
	}

	public void regGenderDropDown() {

		WebElement RegGender = driver.findElement(By.xpath("//select[@id='gender']"));
		Select sel2 = new Select(RegGender);
		sel2.selectByVisibleText("Male");
	}

	public void securityQustionAnswer(String Name) {

		// Drop Down Menu
		WebElement element = driver.findElement(By.xpath("//*[@id='securityQuestion']"));
		Select sel = new Select(element);
		sel.selectByVisibleText("What was the name of my childhood pet?");

		RegSecurityQuestionAnswer.sendKeys(Name);
	}

	public void clickContinue() throws InterruptedException {
		//ExplicitWaiting
		//RegContinueBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\\\"continueAccount\\\"]")));
		
		if (RegContinueBtn.isEnabled()) {
			RegContinueBtn.click();
		} else {
			RegContinueBtn.click();
		}

	}

	public HomePage clickCreateAccount() throws Exception {

		RegCreateAccountBtn.click();
		return new HomePage();

	}

}
