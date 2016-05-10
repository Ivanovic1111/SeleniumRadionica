package com.levi9.ison.FoodOrdersISON.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;
import java.util.Random;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.levi9.ison.FoodOrdersISON.pages.Header;
import com.levi9.ison.FoodOrdersISON.pages.LoginPage;
import com.levi9.ison.FoodOrdersISON.pages.NewMeal;
import com.levi9.ison.propertieshandlers.AbstractPropertiesHandler;

public class MealSteps extends CommonSteps {

	Random random = new Random();
	Properties loginProperties = AbstractPropertiesHandler.loadProperties("src/test/resources/properties/data.properties");

	private String username = loginProperties.getProperty("valid.username");
	private String password = loginProperties.getProperty("valid.password");
	
	private String name = loginProperties.getProperty("valid.meal.name") + random.nextInt(10000);
	private String price = loginProperties.getProperty("vaild.meal.price");
	private String description = loginProperties.getProperty("valid.meal.description");
	
	String workingDirectory = System.getProperty("user.dir");
	boolean validatePrice = false;
	private String sheetPath = workingDirectory + "\\src\\test\\resources\\excel_data\\validate.xls";
	private String sheetName = "foodOrder";
	private int numOfSheetRows = 4;
	
	private LoginPage loginPage;
	private Header header;
	private NewMeal newMealPage;
	
	@Given("user is logged into application for Meal scenario")
	public void logIn() {
		driver.manage().deleteAllCookies();
		loginPage = new LoginPage(driver);
		loginPage.openBaseUrl();
		assertTrue(loginPage.isLoaded());
		homePage = loginPage.login(username, password);
	}
	
	@Given("user is on Meal page")
	public void openAddMealPage() {
		header = new Header(driver);
		newMealPage = header.clickAddNewMealHeaderLink();
		assertTrue(newMealPage.isMealPageLegendDisplayed(), "Meal legend is not displayed on AddNewMeal page.");

	}
	
	@When("user populates new active meal")
	public void addNewActiveMeal() {
		newMealPage.populateNewMealFields(name, price, description);
		newMealPage.addNewMeal();
	}

	@Then("active meal is added to the list")
	public void dailyMealIsInList() {
		newMealPage.clickRBrSort();
		assertEquals(newMealPage.getNameOfFirstMealInTable(), name, "Created meal is not in the table.");
	}
	
	@When("user populates all fields and for price types invalid value")
	public void validatePrice() {
		validatePrice = newMealPage.validatePrice(sheetPath,sheetName,numOfSheetRows);
	}
	
	@Then("the field price must be a number message is displayed")
	public void checkValidate() {
		assertTrue(validatePrice, "Price format is not valid.");
	}
	
	@When ("user clicks Logs Off in Meal scenario")
	public void userLogOff(){
		header = new Header(driver);
        loginPage = header.clickLogOff();
   	}
	
	@Then ("user is logged off successfully from Meal scenario")
	public void verifyUserLoggedOff (){
		assertTrue(loginPage.isLoggedOff(), "User is not logged off.");
	}
	
}
