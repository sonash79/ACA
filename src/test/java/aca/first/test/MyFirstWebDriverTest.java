package aca.first.test;
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
			 System.out.println("'Password' field is present");
		 }
		 
		 driver.close();
		 driver.quit();
	}

}
