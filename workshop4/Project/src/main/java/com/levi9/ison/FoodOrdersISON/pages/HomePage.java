package com.levi9.ison.FoodOrdersISON.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.Button;
import com.levi9.ison.webelement.CheckBox;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver, "Index", null);
	}
	
    private Button getCreateMenuOkButton() {
    	return new Button(getWebElement(By.xpath("//div[@id='dialog']//following::button[@role='button'][1]")));
	}
    
    public void clickCreateMenuOkButton(){
    	WaitHelper.waitUntilElementIsLoaded(getDriver(), By.xpath("//div[@id='dialog']//following::button[@role='button'][1]"), 10);
    	getCreateMenuOkButton().click();
    }
	
	private CheckBox getCheckBoxIsActive(){
		return new CheckBox(getWebElement(By.xpath("//*[@id='radioFood']//input[@value='All']")));
	}
	
	public void checkAllFoodCheckBox(){
		getCheckBoxIsActive().check();
	}
	
	
	
	public boolean checkCreatedMenuMessage(){
		if(getWebElement(By.xpath("//div[@id='dialog']//b")) != null){
			return true;
		} else {
			return false;
		}
	}

	public String homePageMenuHighlighted(){
		WebElement el = getDriver()/*driver*/.findElement(By.xpath("//*[@id='tabMenu']//ul//li[@class='highlight']//a"));	 
		return el.toString();
	}
	
}
