package com.qa.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private ChromeOptions co;
	private EdgeOptions eo;
	private FirefoxOptions fo;
	private Properties prop;
	
	public OptionsManager (Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			co = new ChromeOptions();
			co.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			co = new ChromeOptions();
			co.addArguments("--incognito");
		}
		return co;
	}
	
	public EdgeOptions getEdgeOptions() {
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			eo = new EdgeOptions();
			eo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			eo = new EdgeOptions();
			eo.addArguments("--incognito");
		}
		return eo;
	}
	
	public FirefoxOptions getFireFoxOptions() {
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			fo = new FirefoxOptions();
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			fo = new FirefoxOptions();
			fo.addArguments("--incognito");
		}
		return fo;
	}

}
