package com.levi9.ison.FoodOrdersISON.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.Link;

public class Header extends BasePage {
 	
	public Header(WebDriver driver) {
		super(driver, null, null);
	}
	
	private Link getRestaurantHeaderLink(){
		By restaurantBy = By.xpath("//a[@href='/Restaurant']");
		WaitHelper.waitUntilElementIsLoaded(getDriver(), restaurantBy, 10);
		return new Link(getWebElement(restaurantBy));
	}
	
	public RestaurantPage clickRestaurantHeaderLink(){
		getRestaurantHeaderLink().click();
		return new RestaurantPage(getDriver());
	}
	
	private Link getAddNewMealHeaderLink(){
		By mealBy = By.xpath("//a[@href='/Food/AddNewMeal']");
		WaitHelper.waitUntilElementIsLoaded(getDriver(), mealBy, 10);
		return new Link (getWebElement(mealBy));
	}
	
	public NewMeal clickAddNewMealHeaderLink(){
		getAddNewMealHeaderLink().click();
		return new NewMeal(getDriver());
	}
	
	private Link getACreateMenuHeaderLink(){
		return new Link(getWebElement(By.xpath("//a[text()='Create Menu']")));
	}
	
	public HomePage clickCreateMenuHeaderLink(){
		getACreateMenuHeaderLink().click();
		return new HomePage(getDriver());
	}
	
	private WebElement getNavList(){
		return getWebElement(By.id("navlist"));
	}
	
	public boolean isNavListExist(){
		if (getNavList()==null) {
			return false;
		}return true;
	}
	
	private WebElement getLogOffLink(){
		return getWebElement(By.linkText("Log Off"));
	}
	
	public LoginPage clickLogOff(){
		getLogOffLink().click();
		return new LoginPage(getDriver());
	}
	
}
