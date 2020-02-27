package com.demo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.DashboardPage;
import com.demo.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase{

	DashboardPage dashboardPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		initialisation();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();
		loginPage.login(prob.getProperty("username"), prob.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void dashboardLogoTest(){
		Assert.assertTrue(dashboardPage.verifyDashboardLogo());
	}
	
	@Test(priority = 2)
	public void launcherIconTest(){
		Assert.assertTrue(dashboardPage.verifyLauncherIcon());
	}
	
	@Test(priority = 3)
	public void avatarIconTest(){
		Assert.assertTrue(dashboardPage.verifyAvatarIcon());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
