package com.levi9.ison.FoodOrdersISON.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.Button;
import com.levi9.ison.webelement.CheckBox;
import com.levi9.ison.webelement.Link;
import com.levi9.ison.webelement.TextField;


public class NewMeal extends BasePage {

	private final static String pageTitle = "AddNewMeal";
	Random r = new Random();
	
	
	public NewMeal(WebDriver driver) {
		super(driver, pageTitle, null);
	}
	
	
    public boolean isMealPageLegendDisplayed(){
		return getWebElement(By.xpath("//legend[contains(text(), 'Meal')]")).isDisplayed();		
	}
    
	public void clickRBrSort(){
		WebElement we = getWebElement(By.id("jqgh_list_FoodID"));
		we.click();
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
	
	
	
	public void editNewMeal(String newName, String newPrice, String newDescription){
		populateNewMealFields(newName, newPrice, newDescription);
		getWebElement(By.id("sData")).click();
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
	
	private Link getBackToDailyMenyLink(){
		return new Link(getWebElement(By.xpath("//*[@id='link']/a")));
	}
	
	public HomePage clickBackToDailyMenyLink(){
		getBackToDailyMenyLink().click();
		return new HomePage(getDriver());
	}
	
	//Last added meal is first in list 
	public void doubleClickOnNewlyAddedMeal(){
		Actions action = new Actions(getDriver());
		WebElement element = getWebElement(By.xpath("//table[@id='list']//tr[2]"));
		//Double click
		action.doubleClick(element).perform();
	}
 
	
	public String getLastAddedMealName(){
		WebElement element = getWebElement(By.xpath("//table[@id='list']//tr[2]//td[2]")); 
		return element.getText();
	}
	
	public boolean isTrCalorieExist(){
		  return getWebElement(By.xpath("//tr[@id='tr_Calorie']")).isDisplayed();
	}
	
	//public boolean validate(By errorMessageBy, String errorMessageText, By validateFieldLocator, String filePath, String sheetName, int numberOfFields)
	public boolean validatePriceUsingTextFile(String sheetPath, String sheetName, int numOfSheetRows) {
		return getMealPriceTextField().validate(By.xpath("//span[@class='field-validation-error']//span[@for='Price']"), "The field Price must be a number.",
				By.id("Price"), sheetPath, sheetName, numOfSheetRows);
	}
		
//////////////////////////////////////#########################################////////////////////////////////

	public String getAddNewMealPageLegend(){
		WebElement we = getDriver().findElement(By.xpath("//legend[contains(text(), 'Meal')]"));
		return we.getText();
	}
	
	public void setMealPriceField(int value){
		WebElement we = getDriver().findElement(By.id("Price"));
		String price = Integer.toString(value);
		we.sendKeys(price);
	}
	
	public void setMealDescriptionField(String value){
		WebElement we = getDriver().findElement(By.id("Description"));
		we.sendKeys(value);
	}
	
	public void setMealActiveCheckBox(){
		WebElement we = getDriver().findElement(By.id("IsActive"));
		we.click();
	}
	
	public void setMealDailyCheckBox(){
		WebElement we = getDriver().findElement(By.id("IsDaily"));
		we.click();
	}
	

	public void clickLeteciRestoranButton(){
		WebElement we = getDriver().findElement(By.xpath("//*[@id='3']/button"));
		we.click();
	}
	
	public void checkActiveCheckbox(){
	  WebElement we = getDriver().findElement(By.id("OnlyActive"));
	  if(we.getAttribute("checked") == null){
		  we.click();
	  }
	}
	
	public void uncheckActiveCheckbox(){
	  WebElement we = getDriver().findElement(By.id("OnlyActive"));
	  if(we.getAttribute("checked") == "checked"){
		  we.click();
	  }
	}
	
	public void uncheckDailyOnlyCheckbox(){
	  WebElement we = getDriver().findElement(By.id("OnlyDaily"));
	  if(we.getAttribute("checked") == "checked"){
		  we.click();
	  }
	}
	
	public void editNewMealFields(String newName, int newPrice, String newDescription){
		editMealName(newName);
		editMealDescription(newDescription);
		editMealPrice(newPrice);
		clickSubmitEditMeal();
	}
	
	public void editMealName(String newName){
		WebElement we = getDriver().findElement(By.xpath("//td//input[@id='Name']"));
		we.clear();
		we.sendKeys(newName);
	}
	
	public void editMealPrice(int value){
		WebElement we = getDriver().findElement(By.xpath("//td//input[@id='Price']"));
		System.out.println(we.getText());
		we.clear();
		String price = Integer.toString(value);
		we.sendKeys(price);
	}
	
	public void editMealDescription(String newDescription){
		WebElement we = getDriver().findElement(By.xpath("//td//input[@id='Description']"));
		we.clear();
		we.sendKeys(newDescription);
	}
	
	public void clickSubmitEditMeal(){
		getDriver().findElement(By.xpath("//a[@id='sData']")).click();
	}
	

	public boolean priceFieldIsInvalid(){
		WebElement we = getWebElement(By.xpath("//span[@class='field-validation-error']//span[@for='Price']"));
		System.out.println(we.getText());
		  if(we != null && "The field Price must be a number.".equals(we.getText())){
			  return true;
		  }else{
			  return false;
		  }
	}
	
	public void clickSearchMealButton(){
		getWebElement(By.xpath("//div[@id='addMealDiv']//td[@id='search_list']//span")).click();
	}
	
	// Search
	public boolean searchPageIsDisplayed(){
		WebElement we = getWebElement(By.xpath("//*[@id='searchmodfbox_list']"));
		  if(we == null){
			  return false;
		  }else{
			  return true;
		  }
	}
	
	public void pickNameFromSearchBox(){
		getWebElement(By.xpath("//*[@id='fbox_list']//select//option[@value='Name']")).click();
	}
	
	public void setMealNameForSearch(String name){
		WebElement we = getDriver().findElement(By.xpath(/*"//input[@id='jqg4']"*/"//*[@id='searchcntfbox_list']//td[@class='data']//input"));
		we.clear();
		we.sendKeys(name);
	}
	
	public void clickFindMeal(){
		getWebElement(By.xpath("//a[@id='fbox_list_search']")).click();
	}
	
	public void clickExitSearchBox(){
		getWebElement(By.xpath("//*[@id='searchhdfbox_list']/a")).click();
	}
	
	public void findMealByName(String mealName){
		pickNameFromSearchBox();
		setMealNameForSearch(mealName);
		clickFindMeal();clickFindMeal();
		clickExitSearchBox();
	}

}
