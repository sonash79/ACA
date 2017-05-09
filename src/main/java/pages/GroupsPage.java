package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupsPage extends Page{
	
	@FindBy(xpath = "//a[text()='Create Group']")
	private WebElement createGroupBtn;
	@FindBy(xpath = "//div[@id='groupsCreateName']/../input")
	private WebElement groupName;
	@FindBy(xpath ="//input[@placeholder='Enter names or email addresses...']")
	private WebElement addMemberField;
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createBtn;
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;
	@FindBy(linkText = "Members")
	private WebElement membersLink;
	@FindBy(xpath = "//a[text()='Invited ']")
	private WebElement invitedTab;
	@FindBy(xpath = "//a[contains(@data-testid,'_RemoveInvite')]")
	private WebElement removeInvitation;
	@FindBy(xpath = "//button[text()='Remove Invite']")
	private WebElement removeInviteBtn;
	@FindBy(linkText="Joined")
	private WebElement joinedDropdown;
	@FindBy(linkText="Leave Group")
	private WebElement leaveGroupLink;
	@FindBy(xpath = "//button[text()='Leave and Delete']")
	private WebElement leaveAndDeleteBtn;
	String searchResult = "//ul[contains(@id,'typeahead_list')]/li/span[text()='?']";
	String groupMember = "//div[contains(@data-testid,'GroupMember_')]//a[text()='?']";
	String groupInvited = "//div[contains(@data-testid,'GroupUserInvite_')]//a[text()='?']";
	
	
	public GroupsPage(WebDriver driver) {
		super(driver);
	}

	public void createGroup(){
		createGroupBtn.click();
		sleep(2000);
	}
	
	public void setGroupName(String name){
		groupName.sendKeys(name);
	}
	
	public void addGroupMember(String member){
		addMemberField.sendKeys(member);
		sleep(1000);
		driver.findElement(By.xpath(searchResult.replace("?", member))).click();
	}
	
	public boolean isGroupMember(String member){
		return driver.findElement(By.xpath(groupMember.replace("?", member))).isDisplayed();
	}
	
	public boolean isGroupInvited(String member){
		return driver.findElement(By.xpath(groupInvited.replace("?", member))).isDisplayed();
	}
	

	public void clickCreateBtn(){
		createBtn.click();
		sleep(10000);
		okBtn.click();
		sleep(5000);
		
	}
	
	public void goToMembers(){
		membersLink.click();
		sleep(2000);
	}
	
	public void goToInvitedTab(){
		invitedTab.click();
		sleep(2000);
	}
	
	public void removeInvitation(){
		removeInvitation.click();
		sleep(2000);
	}
	
	public void clickRemoveInviteBtn(){
		removeInviteBtn.click();
		sleep(2000);
	}
	
	public void clickJoinedDropdown(){
		joinedDropdown.click();
		sleep(2000);
		leaveGroupLink.click();
		sleep(2000);
		
	}
	
	public void clickLeaveAndDeleteBtn(){
		leaveAndDeleteBtn.click();
		sleep(5000);
	}
}
