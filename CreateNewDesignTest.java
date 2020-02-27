package com.demo.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.ApplicationDashboardPage;
import com.demo.qa.pages.DesignContainersPage;
import com.demo.qa.pages.DesignOverviewPage;
import com.demo.qa.pages.DesignServicePage;
import com.demo.qa.pages.LoginPage;

public class CreateNewDesignTest extends TestBase{

	ApplicationDashboardPage applicationDashboardPage;
	LoginPage loginPage;
	DesignServicePage designServicePage;
	DesignContainersPage designContainersPage;
	DesignOverviewPage designOverviewPage;
	
	String displayName = "DemoTestDesign";
	String description = "Demo Test Design";
	String version = "2.0.0";
	
	@BeforeMethod
	public void setUp(){
		initialisation();
		loginPage = new LoginPage();
		loginPage.login(prob.getProperty("username"), prob.getProperty("password"));
		applicationDashboardPage = new ApplicationDashboardPage();
	}
	
	@Test
	public void CreateNewDesign() throws InterruptedException{
		designServicePage = applicationDashboardPage.openDesignServicePage();
		designContainersPage = designServicePage.openSequencedDesignerPage();
		designOverviewPage = designContainersPage.createNewDesign(displayName, description , version);
		TimeUnit.SECONDS.sleep(3);
		Assert.assertEquals(designOverviewPage.getDisplayName(), displayName);
		Assert.assertEquals(designOverviewPage.getDescription(), description);
		Assert.assertEquals(designOverviewPage.getVersion(), version);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
