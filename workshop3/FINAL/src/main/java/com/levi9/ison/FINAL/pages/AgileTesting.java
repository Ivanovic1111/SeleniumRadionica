package com.levi9.ison.FINAL.pages;

import com.levi9.ison.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AgileTesting extends BasePage { 

	private final static String pageTitle = "FinTech";

	public AgileTesting(WebDriver driver) {
		super(driver, pageTitle, null);
	}
	
	public  String getBreadcrumbText() {
		return getDriver().findElement(By.xpath("//a[@title='FinTech']")).getText();
	}
	
}