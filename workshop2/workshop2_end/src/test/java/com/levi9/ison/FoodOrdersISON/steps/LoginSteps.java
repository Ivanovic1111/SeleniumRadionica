package com.levi9.ison.FoodOrdersISON.steps;

import java.util.Properties;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.testng.Assert.assertTrue;

import com.levi9.ison.FoodOrdersISON.pages.Header;
import com.levi9.ison.FoodOrdersISON.pages.HomePage;
import com.levi9.ison.FoodOrdersISON.pages.LoginPage;
import com.levi9.ison.propertieshandlers.AbstractPropertiesHandler;

public class LoginSteps extends CommonSteps {

	Properties loginProperties = AbstractPropertiesHandler
			.loadProperties("src/test/resources/properties/data.properties");

	private LoginPage loginPage;
	private HomePage homePage;
	private Header header;
	
	private String username = loginProperties.getProperty("valid.username");
	private String password = loginProperties.getProperty("valid.password");
	
	@Given("user is on Login page")
	public void openLoginPage() {
		driver.manage().deleteAllCookies();
		loginPage = new LoginPage(driver);
		loginPage.openBaseUrl();
		assertTrue(loginPage.isLoaded(), "User is not logged successfully.");
	}

	@When("user types empty credentials")
	public void typeEmptyCredentials() throws Exception {
		homePage = loginPage.login("", "");
	}
	
	@When("user types username and password")
	public void typeCredentials() throws Exception {
		homePage = loginPage.login(username, password);
	}
	
	@Then("user cannot order food")
	public void openLoginErrorPage() throws Exception {
		Boolean errorMsg;
		assertTrue(loginPage.isLoaded());
		errorMsg = (loginPage.isUsernameErrorMsgDisplayed()) || (loginPage.isPasswordErrorMsgDisplayed());
		assertTrue(errorMsg);
	}
	
	@Then("FoodOrders page opens")
	public void openFoodOrdersPage() throws Exception {
		assertTrue(homePage.isLoaded());
	}
	
	@When ("user clicks Logs Off in Login scenario")
	public void userLogOff(){
		header = new Header(driver);
        loginPage = header.clickLogOff();
    }
	
	@Then ("user is logged off successfully from Login scenario")
	public void verifyUserLoggedOff (){
		assertTrue(loginPage.isLoaded(), "User is not logged successfully");
	}
	
}
