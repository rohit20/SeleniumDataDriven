package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseTest;

public class SignUpPage extends BaseTest {
	
	@FindBy(id="createAccountSubmit")
	WebElement NewAccount;
	
	@FindBy(xpath= "//input[@name='customerName']")
	WebElement FirstName;
	

	@FindBy(xpath= "//input[@id='ap_phone_number']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//input[@name='secondaryLoginClaim']")
	WebElement Email;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement Continue;
	
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickSignup() {
		NewAccount.click();
	}

	public void EnterSignInDetails(String fname, String phn, String email, String password ) {
		
		FirstName.sendKeys(fname);
		PhoneNumber.sendKeys(phn);
		Email.sendKeys(email);
		Password.sendKeys(password);
		Continue.click();
	}
	
}
