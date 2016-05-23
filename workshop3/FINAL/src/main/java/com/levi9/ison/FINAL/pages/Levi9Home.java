package com.levi9.ison.FINAL.pages;

import com.levi9.ison.pages.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class Levi9Home extends BasePage { 

	private final static String pageTitle = "Levi9 ";

	public Levi9Home(WebDriver driver) {
		super(driver, pageTitle, null);
	}
	
	public WebElement getIndustries() {
		return getDriver().findElement(By.xpath("//a[text()='Industries']"));
	}
	
	public void clickIndustries() {
		getIndustries().click();
	}
	
	public WebElement getFintech() {
		return getDriver().findElement(By.xpath("//a[text()='Fintech']"));
	}
	
	public void clickFintech() {
		getFintech().click();
	}
	
}