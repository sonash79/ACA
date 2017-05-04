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
	
	
	
	
	
	MessengerPage(WebDriver driver){
		super(driver);
	}
	
	public void setSearchValue(String search){
		messangerSearch.sendKeys(search);
	}
	
	

}
