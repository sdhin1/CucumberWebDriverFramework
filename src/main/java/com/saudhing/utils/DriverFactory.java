package com.saudhing.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.saudhing.pageObjects.BasePage;
import com.saudhing.pageObjects.ContactUs_Page;
import com.saudhing.pageObjects.Products_Page;

public class DriverFactory {

	public static WebDriver driver;
	public static BasePage basePage;
	public static ContactUs_Page contactUsPage;
	public static Products_Page productsPage;

	public static WebDriver getDriver() {

		try {
			// Read Config
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			prop.load(fis);
			String browser = prop.getProperty("browser"); 

			switch (browser) {

			// chrome setup
			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					ChromeOptions options = new ChromeOptions();
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
				}
				break;

			// fire fox setup
			case "firefox":
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			// IE setup
			case "ie":				
				if(driver == null) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
				}
				break;
			}
			

		} catch (Exception e) {
			System.out.println("Unable to load browser! - Exception: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			//Initialize Page Objects
			basePage = PageFactory.initElements(driver, BasePage.class);
			contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
			productsPage = PageFactory.initElements(driver, Products_Page.class);
			
		}

		return driver;

	}

}
