package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By logoutLink = By.linkText("Logout");
	private By searchBar = By.name("search");
	private By searchBtn = By.xpath("//span[@class='input-group-btn']//button");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isLogutLinkPresent() {
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public ProductDetailsPage searchProduct(String prodName) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(searchBar).sendKeys(prodName);
		driver.findElement(searchBtn).click();
		return new ProductDetailsPage(driver);
	}

}
