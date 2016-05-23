package com.levi9.ison.FoodOrdersISON.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.levi9.ison.FoodOrdersISON.pages.Header;
import com.levi9.ison.FoodOrdersISON.pages.HomePage;
import com.levi9.ison.FoodOrdersISON.pages.LoginPage;
import com.levi9.ison.FoodOrdersISON.pages.RecommendationPage;
import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.propertieshandlers.AbstractPropertiesHandler;
import com.levi9.ison.tests.BaseTest;

public class AddRecommendation extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(AddRecommendation.class);
	Properties loginProperties = AbstractPropertiesHandler.loadCurrentThreadProperties("properties/data.properties");
	 
	LoginPage loginPage;
	Header header;
	HomePage homePage;
	RecommendationPage recommendationPage;
	
	private String username = loginProperties.getProperty("valid.username");
	private String password = loginProperties.getProperty("valid.password");
	
	private String comment = loginProperties.getProperty("valid.recommendation.comment"); 
	 
	@BeforeMethod
	@Parameters({"profile"})
	public void setUp(String profile) {
		super.setUp(profile);	
		loginPage = new LoginPage(getDriver());
		header = new Header(getDriver());
		LOGGER.info("set up initialized");
	}
	
	@Test
	public void testAddARecomendation(){
		LOGGER.info("AddARecomendationTest starts...");
 		loginPage.openBaseUrl();
		Assert.assertTrue(loginPage.isLoaded());
		homePage = loginPage.login(username, password);
		WaitHelper.waitAdditional(1);
		Assert.assertTrue(homePage.isLoaded());
		
		recommendationPage = header.clickRecommendationHeaderLink();
		Assert.assertTrue(recommendationPage.checkIfOnRecommendationPage());
		
		recommendationPage.setRecommendationFields(comment);
		Assert.assertEquals(recommendationPage.getAddedRecommendationComment(), comment);

		LOGGER.info("AddARecomendationTest finished.");
	}
	
	@AfterMethod
	public void closeDriver() throws Exception {
		super.tearDown();
	}
 
}
