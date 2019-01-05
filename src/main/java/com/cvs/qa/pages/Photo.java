package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cvs.qa.testbase.TestBase;

public class Photo extends TestBase {

	static Logger log = Logger.getLogger(Photo.class);

	@FindBy(xpath = "//a[@title='CVS Photo']")
	WebElement photoLink;

	@FindBy(xpath = "//*[@id='hero1']/a/img")
	WebElement printNowPicLink;

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

}
