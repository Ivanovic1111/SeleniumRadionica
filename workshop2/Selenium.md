# Introducing Selenium
**Selenium automates browsers.**

Selenium is suite of software tools with purpose to satisfy different testing needs and to support test automation.  

It has four components:

- Selenium IDE
- Selenium Remote Control (RC)
- Selenium WebDriver
- Selenium Grid

![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop2/img/SeleniumSuite.png)

## Selenium WebDriver architecture

Selenium WebDriver architecture is divided into three parts:

- Language bindings
- Selenium WebDriver API
- Drivers

![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop2/img/SeleniumWebdriverArchitecture.png)

## Locating UI elements (Web elements)
Each of the language expose a findElement and findElements method.

The *find* method take a locator or query object called **By**. By strategies are listed below: 

**By ID**

IDs are the preferred way to locate elements on a page for 2 main reasons:

- supposed to be unique on an HTML page. This makes ids a very explicit and reliable way to locate elements on the page. 
- ID locators are the fastest type of locator in Selenium.


    driver.findElement(By.id("UserName")):

**By Class Name**

“Class” in this case refers to the attribute on the DOM element. Often in practical use there are many DOM elements with the same class name, thus finding multiple elements becomes the more practical option over finding the first element.

    driver.findElements(By.className("field-validation-valid"));

**By Name**

Find the input element with matching name attribute.

    driver.findElement(By.name("UserName"));

**By Tag Name**

The DOM Tag Name of the element.

    driver.findElement(By.tagName("fieldset"));

**By Link Text**

This locator identifies links by the text in them. To click the hyperlink, use By.linkText() locator:

    driver.findElement(By.linkText("Sign In"));

**By Partial Link Text**

Find the link element with partial matching visible text.

    driver.findElement(By.partialLinkText("Sign In"));

**By CSS**

CSS locators can be used to identify a large number of elements on a page.

Beware that not all browsers were created equal, some css that might work in one version may not work in another.

    driver.findElement(By.cssSelector("#food span.dairy.aged"));

**By XPATH**

XPath is a very powerful language to express which element to identify. If you use it correctly, it can produce very reliable and low maintenance locators, but if you use it incorrectly, it can create very brittle test cases.

    driver.findElement(By.xpath("//input[@id='UserName']"));

# PageObject pattern
## Introduction

Page Object pattern is a design pattern popular in test automation for enhancing test maintenance and reducing code duplication.

- One of the most effective approaches for creating a test automation framework

- A page object class serves as an interface to a web page in the **A**pplication **U**nder **T**est (represent a model with properties and behavior)

- Tests use methods of this page object class whenever interaction with the page of the UI is needed (without knowing technical implementation such as locators used to identify elements on the page, layout etc.)

## Advantages

- Object oriented programming pattern
- Code maintainability
- Effective chaining
- Readable scripts
- Support for different programming languages

![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop2/img/pageobjectpattern.png)

## Basic rules of PO pattern

- Page object class should never make verification or assertion
- Test class should never contains locators
- Read data from property files and use it in test class (not in page object class)
- Page object doesn't necessarily need to represent an entire page. Could be used to represent components on the page. It may represent a section that appears many times within a site or page, such as site navigation
- Try not to expose the internal details of the page (web elements, driver... should not be public)
- Good logging support is important in order to be able to track why a test failed
    

# Automation Framework


Main goals:

- To have ability to easily create simple automated tests that use the framework
- Separate cosmetic application changes from the tests in order to avoid update of all tests
- Make tests readable (put complexity into the framework)

Each layer of the framework only interacts with the layer immediately below it.

![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop2/img/frameworkArchitecture.png)

# Architecture

![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop2/img/isonArchitecture.png)

**Configuration layer**

- environment
- database
- email
- validate
- common data

**Helpers and utilities**

Some of helpers provided by framework:

- Mandatory Helper
- Validation Helper
- Wait Helper
- File Handler
- Database Helper
- Excel Helper

Some of elements provided by framework:

-  TextField
-  NumericField
-  TextArea
-  CheckBox
-  Button
-  Link
-  Upload

**Task 1: Write test for add new Restaurant based on scenario written in Workshop1**  

    Scenario:  Add a new restaurant
    Given user is logged into application for Restaurant story
    And user is on Restaurant page
    When user populates new restaurant details
    Then restaurant is in the list
    When user clicks Logs Off in Restaurant scenario
    Then user is logged off successfully from Restaurant scenario

Steps:

1. Open browser and log into the application using method from LoginPage
2. Click on Restaurant link
3. Fill all mandatory fields to create new restaurant, click on Add button and sort restaurant in the table 
4. Assert the restaurant is created
5. Log off from Restaurant
6. Assert user is logged off from Restaurant

## Introduce MandatoryHelper

Mandatory helper enables validation for mandatory fields. It supports AJAX.

	 /**
	 *	Check if element is mandatory by checking error message when input field is empty (submit by FormSubmitter).
	 * 
	 * @param mandatoryFieldLocator the element under test locating mechanism
	 * @param errorMessageBy the error message locating mechanism
	 * @param errorMessageText the mandatory message text
	 * @param formSubmitter
	 * @return true, if mandatory message is shown at specified location and text is correct 
	 */
	public boolean mandatory(By mandatoryFieldLocator, By errorMessageBy, String errorMessageText, FormSubmitter formSubmitter) {
		LOGGER.debug("Checking if element is mandatory");
		
		WebElement elementInTest = driver.findElement(mandatoryFieldLocator);
		formSubmitter.submit(elementInTest);
		try {
			WebElement tempErrorMessageElement = driver.findElement(errorMessageBy);
			if (!tempErrorMessageElement.isDisplayed() || (errorMessageText != null && !errorMessageText.equals(tempErrorMessageElement.getText()))) {
				return false;
			} 
		}
		catch (NoSuchElementException e) {
			final String msg = "Error message element '" + errorMessageBy + "' is not found in the page";
			LOGGER.error(msg, e);
			throw new RuntimeException(msg, e);
		}
		return true;
	} 

How to use it?

	public boolean checkIsNameEmpty(){
		return getRestaurantNameTextField().mandatory(By.id("Name"), By.xpath("//*[@id='fsBig']//span[@data-valmsg-for='Name']"), "The Name field is required.");
	}

**Task 2: Write test to verify that Name of restaurant is mandatory based on scenario written in Workshop1**

    Scenario:  Add a new restaurant check name is mandatory
    Given user is logged into application for Restaurant story
    And user is on Restaurant page
    When user populates all new restaurant details except name field
    Then the name field is required message is displayed
    When user clicks Logs Off in Restaurant scenario
    Then user is logged off successfully from Restaurant scenario

## Introduce ValidationHelper ##

Validation helper enables validation of text input fields. It supports AJAX.

How to use it?

- Create excel with type of locator, locator value, value of field and type of field for all fields on the page except element under test
- Call validate method and pass necessary data (path to the excel, excel sheet name, number of page elements)

Example:

	
	//public boolean validate(By errorMessageBy, String errorMessageText, By validateFieldLocator, String filePath, String sheetName, int numberOfFields)
	public boolean validatePrice(String sheetPath, String sheetName, int numOfSheetRows) {
		return getMealPriceTextField().validate(By.xpath("//span[@class='field-validation-error']//span[@for='Price']"), "The field Price must be a number.",
				By.id("Price"), sheetPath, sheetName, numOfSheetRows);
	}

**Task 3: Write test to validate price when add new meal based on scenario written in Workshop1**

    Scenario:  Add a new meal validate price
    Given user is logged into application for Meal scenario
    And user is on Meal page
    When user populates all fields and for price types invalid value
    Then the field price must be a number message is displayed
    When user clicks Logs Off in Meal scenario
    Then user is logged off successfully from Meal scenario

**Homework:**

1. Write test for add new active meal based on scenario from Workshop1
2. Write test for edit restaurant based on scenario from Workshop1
3. Write test for check phone number is mandatory when add a new restaurant based on scenario from Workshop1