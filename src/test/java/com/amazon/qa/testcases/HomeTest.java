package com.amazon.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseTest;
//import com.amazon.qa.base.HomeTest;
import com.amazon.qa.pages.Homepage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SignUpPage;
import com.amazon.qa.utils.TestUtil;

public class HomeTest extends BaseTest {
	Homepage homepage;
	LoginPage loginpage;
	SignUpPage signuppage;
	Logger log = Logger.getLogger(HomeTest.class);
	
	String sheetName="NewRegistration";
	

	public HomeTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage= new Homepage();
		loginpage= new LoginPage();
		signuppage = new SignUpPage();
		
	}

	@Test(priority=1)
	public void HomepageValidation() {
		String title=homepage.ValidateTitle();
		log.info("VerifyingTitle");
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	
	@DataProvider
	public Object[][]  getRegistrationData() {
		
		Object data[][]=TestUtil.getTestdata(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider="getRegistrationData")
	public void clickOnSignIn(String FirstName, String Mobile, String Email, String Password) {

		homepage.SignIn();
		log.info("Clicking SignIN");
		loginpage.VerifyLoginPageisdisplayed();
		log.info("verify loginis displayed");
		signuppage.clickSignup();
		log.info("Click  New Account");
		
		signuppage.EnterSignInDetails(FirstName,Mobile,Email,Password);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
