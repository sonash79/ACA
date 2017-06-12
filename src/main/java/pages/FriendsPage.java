package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendsPage extends Page {
	@FindBy (xpath = "//input[@placeholder='Search Facebook']")
	private WebElement searchField;
	@FindBy (xpath = "//button[@data-testid='facebar_search_button']")
	private WebElement loopIcon;
	@FindBy (xpath = "//button[@aria-label='Add Friend']")
	private WebElement addFriendButton;
	@FindBy (xpath = "//button[contains(@class,'FriendRequestOutgoing')]")
	private WebElement friendRequestSent;
	@FindBy (xpath = "//li[contains(@class,'FriendListCancel')]")
	private WebElement cancelRequest;
	@FindBy (xpath = "//*[text()='POSTED BY']")
	private WebElement postedByTitle;
	@FindBy (xpath = "//button[text()='Cancel Request']")
	private WebElement cancelRequestBtn;
	@FindBy (xpath = "//input[@placeholder='Search for your friends']")
	private WebElement searchInFriendList;
	@FindBy (xpath = "//div[contains(@class,'fbProfileBrowserSummaryBox')]")
	private WebElement searchResult;
	@FindBy (xpath = "//a[@data-testid='friends_button']/span/span")
	private WebElement friendsButton;
	String friendRow = "//li[contains(@class,'fbProfileBrowserListItem')]//a[text()='?']";
	
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
	
	public String getButtonText(String btnTitle){
		return driver.findElement(By.xpath("//button[contains(@class,'" + btnTitle + "')]")).getText();
		
	}
	
	public void moveToFriendRequestSentButton(){
		moveTo();// just to make friendRequestSent element active
		moveToElement(friendRequestSent);
		sleep(5000);
	}
	
	public void clickCancelRequestLink(){
		cancelRequest.click();
		sleep(2000);
		
	}
	
	public void moveTo(){
		sleep(5000);
		moveToElement(postedByTitle);
	}
	
		
	public void clickCancelRequestBtn(){
		cancelRequestBtn.click();
		sleep(2000);
	}
	
	public void cancelFriendRequest(){
		clickCancelRequestLink();
		
	}
	
	public void searchInFriendList(String friend){
		searchInFriendList.clear();
		searchInFriendList.sendKeys(friend);
		sleep(1000);
	}
	
	public String getSearchResult(){
		return searchResult.getText();
	}
	
	public boolean isInFriendsList(String friend){
		return driver.findElement(By.xpath(friendRow.replace("?",friend))).isDisplayed();
	}
	
	public String getButtonText(){
		return friendsButton.getText();
	}
}
