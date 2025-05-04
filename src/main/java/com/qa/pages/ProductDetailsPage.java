package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
	
	private WebDriver driver;
	
	private By searchHeading = By.xpath("//div[@id='content']//h1");
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProdDeatilsPageTitle() {
		return driver.getTitle();
	}

}
