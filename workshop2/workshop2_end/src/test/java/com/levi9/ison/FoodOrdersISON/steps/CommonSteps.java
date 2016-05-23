package com.levi9.ison.FoodOrdersISON.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.levi9.ison.FoodOrdersISON.pages.HomePage;
import com.levi9.ison.tests.BaseTest;

public class CommonSteps extends BaseTest implements IInvokedMethodListener {

    private static String profileAttribute = "";
	private static final Logger LOGGER = Logger.getLogger(CommonSteps.class);
	
	protected WebDriver driver;
	protected HomePage homePage;
		
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		LOGGER.debug("BEGINNING: org.stng.jbehave.LocalWebDriverListener.beforeInvocation");
	     
        // get browser name specified in the TestNG XML test suite file
        String profile = method.getTestMethod().getXmlTest().getLocalParameters().get("profile").toString();
        LOGGER.debug("Profile [beforeInvocation]: " + profile);
        profileAttribute = profile;
	}


	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	public String getProfileAttribute() {
		return profileAttribute;
	}
	
	public void setUp() {
	  LOGGER.info ("ProfileSetup " + getProfileAttribute());
	  super.setUp(getProfileAttribute());
	  driver = getDriver();
	  LOGGER.info("set up initialized");
	  LOGGER.info("story begins...");
	}
		
	public void closeDriver() throws Exception {
		super.tearDown();
		LOGGER.info("story finished.");
	}
}
