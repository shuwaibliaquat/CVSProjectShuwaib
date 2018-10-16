package com.cvs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cvs.qa.pages.Shop;
import com.cvs.qa.testbase.TestBase;
import org.apache.log4j.Logger;

public class ShopPageTest extends TestBase {
	
	Shop shop;
	static Logger log = Logger.getLogger(ShopPageTest.class);
	
	
	public ShopPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		 shop = new Shop();
		 log.info("Beginnning of Test Case");
		
	}
	
	 @Test(priority=1)
	 public void verifyShopPageTitleTest() throws Exception {
		 shop.verifyShopLink();
		 Thread.sleep(2000);
		 String sTitle = shop.verifyShopPageTitle();
		 Assert.assertEquals(sTitle, "Beauty, Vitamins, Medicine & Everyday Essentials | CVS.com");
	 }
	 
	 @Test(priority=2)
	 public void verifyShopPageLinkTest() {
		 shop.verifyShopLink();
	 }
	 @Test(priority=3)
	 public void verifyClickonShopAllCategoriesTest() throws Exception {
		 shop.verifyShopLink();
		 Thread.sleep(2000);
		 shop.verifyClickonShopAllCategories();
	 }
	 @Test(priority=4)
	 public void verifyClickonVitaminLink() {
		 shop.verifyShopLink();
		 shop.verifyVitaminLink();
	 }
	 
	 @Test(priority=5)
	 public void verifyAddCSLW2CartTest() {
		 shop.verifyShopLink();
		 shop.verifyAddCSLW2Cart();
	 }
	 
	
	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
