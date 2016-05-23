package com.levi9.ison.FoodOrdersISON.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.levi9.ison.pages.BasePage;
import com.levi9.ison.webelement.Button;
import com.levi9.ison.webelement.PasswordField;
import com.levi9.ison.webelement.TextField;


public class LoginPage extends BasePage { 

	private final static String pageTitle = "Log In";
	
	public LoginPage(WebDriver driver) {
		super(driver, pageTitle, null);
	}

	private TextField getUsername() {
		return new TextField(getWebElement(By.id("UserName")));
	}
	
    private PasswordField getPassword() {
    	return new PasswordField(getWebElement(By.id("Password")));
	}

    private Button getLoginButton() {
    	return new Button(getWebElement(By.id("loginButton")));
	}
    
    public HomePage login(String username, String password){
    	getUsername().sendKeys(username);
    	getPassword().sendKeys(password);
        getLoginButton().click();
		return new HomePage(getDriver());
    }

}