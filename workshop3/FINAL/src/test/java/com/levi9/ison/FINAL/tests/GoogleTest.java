package com.levi9.ison.FINAL.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.levi9.ison.FINAL.pages.GoogleHome;

import com.levi9.ison.tests.BaseTest;

public class GoogleTest extends BaseTest {
	private GoogleHome googleHome;
	private static final String URL = "http://www.google.com";

	@BeforeMethod
	public void setUp(){
		//initialize environment, webdriver
		super.setUp();
		//create an instance of page, in this case GoogleHome page
		googleHome = new GoogleHome(getDriver());
	}
	
	@Test
	public void google() {
		//go to google home page (URL is already set in GoogleHome page class)
		googleHome.open(URL);
		//call method from GoogleHome page class which will enter "test" in the main search form
		googleHome.enterSearchForm("test");
	}
	
	@AfterMethod
	public void closeDriver() throws Exception {
		super.tearDown();
	}
}
