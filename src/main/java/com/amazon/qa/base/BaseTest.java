package com.amazon.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.utils.TestUtil;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;


	public BaseTest() {

		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/amazon/qa/config/config.properties" );
			prop.load(ip);

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browserName= prop.getProperty("browser");
	
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator + "Drivers"+ File.separator + "chromedriver");
			driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ File.separator + "Drivers"+ File.separator + "geckodriver");
			driver= new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator + "Drivers"+ File.separator + "chromedriver");
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	}
