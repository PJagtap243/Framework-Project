package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void getLoginPageTitleTest() {
		String actTitle = lpage.getTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		accPage = lpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, "My Account");
	}

}
