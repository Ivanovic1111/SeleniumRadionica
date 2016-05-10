package com.levi9.ison.FoodOrdersISON.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.Button;
import com.levi9.ison.webelement.CheckBox;
import com.levi9.ison.webelement.TextField;


public class NewMeal extends BasePage {

	private final static String pageTitle = "AddNewMeal";
	Random r = new Random();
	
	
	public NewMeal(WebDriver driver) {
		super(driver, pageTitle, null);
	}
	
	
    public boolean isMealPageLegendDisplayed(){
		By by = By.xpath("//legend[contains(text(), 'Meal')]");
		WaitHelper.waitUntilElementIsLoaded(getDriver(), by, 10);
		return getWebElement(by).isDisplayed();		
	}
    
	public void clickRBrSort(){
		WebElement we = getWebElement(By.id("jqgh_list_FoodID"));
		we.click();
	}
    
	public String getNameOfFirstMealInTable(){
		By byMealInTable = By.xpath("//table[@id='list']//tr[2]//td[2]");
		WaitHelper.waitUntilElementIsLoaded(getDriver(), byMealInTable, 10);
		WebElement we = getWebElement(byMealInTable); 
		return we.getText();
	}
	
	private TextField getMealNameTextField() {
		return new TextField(getWebElement(By.id("Name")));
	}	
	
	private TextField getMealPriceTextField() {
		return new TextField(getWebElement(By.id("Price")));
	}	
	
	private TextField getMealDescriptionTextField() {
		return new TextField(getWebElement(By.id("Description")));
		
	}	
	
	public CheckBox getCheckBoxIsActive(){
		return new CheckBox(getWebElement(By.id("IsActive")));
	}
	
	public CheckBox getCheckBoxIsDaily(){
		return new CheckBox(getWebElement(By.id("IsDaily")));
	}
	
	public Button getAddNewMealButton(){
		return new Button(getWebElement(By.xpath("//input[@value='Add']")));
	}
	
	public void populateNewMealFields(String name, String price, String description){
		getMealNameTextField().sendKeys(name);	
		setRandomTypeSelectOption();		
		getMealPriceTextField().sendKeys(price);
		getMealDescriptionTextField().sendKeys(description);
		setRandomCalorieSelectOption();
		getCheckBoxIsActive().check();
	}
	
	public void addNewMeal(){
		getAddNewMealButton().click();
		getCheckBoxOnlyDaily().uncheck();
		getCheckBoxOnlyActive().check();
	}
	
	public Select getTypeOfMealSelect(){
		return new Select(getWebElement(By.id("Type")));
	}
	
	public void setRandomTypeSelectOption(){
		List<WebElement> selectOptions = getTypeOfMealSelect().getOptions();
		int rand = r.nextInt(selectOptions.size());
		selectOptions.get(rand).click();
	}
	
	public Select getCalorieOfMealSelect(){
		return new Select(getWebElement(By.id("Calorie")));
	}
	
	public void setRandomCalorieSelectOption(){
		List<WebElement> selectOptions = getCalorieOfMealSelect().getOptions();
		int rand = r.nextInt(selectOptions.size());
		selectOptions.get(rand).click();
	}
	
	public CheckBox getCheckBoxOnlyActive(){
		return new CheckBox(getWebElement(By.id("OnlyActive")));
	}
	
	public CheckBox getCheckBoxOnlyDaily(){
		return new CheckBox(getWebElement(By.id("OnlyDaily")));
	}
	
	//public boolean validate(By errorMessageBy, String errorMessageText, By validateFieldLocator, String filePath, String sheetName, int numberOfFields)
	public boolean validatePrice(String sheetPath, String sheetName, int numOfSheetRows) {
		return getMealPriceTextField().validate(By.xpath("//span[@class='field-validation-error']//span[@for='Price']"), "The field Price must be a number.",
				By.id("Price"), sheetPath, sheetName, numOfSheetRows);
	}
	
}
