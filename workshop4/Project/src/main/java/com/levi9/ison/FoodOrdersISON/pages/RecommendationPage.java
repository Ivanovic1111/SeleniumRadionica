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
import com.levi9.ison.webelement.TextArea;

public class RecommendationPage extends BasePage {
	
	public RecommendationPage(WebDriver driver) {
		super(driver, null, null);
	}
	
	public boolean checkIfOnRecommendationPage(){
		return getWebElement(By.xpath("//div[@id='gview_list']//span[contains(text(), 'Recommendation')]")).isDisplayed();
	}
	
	private TextArea getCommentTextArea() {
		return new TextArea(getWebElement(By.id("Comment")));
	}
	
	private Button getAddRecommendationButton(){
		return new Button(getWebElement(By.xpath("//div[@id='addRecommendation']//input[@id='submit']")));
	}
	
	public void setRecommendationFields(String comment){
		setRandomMealSelectOption();
		clickRandomRadioButton();
		getCommentTextArea().sendKeys(comment);
		getAddRecommendationButton().click();
	}
	
	public void setRandomMealSelectOption(){
		Random r = new Random();
		Select select = new Select(getDriver().findElement(By.id("Id")));
		List<WebElement> selectOptions = select.getOptions();
		int rand = r.nextInt(selectOptions.size());
		selectOptions.get(rand).click();
	}
	
	public void clickRandomRadioButton(){
		Random r = new Random();
		List<WebElement> radios = getDriver().findElements(By.name("Rate"));
		int random = r.nextInt(radios.size());
		radios.get(random).click();
	}

	public String getAddedRecommendationComment(){
		By by = By.xpath("//table[@id='list']//tr[2]/td[@aria-describedby='list_Comment']");
		WaitHelper.waitUntilElementIsLoaded(getDriver(), by, 30);
		WebElement element = getWebElement(by);
		return element.getText();
	}

}
