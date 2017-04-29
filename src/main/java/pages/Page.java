package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Page {

	protected WebDriver driver;
	
	public Page(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputValue(WebElement field, String value){
		field.sendKeys(value);
	}
	
	public  void scrollPage(String scrollBy){
		((JavascriptExecutor)driver).executeScript("scroll(0," + scrollBy + ")");
	}
	
	public void waitForAjax(int sec)  {
	    int count = 0;
	    while (count < 10)
	    {

	        Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
	        if (ajaxIsComplete){
	            break;
	        }
	        try {
	            Thread.sleep(sec);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        count++;
	    }
	}
	
	public void moveToElement(WebElement element){
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}

}
