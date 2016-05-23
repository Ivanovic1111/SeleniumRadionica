package com.levi9.ison.FINAL.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.levi9.ison.FINAL.pages.HtmlPage;

import com.levi9.ison.tests.BaseTest;

public class HtmlTest extends BaseTest{
	private HtmlPage gsp;
	private static final String URL = "http://www.w3schools.com/html/html_forms.asp";
	
	@BeforeMethod
	public void setUp() {
		super.setUp();
		gsp = new HtmlPage(getDriver());
	}
	
	@Test
	public void test() {
		gsp.open(URL);
		gsp.enterSearchForm("da");
		gsp.submitSearch();
	}
	
	@AfterMethod
	public void closeDriver() throws Exception {
		super.tearDown();
	}
}
