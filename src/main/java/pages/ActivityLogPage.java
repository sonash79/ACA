package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityLogPage extends Page {
	@FindBy (xpath="//input[@placeholder='Activity Search']")
	private WebElement searchField;
	@FindBy (xpath="//button[@title='Activity Search']")
	private WebElement searchBtn;
	@FindBy (xpath="//div[@id='activity_search_results']//div[@class='fsm']")
	private WebElement searchReasult;
	@FindBy (xpath="//div[contains(text(),'Likes')]")
	private WebElement likesLink;
	@FindBy (xpath="//div[contains(text(),'Friends')]")
	private WebElement friendsLink;
	@FindBy (xpath = "//a[@class='navMoreText']/span")
	private WebElement moreLink;
	
	String link = "//div[contains(text(),'#')]/a[text()='?']";
	
	
	public ActivityLogPage(WebDriver driver){
		super(driver);
	}
	
	public void searchActivity(String activity){
		searchField.clear();
		searchField.sendKeys(activity);
	}
	
	public void clickSearchBtn(){
		searchBtn.click();
	}
	
	public String getSearchResult(){
		sleep(2000);
		return searchReasult.getText();
	}
	
	public boolean isLinkPresent(String text, String linkText){
		return driver.findElement(By.xpath(link.replace("#", text).replace("?", linkText))).isDisplayed();
	}
	
	public void clickMoreLink(){
		moreLink.click();
	}
	
	public void clickLikesLink(){
		clickMoreLink();
		likesLink.click();
		sleep(2000);
	}
	
	public void clickFriendsLink(){
		friendsLink.click();
		sleep(2000);
	}
	
	
}
