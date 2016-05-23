package com.levi9.ison.FoodOrdersISON.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.Link;

public class Header extends BasePage {
 	
	public Header(WebDriver driver) {
		super(driver, null, null);
	}
	
	private Link getRecommendationHeaderLink(){
		return new Link (getWebElement(By.xpath("//a[@href='/Recommendation']")));
	}
	
	public RecommendationPage clickRecommendationHeaderLink(){
		getRecommendationHeaderLink().click();
		return new RecommendationPage(getDriver());
	}
	
	private Link getAddNewMealHeaderLink(){
		return new Link (getWebElement(By.xpath("//*[@id='tabMenu']//a[text()='Add new meal']")));
	}
	
	public NewMeal clickAddNewMealHeaderLink(){
		getAddNewMealHeaderLink().click();
		return new NewMeal(getDriver());
	}
	
	private Link getACreateMenuHeaderLink(){
		return new Link(getWebElement(By.xpath(".//*[@id='tabMenu']//a[contains(text(),'Create Menu')]")));
	}
	
	public HomePage clickCreateMenuHeaderLink(){
		getACreateMenuHeaderLink().click();
		return new HomePage(getDriver());
	}
	
	private WebElement getNavList(){
		return getWebElement(By.xpath(".//*[@id='navlist']"));
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
	
	private WebElement getAddNewMealLink(){
		return getWebElement(By.xpath("//*[@id='tabMenu']//a[text()='Add new meal']"));
	}
	
	public NewMeal clickAddNewMealLink(){
		getAddNewMealLink().click();
		return new NewMeal(getDriver());
	}

}
