package com.cvs.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cvs.qa.utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver seleniumLog;
	public static WebEventListener eventListener;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip;
			ip = new FileInputStream(
					"C:\\Users\\JavaLearner\\Desktop\\CvsPharmacyProject\\CvsPharmacyTest\\src\\main\\java\\com\\cvs\\qa\\configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		// PropertyConfigurator.configure("C:\\Users\\JavaLearner\\Desktop\\CvsPharmacyProject\\CvsPharmacyTest\\src\\main\\resources\\log4j.properties");
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\JavaLearner\\Desktop\\CvsPharmacyProject\\CvsPharmacyTest\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\JavaLearner\\Desktop\\CvsPharmacyProject\\CvsPharmacyTest\\Drivers\\geckodriver");
			driver = new FirefoxDriver();

		}

		// Creating Selenium LogFiles
		seleniumLog = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		seleniumLog.register(eventListener);
		driver = seleniumLog;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		Set<String> pages = driver.getWindowHandles();
		System.out.println("Number of Windows: " + pages.size());
	}

	// Delay Setup
	public void delayFor(int timeinMili) {
		try {
			Thread.sleep(timeinMili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
