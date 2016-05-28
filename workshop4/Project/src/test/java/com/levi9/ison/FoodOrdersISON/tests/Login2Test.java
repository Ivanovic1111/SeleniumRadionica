package com.levi9.ison.FoodOrdersISON.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.levi9.ison.FoodOrdersISON.pages.HomePage;
import com.levi9.ison.FoodOrdersISON.pages.LoginPage;
import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.propertieshandlers.AbstractPropertiesHandler;
import com.levi9.ison.tests.BaseTest;

public class Login2Test extends BaseTest { 
	
	private static final Logger LOGGER = Logger.getLogger(Login2Test.class);
	Properties loginProperties = AbstractPropertiesHandler.loadCurrentThreadProperties("properties/data.properties");
	 
	private String username = loginProperties.getProperty("valid.username"); //"code9fo";
	private String password = loginProperties.getProperty("valid.password"); //"foodcode9";
	
	private LoginPage loginPage; 
	private HomePage homePage;
	
	@BeforeMethod
	@Parameters({"profile"})
	public void setUp(@Optional String profile) {
		super.setUp(profile);
		LOGGER.info("set up initialized");
	}

 	@Test
 	public void loginTest() {
 		LOGGER.info("test begins...");
 		loginPage = new LoginPage(getDriver());
 		loginPage.openBaseUrl();
		assertTrue(loginPage.isLoaded());
		
		homePage = loginPage.login(username, password);
		WaitHelper.waitAdditional(1);
		assertTrue(homePage.isLoaded());	
	}

	@AfterMethod
	public void closeDriver() throws Exception {
		super.tearDown();
	}
}