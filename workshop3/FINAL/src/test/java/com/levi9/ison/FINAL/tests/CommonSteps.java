package com.levi9.ison.FINAL.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;

import com.levi9.ison.tests.BaseTest;

public class CommonSteps extends BaseTest implements IInvokedMethodListener {

    private static String profileAttribute = "";
	private static final Logger LOGGER = Logger.getLogger(CommonSteps.class);
	
	protected WebDriver driver;
		
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		  // get browser name specified in the TestNG XML test suite file
		  String profile = method.getTestMethod().getXmlTest().getLocalParameters().get("profile").toString();
          profileAttribute = profile;
          System.out.println("profileAttribute: " + profileAttribute); 
	}


	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	public String getProfileAttribute() {
		return profileAttribute;
	}
	
	@BeforeStories
	public void setUp() {
		LOGGER.info ("ProfileSetup: " + getProfileAttribute());
		super.setUp(getProfileAttribute());
		driver = getDriver();
		LOGGER.info("set up initialized");
		LOGGER.info("story begins...");
		
	}
		
	@AfterStories
	public void closeDriver() throws Exception {
		super.tearDown();
		LOGGER.info("story finished.");
	}
}
