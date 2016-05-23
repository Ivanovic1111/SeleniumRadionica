package com.levi9.ison.FINAL.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.levi9.ison.pages.BasePage;

public class GoogleHome extends BasePage{
	// set the page title and search field name by field name (name='q')
	private final static String pageTitle = "Google"; 
    private final static String SEARCH_FIELD_NAME = "q"; 

    //create an instance of google home page and set URL
	public GoogleHome(WebDriver driver) {
		super(driver, pageTitle, null);
	}

	/** Enter the Search Text in the Search form field */
	public void enterSearchForm(String searchText) {
		getDriver().findElement(By.name(SEARCH_FIELD_NAME)).sendKeys(searchText);
	}

}
