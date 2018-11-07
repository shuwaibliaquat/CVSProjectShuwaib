package com.cvs.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cvs.qa.testbase.TestBase;

public class Shop extends TestBase {

	static Logger log = Logger.getLogger(Shop.class);

	@FindBy(xpath = "//li//a[contains(text(),'Shop')]")
	WebElement shopLink;

	@FindBy(xpath = "//*[@id=\"router-content\"]/cvs-shop/gb-container/gb-cvs/gbcvs-browse-bar/nav/gbcvs-mega-nav-btn/button/div/span")
	WebElement shopByCategoriesLDropDown;

	@FindBy(xpath = "//p[.='Vitamins']")
	WebElement vitaminLink;
	@FindBy(css = "div:nth-of-type(1) > .gb-ui:nth-of-type(1) [data-is='gb-list-item']:nth-of-type(1) .gbcvs-c-productTileAtc__btn")
	WebElement addCSLW2Cart;

	public Shop() {
		PageFactory.initElements(driver, this);
	}

	public String verifyShopPageTitle() {
		return driver.getTitle();
	}

	public void verifyShopLink() {
		shopLink.click();
	}

	public void verifyClickonShopAllCategories() {
		shopByCategoriesLDropDown.click();
	}

	public void verifyVitaminLink() {
		vitaminLink.click();
	}

	public void verifyAddCSLW2Cart() {
		addCSLW2Cart.click();
	}
}
