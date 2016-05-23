package com.levi9.ison.FoodOrdersISON.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;
import java.util.Random;

import com.levi9.ison.FoodOrdersISON.pages.Header;
import com.levi9.ison.FoodOrdersISON.pages.LoginPage;
import com.levi9.ison.FoodOrdersISON.pages.RestaurantPage;
import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.propertieshandlers.AbstractPropertiesHandler;

public class RestaurantSteps extends CommonSteps {
	
	Random random = new Random();
	Properties loginProperties = AbstractPropertiesHandler.loadProperties("src/test/resources/properties/data.properties");

	private String username = loginProperties.getProperty("valid.username");
	private String password = loginProperties.getProperty("valid.password");
	//data for create restaurant
	private String name = loginProperties.getProperty("valid.restaurant.name") + random.nextInt(10000);
	private String phoneNumber = loginProperties.getProperty("valid.restaurant.phonenumber");
	private String phoneNumber2 = loginProperties.getProperty("valid.restaurant.phonenumber2");
	private String adress = loginProperties.getProperty("valid.restaurant.address");
	private String contactPerson = loginProperties.getProperty("valid.restaurant.contactperson");
	private String numberOfMealForDeliver = loginProperties.getProperty("valid.restaurant.numberofmealsfordeliver");
	private String numberOfMealForDiscount = loginProperties.getProperty("valid.restaurant.numberofmealsfordiscount");
	// data for editing restaurant fields
	private String newName = loginProperties.getProperty("valid.restaurant.newname") + random.nextInt(10000);
	private String newPhoneNumber = loginProperties.getProperty("valid.restaurant.newphonenumber");
	private String newPhoneNumber2 = loginProperties.getProperty("valid.restaurant.newphonenumber2");
	private String newAdress = loginProperties.getProperty("valid.restaurant.newaddress");
	private String newContactPerson = loginProperties.getProperty("valid.restaurant.newcontactperson");
	private String newNumberOfMealForDeliver = loginProperties.getProperty("valid.restaurant.newnumberofmealsfordeliver");
	private String newNumberOfMealForDiscount = loginProperties.getProperty("valid.restaurant.newnumberofmealsfordiscount");
	
	private LoginPage loginPage;
	private RestaurantPage restaurantPage;
	private Header header;
	
	public void logIn() {
		driver.manage().deleteAllCookies();
		loginPage = new LoginPage(driver);
		loginPage.openBaseUrl();
		assertTrue(loginPage.isLoaded(), "Application is not opened.");
		homePage = loginPage.login(username, password);
	}
	
	public void openRestaurantPage() {
		header = new Header(driver);
		restaurantPage = header.clickRestaurantHeaderLink();
		WaitHelper.waitAdditional(2);
		assertTrue(restaurantPage.isRestaurantPageLegendDisplayed(), "Restaurant legend is not displayed on restaurant page");

	}
	
	public void createRestaurant() {
		restaurantPage.populateNewRestaurantFields(true, name, phoneNumber, phoneNumber2, adress, contactPerson, numberOfMealForDeliver, numberOfMealForDiscount);
		restaurantPage.clickAddNewRestaurantButton();
		restaurantPage.clickRBrSort();
		
	}
	
	public void verifyCreatedRestaurant() {
		assertEquals(restaurantPage.getNameOfFirstRestaurantInTable(), name, "Restaurant is not created.");
	}
	
	public void selectRestaurant() {
		restaurantPage.doubleClickOnNewlyAddedRestaurant();
		
	}
	
	public void editRestaurant() {
		restaurantPage.editNewRestaurantFields(false, newName, newPhoneNumber, newPhoneNumber2, newAdress, newContactPerson, newNumberOfMealForDeliver, newNumberOfMealForDiscount);
		restaurantPage.clickRBrSort();
	}
	
	public void verifyEditedRestaurant() {
		assertEquals(restaurantPage.getNameOfFirstRestaurantInTable(), newName, "Restaurant is not edited.");
	}
	
	public void addRestaurantWithoutName() {
		restaurantPage.setNewRestaurantFieldsNameMandatory(phoneNumber, phoneNumber2, adress, contactPerson, numberOfMealForDeliver, numberOfMealForDiscount);
	}
	
	public void checkRestaurantMandatoryName() {
		assertTrue(restaurantPage.checkIsNameEmpty(), "Name is not mandatory.");
	}
	
	public void addRestaurantWithoutPhoneNumber() {
		restaurantPage.setNewRestaurantFieldsPhoneNumberMandatory(name, phoneNumber2, adress, contactPerson, numberOfMealForDeliver, numberOfMealForDiscount);
	}
	
	public void checkRestaurantPhoneNumber() {
		assertTrue(restaurantPage.checkIsPhoneNumberEmpty(), "Phone Number is not mandatory.");
	}
	
	public void userLogOff(){
		loginPage = header.clickLogOff();
    }
	
	public void verifyUserLoggedOff (){
		assertTrue(loginPage.isLoggedOff(), "User is not logged off.");
	}
}
