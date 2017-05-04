package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendsPage extends Page {
	@FindBy (xpath = "//input[@placeholder='Find friends']")
	private WebElement searchField;
	@FindBy (xpath = "//button[@data-testid='facebar_search_button']")
	private WebElement loopIcon;
	@FindBy (xpath = "//button[@aria-label='Add Friend']")
	private WebElement addFriendButton;
	@FindBy (xpath = "//button[contains(@class,'FriendRequestOutgoing')]")
	private WebElement friendRequestSent;
	@FindBy (xpath = "//li[contains(@class,'FriendListCancel')]")
	private WebElement cancelRequest;
	
	
	public FriendsPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterSearchValue(String friend){
		Util.waitForElement(driver, searchField, 30);
		searchField.sendKeys(friend);
	}
	
	public void clickLoopIcon(){
		loopIcon.click();
	}
	
	public void searchFriend(String friend) {
		enterSearchValue(friend);
		clickLoopIcon();
	}
	
	public void clickAddFriendButton(){
		addFriendButton.click();
	}
	
	public String getButtonText(){
		return friendRequestSent.getText();
	}
	
	public void moveToFriendRequestSentButton(){
		moveToElement(friendRequestSent);
	}
	
	public void clickCancelRequest(){
		cancelRequest.click();
	}
	
		
	
}
