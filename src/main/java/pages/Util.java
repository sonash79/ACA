package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	 private WebDriver driver;

	 public Util(WebDriver driver) {
	        this.driver = driver;
	    }
	//protected static WebDriver driver;
	
	public static WebElement waitForElement(WebDriver driver, WebElement element, long sec){
		WebDriverWait wait = new WebDriverWait(driver, sec);
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static boolean itemIsVisible(WebElement element){
		return element.isDisplayed();
	}
	
	public static String generateRandomstring(int qty){
		String letters = "abcdefghijklmnopq";
		RandomStringUtils randomGenerator = new RandomStringUtils();
		String randomString = randomGenerator.random(qty, letters);
		return randomString;
	}
	
}
