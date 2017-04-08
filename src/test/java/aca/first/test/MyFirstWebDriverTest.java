package aca.first.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MyFirstWebDriverTest {
	@Test(enabled=false)
	public void myFirstTest(){
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://aca.am");
		 driver.close();
		 driver.quit();
	}
	
//	Test Case 
//
//	Title: User Sign Up
//
//	Description: Visitor should be able to create new user.
//
//	Precondition: N/A
//	Assumption: N/A
//
//	Test Steps:
//	Step 1: open https://www.facebook.com/ 
//	Step 2:
//	Fill in below fields :
//	- First Name -- enter valid name
//	- Last Name -- enter valid last name
//	- Mobile number or email - enter valid email
//	- New Password -- enter password
//	- Birthday data -- enter month, day, year
//	- Select Female radio button 
//	Step 3: click "Create Account" button
//	Step 4: Click "Okay" button on "Account Confirmed" popup
//	Step 5: Click account name link
//	Expected Result:
//	Step 1: assert that "Create Account" button is loaded
//	Step 3: assert that "Account Confirmed" popup appeared
//	Step 4: assert that link with text = entered name exists
//	Step 5: assert that account name and last name exist


	
	@Test()
	public void verifyLoginFields(){
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.facebook.com");
		 int elementIsPresent = driver.findElements(By.id("email")).size();
		 if (elementIsPresent>0){
			 System.out.println("'Email or Phone' field is present");
		 }
		 
		 elementIsPresent = driver.findElements(By.id("pass")).size();
		 if (elementIsPresent>0){
		 }
		 
		 Assert.assertTrue(driver.findElements(By.id("email")).size()>0);
		 Assert.assertTrue(driver.findElements(By.id("pass")).size()>0);
		 
	
		 
		 driver.close();
		 driver.quit();
	}

}
