package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//div[@id='userNav']//div[@class='linkWrap noCount']")
	private WebElement userName;
	@FindBy (xpath = "//div[@id='pagelet_composer']//textarea")
	private WebElement pageContent;
	@FindBy (xpath = "//*[@id = 'appsNav']//a[@class='_y-c']")
	private WebElement seeMore;
	@FindBy (xpath = "//a[@data-testid='left_nav_item_Photos']//div[@dir='ltr']/span")
	private WebElement photos;
	@FindBy (xpath = "//*[@id='createNav']//a[contains(@ajaxify,'/events/dialog/create/')]")
	private WebElement createEvent;
	@FindBy (linkText = "Find Friends")
	private WebElement findFriendLink;
	@FindBy (xpath = "//a[@data-testid='left_nav_item_Messenger']")
	private WebElement messageBtn;
	@FindBy (xpath = "//*[@role='navigation']//a[text()='Home']")
	private WebElement homeLink;
	@FindBy (xpath = "//*[@data-testid='post_chevron_button']")
	private List <WebElement> postOptions;
	@FindBy (xpath = "//*[contains(text(),'Save']")
	private WebElement saveLink;
	@FindBy (linkText = "Saved")
	private WebElement savedPageLink;
		
			
	public String getUserName(){
		return userName.getText();
	}
	
	public boolean pageContentExists(){
		return Util.itemIsVisible(pageContent);
	}

	public void clickSeeMore(){
		seeMore.click();
	}
	
	public PhotosPage clickPhotos(){
		photos.click();
		return new PhotosPage(driver); 
	}
	
	public EventsPage clickCreateEvent(){
		Util.waitForElement(driver, createEvent, 15);
		createEvent.click();
		return new EventsPage(driver);
	}
	
	public FriendsPage clickFindFriendLink(){
		findFriendLink.click();
		return new FriendsPage(driver);
	}
	
	public MessengerPage clickMessageBtn(){
		messageBtn.click();
		return new MessengerPage(driver);
	}
	
	public void clickHomeLink(){
		homeLink.click();
	}
	
	public void clickPostActions(int index){
		postOptions.get(index).click();
	}
	
	public void clickSaveLink(){
		saveLink.click();
	}
	
	public SavedLinksPage goToSavedLinks(){
		savedPageLink.click();
		return new SavedLinksPage(driver);
	}
	
}
