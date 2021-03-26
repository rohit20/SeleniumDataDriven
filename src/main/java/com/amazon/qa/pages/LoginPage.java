package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(xpath="//h1[@class='a-spacing-small']")
	WebElement SignInTitle;
	
	
	
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void VerifyLoginPageisdisplayed() {
		SignInTitle.isDisplayed();
	}

}
