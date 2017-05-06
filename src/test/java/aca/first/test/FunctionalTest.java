package aca.first.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.LoginPage;

public class FunctionalTest {
	
	WebDriver driver;
	
	//annakhach7@mail.ru
	//annakhach7
//	
//	7lilas@mail.ru
//	10janlil
	
	@BeforeMethod
		public void logIn(){
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 driver = new ChromeDriver(options);
		 
		 driver.get("https://www.facebook.com");
		 
		 LoginPage loginPage = new LoginPage(driver);
		 
		 loginPage.setEmail("meskar7@mail.ru");
		 loginPage.setPassword("karMes71");
		 HomePage home = loginPage.clickLoginBtn();
		 //driver.navigate().to(driver.getCurrentUrl());
		 
	}
	
	@AfterMethod
		public void closeDriver(){
		 driver.close();
		 driver.quit();
	}

}
