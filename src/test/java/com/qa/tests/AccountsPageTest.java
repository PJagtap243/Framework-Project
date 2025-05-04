package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage = lpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, "My Account");
	}
	
	@Test(priority = 2)
	public void logoutLinkPresentTest() {
		Assert.assertTrue(accPage.isLogutLinkPresent());
	}
	
	@Test(priority = 3)
	public void productSearchTest() {
		pdPage = accPage.searchProduct("macbook");
		System.out.println(pdPage.getProdDeatilsPageTitle());
		Assert.assertTrue(pdPage.getProdDeatilsPageTitle().contains("macbook"));
	}
}
