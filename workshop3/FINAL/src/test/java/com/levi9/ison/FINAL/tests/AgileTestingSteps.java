package com.levi9.ison.FINAL.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.levi9.ison.FINAL.pages.AgileTesting;
import com.levi9.ison.FINAL.tests.AgileTestingSteps;
import com.levi9.ison.FINAL.pages.Levi9Home;
import com.levi9.ison.helpers.WaitHelper;

public class AgileTestingSteps extends CommonSteps {

	Random random = new Random();
	private Levi9Home levi9Home;  
	private AgileTesting agileTesting;
	private static final String url = "http://www.levi9.com/";
	
	@Given("user opens application")
	public void logIn() {
		levi9Home = new Levi9Home(driver);
		driver.manage().deleteAllCookies();
		
		levi9Home.open(url);
	}
	
	@When("user clicks on Services menu and Agile Testing")
	public void clickCreateNewConsignee() {
		levi9Home.clickIndustries();
		WaitHelper.waitAdditional(2);
		levi9Home.clickFintech();
		WaitHelper.waitAdditional(2);
	}

	@Then("user is on Agile Testing page")
	public void checkConsigneePage() {
		agileTesting = new AgileTesting(driver);
		assertEquals(agileTesting.getTitle(), agileTesting.getBreadcrumbText());

	}
	
}
