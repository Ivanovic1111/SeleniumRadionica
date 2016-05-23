package com.levi9.ison.FoodOrdersISON.pages;

import com.levi9.ison.pages.BasePage;

import org.openqa.selenium.WebDriver;


public class Levi9Home extends BasePage { 

	private final static String pageTitle = "Levi9 ";

	public Levi9Home(WebDriver driver) {
		super(driver, pageTitle, null);
	}
	
}