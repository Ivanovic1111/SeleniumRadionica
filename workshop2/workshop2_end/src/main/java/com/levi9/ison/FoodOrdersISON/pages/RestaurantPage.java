package com.levi9.ison.FoodOrdersISON.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.Button;
import com.levi9.ison.webelement.CheckBox;
import com.levi9.ison.webelement.NumericField;
import com.levi9.ison.webelement.RadioButton;
import com.levi9.ison.webelement.TextField;

public class RestaurantPage extends BasePage {

	private final static String pageTitle = "Index";
	
	
	public RestaurantPage(WebDriver driver) {
		super(driver, pageTitle, null);
	}
	
	private TextField getRestaurantNameTextField() {
		return new TextField(getWebElement(By.id("Name")));
	}	
	 
	public TextField getRestaurantPhoneNumberTextField(){
		return new TextField(getWebElement(By.id("PhoneNumber")));
	}
	
	public TextField getRestaurantPhoneNumber2TextField(){
		return new TextField(getWebElement(By.id("PhoneNumber2")));
	}
	
	public TextField getRestaurantAddressTextField(){
		return new TextField(getWebElement(By.id("Address")));
	}
	
	public TextField getRestaurantContactPersonTextField(){
		return new TextField(getWebElement(By.id("ContactPerson")));
	}
	
	public RadioButton getRadioButtonRestaurantType(){
		By restaurantTypeBy = By.xpath("//input[@id='Type'][@value='Restaurant']");
		WaitHelper.waitUntilElementIsLoaded(getDriver(), restaurantTypeBy, 10);
		return new RadioButton(getWebElement(restaurantTypeBy));
	
	}
	
	public RadioButton getRadioButtonCateringType(){
		return new RadioButton(getWebElement(By.xpath("//input[@id='Type'][@value='Catering']")));
	}

	public CheckBox getCheckBoxIsDeliver(){
		return new CheckBox(getWebElement(By.id("IsDeliver")));
	}
		
	public TextField getRestaurantNumberOfMealForDeliverTextField(){
		return new NumericField(getWebElement(By.id("spn2")));
	}
	
	public CheckBox getCheckBoxIsDiscount(){
		return new CheckBox(getWebElement(By.id("Discount")));
	}
	
	public TextField getRestaurantNumberOfMealForDiscountTextField(){
		return new NumericField(getWebElement(By.id("spn")));
	}
	
	public CheckBox getCheckBoxActiveRestaurant(){
		return new CheckBox(getWebElement(By.id("IsActive")));
	}
	
    public Button getAddRestaurantButton() {
    	return new Button(getWebElement(By.xpath("//input[@value='Add']")));
	}
    
    public void clickAddNewRestaurantButton(){
    	getAddRestaurantButton().click();
    }
    
	public TextField getEditRestaurantNumberOfMealForDiscountTextField(){
		return new NumericField(getWebElement(By.id("MealForDiscount")));
	}
	
	public TextField getEditRestaurantNumberOfMealForDeliverTextField(){
		return new NumericField(getWebElement(By.id("MealForDeliver")));
	}

    public void populateNewRestaurantFields(boolean add, String name,String phoneNumber, String phoneNumber2, String adress, String contactPerson, String numberOfMealForDeliver, String numberOfMealForDiscount ){
		getRestaurantNameTextField().sendKeys(name);
		getRestaurantPhoneNumberTextField().sendKeys(phoneNumber);
		getRestaurantPhoneNumber2TextField().sendKeys(phoneNumber2);
		getRestaurantAddressTextField().sendKeys(adress);
		getRestaurantContactPersonTextField().sendKeys(contactPerson);
		WaitHelper.waitAdditional(3); 
		getRadioButtonRestaurantType().click();
		getCheckBoxIsDeliver().check();
		if (add) {
			getRestaurantNumberOfMealForDeliverTextField().sendKeys(numberOfMealForDeliver);
		}else {
			getEditRestaurantNumberOfMealForDeliverTextField().sendKeys(numberOfMealForDeliver);
		}
		getCheckBoxIsDiscount().check();
		if (add) {
			getRestaurantNumberOfMealForDiscountTextField().sendKeys(numberOfMealForDiscount);						
		}else {
			getEditRestaurantNumberOfMealForDiscountTextField().sendKeys(numberOfMealForDiscount);
		}
		getCheckBoxActiveRestaurant().check();
	}
    
    public void addRestaurant(){
    	getAddRestaurantButton().click();
    }

    
    public boolean isRestaurantPageLegendDisplayed(){
		return getWebElement(By.xpath("//legend[contains(text(), 'Restaurant')]")).isDisplayed();		
	}
	
	public String getNameOfFirstRestaurantInTable(){
		By byName = By.xpath("//table[@id='list']//tr[2]//td[2]");
		WaitHelper.waitUntilElementIsLoaded(getDriver(), byName, 10);
		WebElement element = getDriver().findElement(byName); 
		return element.getText();
	}
	
	public Button getRBrSort() {
		return new Button (getWebElement(By.id("jqgh_list_RestaurantID")));
	}
	
	public void clickRBrSort(){
		WaitHelper.waitAdditional(1); 
		getRBrSort().click();
	}
	
	//Last added restaurant is first in list 
	public void doubleClickOnNewlyAddedRestaurant(){
		Actions action = new Actions(getDriver());
		WebElement element = getWebElement(By.xpath("//table[@id='list']//tr[2]"));
		//Double click
		action.doubleClick(element).perform();
	}

	public boolean checkIsNameEmpty(){
		return getRestaurantNameTextField().mandatory(By.id("Name"), By.xpath("//*[@id='fsBig']//span[@data-valmsg-for='Name']"), "The Name field is required.");
	}
	
	public boolean checkIsPhoneNumberEmpty(){
		return getRestaurantNameTextField().mandatory(By.id("PhoneNumber"), By.xpath("//*[@id='fsBig']//span[@data-valmsg-for='PhoneNumber']"), "The PhoneNumber field is required.");
	}
	
	public void clearNameField(){
		getRestaurantNameTextField().clear();
	}
	
	public void clearPhoneNumberField(){
		getRestaurantPhoneNumberTextField().clear();
	}
	
	public void setNewRestaurantFieldsNameMandatory(String phoneNumber, String phoneNumber2, String adress, String contactPerson, String numberOfMealForDeliver, String numberOfMealForDiscount ){
		clearNameField();
		getRestaurantPhoneNumberTextField().sendKeys(phoneNumber);
		getRestaurantPhoneNumber2TextField().sendKeys(phoneNumber2);
		getRestaurantAddressTextField().sendKeys(adress);
		getRestaurantContactPersonTextField().sendKeys(contactPerson);
		getRadioButtonRestaurantType().click();
		getCheckBoxIsDeliver().check();
		getRestaurantNumberOfMealForDeliverTextField().sendKeys(numberOfMealForDeliver);
		getCheckBoxIsDiscount().check();
		getRestaurantNumberOfMealForDiscountTextField().sendKeys(numberOfMealForDiscount);						
		getCheckBoxActiveRestaurant().check();
		getAddRestaurantButton().click();
	}
	
	public void setNewRestaurantFieldsPhoneNumberMandatory(String name, String phoneNumber2, String adress, String contactPerson, String numberOfMealForDeliver, String numberOfMealForDiscount ){
		getRestaurantNameTextField().sendKeys(name);
		clearPhoneNumberField();
		getRestaurantPhoneNumber2TextField().sendKeys(phoneNumber2);
		getRestaurantAddressTextField().sendKeys(adress);
		getRestaurantContactPersonTextField().sendKeys(contactPerson);
		getRadioButtonRestaurantType().click();
		getCheckBoxIsDeliver().check();
		getRestaurantNumberOfMealForDeliverTextField().sendKeys(numberOfMealForDeliver);
		getCheckBoxIsDiscount().check();
		getRestaurantNumberOfMealForDiscountTextField().sendKeys(numberOfMealForDiscount);						
		getCheckBoxActiveRestaurant().check();
		getAddRestaurantButton().click();
	}
	
	public void editNewRestaurantFields(boolean add, String newName, String newPhoneNumber, String newPhoneNumber2, String newAdress, String newContactPerson,
			String newNumberOfMealForDeliver, String newNumberOfMealForDiscount){
		add = false;
		//populateNewRestaurantFields(add, newName, newPhoneNumber, newPhoneNumber2, newAdress, newContactPerson, newNumberOfMealForDeliver, newNumberOfMealForDiscount);
		getRestaurantNameTextField().sendKeys(newName);
		getRestaurantPhoneNumberTextField().sendKeys(newPhoneNumber);
		getRestaurantPhoneNumber2TextField().sendKeys(newPhoneNumber2);
		getRestaurantAddressTextField().sendKeys(newAdress);
		getRestaurantContactPersonTextField().sendKeys(newContactPerson);
		getCheckBoxIsDeliver().check();
		if (add) {
			getRestaurantNumberOfMealForDeliverTextField().sendKeys(newNumberOfMealForDeliver);
			}else {
				getEditRestaurantNumberOfMealForDeliverTextField().sendKeys(newNumberOfMealForDeliver);
			}
			getCheckBoxIsDiscount().check();
			if (add) {
				getRestaurantNumberOfMealForDiscountTextField().sendKeys(newNumberOfMealForDiscount);						
			}else {
				getEditRestaurantNumberOfMealForDiscountTextField().sendKeys(newNumberOfMealForDiscount);
			}
			getCheckBoxActiveRestaurant().check();
		clickSubmitEditRestaurant();
		refresh();
	}
	
	public void clickSubmitEditRestaurant(){
		getWebElement(By.id("sData")).click();
	}
	
	
}
