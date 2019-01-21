package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cvs.qa.testbase.TestBase;

public class Photo extends TestBase {

	static Logger log = Logger.getLogger(Photo.class);
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
	@FindBy(xpath = "//a[@title='CVS Photo']")
	WebElement photoLink;

	@FindBy(xpath = "//*[@id='hero1']/a/img")
	WebElement printNowPicLink;
	
	@FindBy(xpath = "//ul[@id='po-fdropdown']/li[@name='mycomputer_tab']//span[@class='upload-link']")
	WebElement myComputerLink;
	
	@FindBy(xpath = "//a[@id='globalHeaderSignInRegister']")
	@CacheLookup
	WebElement signInPhoto;
	
	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement emailAddressTextBoxPhotoSignIn;

	@FindBy(xpath = "//input[@id='pwd']")
	@CacheLookup
	WebElement pwdTextBoxPhotoSignIn;
	
	@FindBy(xpath = "//input[@id='loginButtonDesk']")
	@CacheLookup
	WebElement signInBtnPhotoPage;
	
	@FindBy(linkText = "Upload Photos")
	@CacheLookup
	WebElement upLoadPhoto;
	
/*	@FindBy(id = "select-button")
	@CacheLookup
	WebElement selectPhotoBtn;*/
	
	@FindBy(xpath = "//*[@id=\"upload-widget\"]/div[3]/div[6]/div[1]/div/input")
	@CacheLookup
	WebElement selectPhotoUploadDoneBtn;

	public Photo() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPhotoPageTitle() {
		photoLink.click();
		return driver.getTitle();
	}

	public void verifyPrintNowLink() {
		photoLink.click();
		printNowPicLink.click();

	}
	
	public String verifyPhotoLinkHomePageTitle(String un, String pwd){
		photoLink.click();
		signInPhoto.click();
		emailAddressTextBoxPhotoSignIn.sendKeys(un);
		pwdTextBoxPhotoSignIn.sendKeys(pwd);
		signInBtnPhotoPage.click();
		
		return driver.getTitle();
	}
	
	public void uploadPhoto() throws Exception {
		String winHandleBefore = driver.getWindowHandle();
		upLoadPhoto.click();
		myComputerLink.click();
		
		//Switching to new window
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		/*Actions actions = new Actions(driver);
		actions.moveToElement(myComputerLink).build().perform();*/
		WebElement selectPhotoBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//span[@id='select-button-text']")));
		/*JavascriptExecutor executor = ((JavascriptExecutor)driver);
		executor.executeScript("arguments[0].click();", selectPhotoBtn);*/
		selectPhotoBtn.click();
	
		Runtime.getRuntime().exec("C:\\Users\\JavaLearner\\Desktop\\CvsPharmacyProject\\CvsPharmacyTest\\src\\main\\resources\\AutoITScript\\PicUpload.exe");
		selectPhotoUploadDoneBtn.click();
		
	}
}
