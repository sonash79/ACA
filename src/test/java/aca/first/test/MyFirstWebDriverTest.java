package aca.first.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MyFirstWebDriverTest {
	
	@Test()
	public void myFirstTest(){
		 WebDriver driver = new FirefoxDriver();
		 driver.get("http://aca.am");
		 driver.close();
		 driver.quit();
	}

}
