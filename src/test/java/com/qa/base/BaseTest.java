package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.factory.DriverFactoryManager;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage lpage;
	protected AccountsPage accPage;
	protected ProductDetailsPage pdPage;
	protected DriverFactoryManager dm;
	protected Properties prop;
	
	@BeforeTest
	public void setup() {
		dm = new DriverFactoryManager();
		prop = dm.initProperties();
		
		driver = dm.initDriver(prop);
		lpage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
