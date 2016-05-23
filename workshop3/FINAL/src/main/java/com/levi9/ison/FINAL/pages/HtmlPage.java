package com.levi9.ison.FINAL.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.TextField;

public class HtmlPage extends BasePage {
	
	final static String pageTitle = "";
	
	public HtmlPage(WebDriver driver) {
		super(driver, pageTitle, null);	
	}
	
	private TextField getTextField() {
		return new TextField(getDriver().findElement(By.name("user")));
	}
	
	public void enterSearchForm(String searchText) {
		getTextField().sendKeys(searchText);
	}

	public void enterSearchFormRegular(String searchText) {
		getDriver().findElement(By.name("user")).sendKeys(searchText);
	}

	public void submitSearch() {
		getTextField().submit();
	}
	
	public void submitSearchRegular() {
		getDriver().findElement(By.name("user")).submit();
	}

}
