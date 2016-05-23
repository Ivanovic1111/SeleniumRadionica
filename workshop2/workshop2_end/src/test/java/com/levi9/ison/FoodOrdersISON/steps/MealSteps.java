package com.levi9.ison.FoodOrdersISON.steps;

import com.levi9.ison.FoodOrdersISON.pages.Header;
import com.levi9.ison.FoodOrdersISON.pages.LoginPage;
import com.levi9.ison.FoodOrdersISON.pages.NewMeal;
import com.levi9.ison.propertieshandlers.AbstractPropertiesHandler;

import java.util.Properties;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

	public void logIn() {
		driver.manage().deleteAllCookies();
		loginPage = new LoginPage(driver);
		loginPage.openBaseUrl();
		assertTrue(loginPage.isLoaded());
		homePage = loginPage.login(username, password);
	}

	public void openAddMealPage() {
		header = new Header(driver);
		newMealPage = header.clickAddNewMealHeaderLink();
		assertTrue(newMealPage.isMealPageLegendDisplayed(), "Meal legend is not displayed on AddNewMeal page.");

	}

	public void addNewActiveMeal() {
		newMealPage.populateNewMealFields(name, price, description);
		newMealPage.addNewMeal();
	}

	public void dailyMealIsInList() {
		newMealPage.clickRBrSort();
		assertEquals(newMealPage.getNameOfFirstMealInTable(), name, "Created meal is not in the table.");
	}

	public void validatePrice() {
		validatePrice = newMealPage.validatePrice(sheetPath,sheetName,numOfSheetRows);
	}

	public void checkValidate() {
		assertTrue(validatePrice, "Price format is not valid.");
	}

	public void userLogOff(){
		header = new Header(driver);
        loginPage = header.clickLogOff();
   	}

	public void verifyUserLoggedOff (){
		assertTrue(loginPage.isLoggedOff(), "User is not logged off.");
	}
	
}
