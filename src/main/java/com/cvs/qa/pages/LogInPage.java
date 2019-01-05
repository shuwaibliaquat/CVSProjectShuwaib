package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cvs.qa.testbase.TestBase;

public class LogInPage extends TestBase {

	static Logger log = Logger.getLogger(LogInPage.class);

	/*@cacheLookup-> Instead of looking into browser DOM every time it will create
	a cache memory in eclipse and will look up from there instead of browser DOM.
*/
	@FindBy(xpath = "//button[@id='signInBtn']")
	@CacheLookup
	WebElement topPanelsignInLink;

	@FindBy(xpath = "//input[@id='clubLoginEmail']")
	@CacheLookup
	WebElement emailAddressPopUpTextBox;

	@FindBy(xpath = "//input[@id='clubLoginPwd']")
	@CacheLookup
	WebElement passwordPopUpTextBox;
	
	@FindBy(css = "[form]")
	@CacheLookup
	WebElement signInBtn;

/*	@FindBy(xpath = "html/body/div[16]/div/div/div/div[2]/ul[1]/li[1]/a")
	@CacheLookup
	WebElement signInLink;

	@FindBy(xpath = "//button[@id='create']")
	@CacheLookup
	WebElement submitBtnPopUpTextBox;

	@FindBy(xpath = "//input[@id='userEmail']")
	@CacheLookup
	WebElement emailAddressTextBox;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement pwdTextBox;*/

	

	public LogInPage() {
		PageFactory.initElements(driver, this);
	}

	public void userLogIn(String emailAddress, String pwd) throws Exception {
		topPanelsignInLink.click();
		Thread.sleep(2000);
		emailAddressPopUpTextBox.sendKeys(emailAddress);
		passwordPopUpTextBox.sendKeys(pwd);
		signInBtn.click();
	}

	public void userTopPanelLogIn(String popUpemailAddress, String popUpPwd) throws Exception {
		topPanelsignInLink.click();
		Thread.sleep(2000);
		emailAddressPopUpTextBox.sendKeys(popUpemailAddress);
		passwordPopUpTextBox.sendKeys(popUpPwd);
		signInBtn.click();
	}

}
