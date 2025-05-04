package com.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryManager {
	
	WebDriver driver;
	Properties prop;
	OptionsManager op;
	FileInputStream fp;
	
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		browserName = browserName.toLowerCase().trim();
		op = new OptionsManager(prop);
		
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver(op.getChromeOptions());			
			break;
		case "firefox":
			driver = new FirefoxDriver(op.getFireFoxOptions());			
			break;
		case "edge":
			driver = new EdgeDriver(op.getEdgeOptions());			
			break;
		default:
			System.out.println("Please enter the valid driver (Chrome, Firefox, Edge)");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	public Properties initProperties() {
		prop = new Properties();
		String envName = System.getProperty("env");
		try {
		if(envName == null) {
			System.out.println("Environment is not passed..Running on the default environment..QA");
			fp = new FileInputStream("./src/resources/Config/qa.config.properties");
		}
		else {
			switch (envName.toLowerCase().trim()) {
			case "dev":
				fp = new FileInputStream("./src/resources/Config/config.properties");
				break;
			case "qa":
				fp = new FileInputStream("./src/resources/Config/qa.config.properties");
				break;
			case "uat":
				fp = new FileInputStream("./src/resources/Config/uat.config.properties");
				break;

			default:
				System.out.println("Please enter the valid environment..!");
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		try {
			prop.load(fp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
