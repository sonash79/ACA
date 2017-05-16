package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessengerPage extends Page{
	
	@FindBy (xpath = "//input[@placeholder='Search Messenger']")
	private WebElement messangerSearch;
	@FindBy (xpath = "//*[@aria-label='Type a message...']//span")
	private WebElement textField;
	@FindBy (xpath = "//div[@aria-label='Type a message...']//span/span")
	private WebElement messageField;
	
	
	
	
	MessengerPage(WebDriver driver){
		super(driver);
	}
	
	public void setSearchValue(String search){
		sleep(5000);
		messangerSearch.sendKeys(search);
		sleep(2000);
	}
	
	public void inputMessage(String message){
		messageField.click();
		messageField.sendKeys(message);
	}
	
	

}
