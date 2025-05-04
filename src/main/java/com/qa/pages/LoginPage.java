package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By emailIdField = By.id("input-email");
	private By passwordField = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public AccountsPage doLogin(String username, String pwd) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(emailIdField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AccountsPage(driver);
	}

}
