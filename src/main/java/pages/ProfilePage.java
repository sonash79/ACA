package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Page {
	
	@FindBy (xpath = "//a[text()='About']")
	private WebElement aboutTab;
	
	@FindBy (xpath = "//*[text()='Add a workplace']/../../../../..//i")
	private WebElement addWorkPlace;
	@FindBy (name = "employer_name")
	private WebElement employerName;
	@FindBy (name = "position_text")
	private WebElement positionField;
	@FindBy (xpath = "//li//button[text()='Save Changes']")
	private WebElement saveChangesBtn;
	@FindBy (xpath = "//li[contains(@class,'fbEditProfileViewExperience experience')]")
	private WebElement workSection;
	@FindBy (xpath = "//*[@data-testid='edit_menu_trigger']/i")
	private WebElement editMenuTrigger;
	@FindBy (xpath = "//input[@value='delete']/../span")
	private WebElement deleteRadioBtn;
	@FindBy (xpath = "//div[contains(@class, 'uiOverlayFooter')]//button[text()='Save']")
	private WebElement clickSaveBtn;
	@FindBy (xpath ="//a[text()='Friends']")
	private WebElement friendsLink;
	@FindBy (xpath="//a[text()='View Activity Log']")
	private WebElement activityLog;
	
	
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public ProfilePage goToAbout(){
		aboutTab.click();
		sleep(2000);
		return new ProfilePage(driver);
	}
	
	public void clickAddWorkPlace(){
		addWorkPlace.click();
		sleep(2000);
		addWorkPlace.click();
		sleep(2000);
	}
	
	public void setCompany(String company){
		inputValue(employerName, company);
		sleep(5000);
		WebElement element= driver.findElement(By.xpath("//li//span[text()='" + company + "']"));
		element.click();

	}
	
	public void setPosition(String position){
		inputValue(positionField, position);
		sleep(5000);
		WebElement element= driver.findElement(By.xpath("//li//span[text()='" + position + "']"));
		element.click();

	}
	
	public void saveChanges(){
		//scrollPage("500");
		saveChangesBtn.click();
		sleep(5000);
		
	}
	
	public boolean textElementExists(String text){
		return driver.findElement(By.xpath("//li[contains(@class,'fbEditProfileViewExperience')]//*[text()='" + text + "']")).isDisplayed();
	}
	
	public boolean textElementDesNotExists(String text){
		return !driver.findElement(By.xpath("//li[contains(@class,'fbEditProfileViewExperience')]//*[text()='" + text + "']")).isDisplayed();
	}
	
	public void moveToWorkSection(){
		moveToElement(workSection);
	}
	
	public void clickEditMenuTrigger(){
		moveToWorkSection();
		sleep(1000);
		editMenuTrigger.click();
		sleep(2000);
	}
	
	public void selectDeleteOption(){
		sleep(5000);
		deleteRadioBtn.click();
		sleep(2000);
	}
	
	public void clickSaveBtn(){
		clickSaveBtn.click();
		sleep(5000);
	}
	
	public FriendsPage goToFriend(){
		friendsLink.click();
		sleep(2000);
		return new FriendsPage(driver);
	}
	
	public ActivityLogPage goToActivityLog(){
		activityLog.click();
		sleep(2000);
		return new ActivityLogPage(driver);
	}
	
}