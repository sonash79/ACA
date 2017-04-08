package aca.first.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	
//	Test Case 1
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


//	Test Case 2
	
//		Title: User Sign In
	
//		Description: Visitor should be able to sign in with valid login/password
	//
//		Precondition: N/A
//		Assumption: N/A
	//
//		Test Steps:
//		Step 1: open https://www.facebook.com/ 
//		Step 2:
//		Fill in below fields :
//		- Email or Phone -- enter valid email
//		- Password -- enter valid password
//		Step 3: click "Log In" button
//		Expected Result:
//		Step 1: assert that "Email or Phone" button is loaded
//		Step 3: assert that account name and last name exist on the page
//				assert that "What's on your mind?" text area exists				

	
	
	@Test()
	public void signInTest(){
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver(options);
		 
		 driver.get("https://www.facebook.com");
		 
		 WebElement email = driver.findElement(By.id("email"));
		 Assert.assertTrue(email!=null);
		 email.sendKeys("annakhach7@mail.ru");
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys("annakhach7");
		 
		 WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
		 logInBtn.click();
		 driver.navigate().to(driver.getCurrentUrl());
	
		 WebElement userName = driver.findElement(By.xpath("//div[@id='userNav']//div[@class='linkWrap noCount']"));
		 Assert.assertTrue(userName.getText().equals("Anna Khachatryan"));
		 
		 WebElement pageContent = driver.findElement(By.xpath("//div[@id='pagelet_composer']//textarea"));
		 Assert.assertTrue(pageContent != null);
	 
		 driver.close();
		 driver.quit();
	}
	
	
	@Test(enabled=false)
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
		 
		 driver.findElement(By.id("email")).sendKeys("Sona");
		 
	
		 
		 driver.close();
		 driver.quit();
	}

}
