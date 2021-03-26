package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseTest;

public class Homepage extends BaseTest {
	
	//PageFactory
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement HelloSignIn;
	
	//Click SignIn
	@FindBy(xpath="//span[@class='nav-action-inner']")
	WebElement SignIn;	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	//Validate Title
	public String ValidateTitle() {
		return driver.getTitle();
	}
	
	//Go to SignIn and Click SignIn
	public void SignIn() {
		Actions action = new Actions(driver);
		action.moveToElement(HelloSignIn).perform();
		
		SignIn.click();
	
	}
}
