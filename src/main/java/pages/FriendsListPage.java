package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FriendsListPage extends Page{
	
	@FindBy (xpath = "//a[text()='Create List']")
	private WebElement createListBtn;
	@FindBy (id="createListname")
	private WebElement createListnameField;
	@FindBy (id="createListMembers")
	private WebElement createListMembersArea;
	@FindBy (xpath = "//button[text()='Create']")
	private WebElement createBtn;
	@FindBy (className = "friendListName")
	private List<WebElement> listName;
	@FindBy (xpath = "//input[@value='Delete List']")
	private WebElement deleteListBtn;
	@FindBy (linkText = "Manage List")
	private WebElement manageListLink;
	@FindBy (linkText = "Delete List")
	private WebElement deleteListLink;
	
	
	String searcListResult = "//ul[contains(@id,'typeahead_list_')]/li/span[text()='?']";
	
	
	
	public FriendsListPage(WebDriver driver){
		super(driver);
	}

	public void clickCreateList(){
		createListBtn.click();
		sleep(2000);
	}
	
	public void setListnameField(String listName){
		inputValue(createListnameField,listName);
	}
	
	public void addFriendToList(String friend){
		inputValue(createListMembersArea, friend);
		sleep(1000);
		
	}
	
	public void selectFriend(String friend){
		driver.findElement(By.xpath(searcListResult.replace("?", friend))).click();
	}
	
	public void clickCreateBtn(){
		createBtn.click();
		sleep(2000);
	}
	
	public String getListNameByIndex(int index){
		return listName.get(index).getText();
	}
	
	public void clickDeleteListBtn(){
		deleteListBtn.click();
		sleep(2000);
	}
	
	public void clickManageList(){
		manageListLink.click();
		sleep(2000);
	}
	
	public void clickDeleteListLink(){
		deleteListLink.click();
		sleep(2000);
	}
}
