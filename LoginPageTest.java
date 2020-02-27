package com.demo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.DashboardPage;
import com.demo.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setUp() {
		initialisation();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageLogoTest() throws InterruptedException {
		Assert.assertTrue(loginPage.verifyLogoImage());
	}

	@Test(priority = 2)
	public void loginTest() {
		dashboardPage = loginPage.login(prob.getProperty("username"), prob.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
