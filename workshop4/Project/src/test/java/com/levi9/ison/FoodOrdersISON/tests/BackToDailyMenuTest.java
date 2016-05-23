package com.levi9.ison.FoodOrdersISON.tests;

import java.util.Properties;

import org.apache.log4j.Logger;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.levi9.ison.FoodOrdersISON.pages.Header;
import com.levi9.ison.FoodOrdersISON.pages.HomePage;
import com.levi9.ison.FoodOrdersISON.pages.LoginPage;
import com.levi9.ison.FoodOrdersISON.pages.NewMeal;
import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.propertieshandlers.AbstractPropertiesHandler;
import com.levi9.ison.tests.BaseTest;

public class BackToDailyMenuTest extends BaseTest {
	
	private static final Logger LOGGER = Logger.getLogger(BackToDailyMenuTest.class);
	Properties loginProperties = AbstractPropertiesHandler.loadCurrentThreadProperties("properties/data.properties");
	 
	private LoginPage loginPage;
	private Header header;
	private HomePage homePage;
	private NewMeal newMealPage;
	
	private String username = loginProperties.getProperty("valid.username"); 
	private String password = loginProperties.getProperty("valid.password");  
	 
	@BeforeMethod
	@Parameters({"profile"})
	public void setUp(String profile) {
		super.setUp(profile);	
		loginPage = new LoginPage(getDriver());
		header = new Header(getDriver());
		LOGGER.info("set up initialized");
	}
	
	@Test
	public void testBackToDailyMenu(){
		LOGGER.info("TEST - BackToDailyMenu starts...");
 		loginPage.openBaseUrl();
		assertTrue(loginPage.isLoaded());
		homePage = loginPage.login(username, password);
		WaitHelper.waitAdditional(1);
		assertTrue(homePage.isLoaded());
		
		newMealPage = header.clickAddNewMealHeaderLink();
		assertTrue(newMealPage.isMealPageLegendDisplayed(), "Meal legend is not displayed on AddNewMeal page.");
		
		homePage = newMealPage.clickBackToDailyMenyLink();
		WaitHelper.waitAdditional(1);
		assertTrue(homePage.isLoaded());

		LOGGER.info("TEST - BackToDailyMenu finished.");
	}
	
	@AfterMethod
	public void closeDriver() throws Exception {
		super.tearDown();
	}

}
