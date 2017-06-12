package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EventsPage extends Page{
	@FindBy (xpath = "//div[contains(@class,'uiOverlayFooter')]/button")
	private WebElement createPrivateEvent;
	@FindBy (xpath = "//span[text()='Create Private Event']")
	private WebElement eventToggler;
	@FindBy (xpath = "//div[contains(@class,'uiContextualLayerBelowLeft')]//ul[@role='menu']//span[text()='Private Event']")
	private WebElement privateEvent;
	@FindBy (xpath = "//div[contains(@data-testid,'event_theme_item_')]/img[1]")
	private	WebElement eventImg;
	@FindBy (xpath = "//input[@data-testid='event-create-dialog-name-field']")
	private WebElement eventName;
	@FindBy (xpath = "//div[@data-testid='event-create-dialog-start-time']//span/label")
	private WebElement fromDate;
	@FindBy (xpath = "//div[contains(@aria-labelledby,'js_')]//a/span[text()='30']") 
	private WebElement day;
	@FindBy (xpath = "//div[@aria-live='polite']//input[@role='spinbutton']")
	private WebElement timeField;
	@FindBy (xpath = "//*[@data-testid='event-create-dialog-details-field']//span[1]")
	private WebElement eventDescription;
	@FindBy (xpath = "//*[@data-testid='event_guests_can_invite__checkbox']")
	private WebElement inviteCheckbox;
	@FindBy (xpath = "//button[@data-testid='event-create-dialog-confirm-button' and text()='Create Private Event']")
	private WebElement createEventBtn;
	@FindBy (xpath = "//*[@id='event_header']//span[@aria-label='Sunday, April 30']/span")
	private List<WebElement> eventDate;
	@FindBy (xpath = "//h1[@data-testid='event-permalink-event-name']")
	private WebElement eventData;
	@FindBy (xpath = "//a[@data-testid='event-edit-button']/i")
	private WebElement editEventBtn;
	@FindBy (linkText = "Cancel Event")
	private WebElement cancelEvent;
	@FindBy (xpath = "//input[@name='should_delete']/../span")
	private WebElement deleteOption;
	@FindBy (xpath = "//button[text()='Confirm']")
	private WebElement confirmDeleteBtn;
	@FindBy (xpath = "//*[@id='events_dashboard_upcoming_events']")
	private WebElement eventArea;
	
	
	public EventsPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickEventToggler(){
		//Util.waitForElement(driver, createPrivateEvent, 15);
		sleep(5000);
		eventToggler.click();
	}
	
	public void selectPrivateEvent(){
		privateEvent.click();
	}

	public void selectEventImg(){
		Util.waitForElement(driver,eventImg,15);
		eventImg.click();
	}
	
	public void setEventTitle(String title){
		eventName.sendKeys(title);
	}
	
	public void selectFromDate(){
		fromDate.click();
	}
	
	public void selectDay(){
		day.click();
		
	}
	
	public void setTime(String time){
		timeField.sendKeys(time);
	}
	
	public void setEventDescription(){
		 Actions builder;
		 builder = new Actions(driver);
		 builder.moveToElement(eventDescription).click(eventDescription).sendKeys("Event description").build().perform();
	}
	
	public void checkOnInviteCheckbox(){
		inviteCheckbox.click();
	}
	
	public void clickCreateEventBtn(){
		createEventBtn.click();
		sleep(10000);
	}
	
	public String getEventDate(){
		Util.waitForElement(driver, eventDate.get(1), 15);
		return eventDate.get(1).getText();
	};
	
	public String getEventTitle(){
		Util.waitForElement(driver, eventData, 15);
		return eventData.getText();
	}
	
	public void clickEditEventBtn(){
		sleep(5000);
		editEventBtn.click();
	}
	
	public void clickCancelEvent(){
		sleep(5000);
		cancelEvent.click();
	}
	
	public void selectDeleteOption(){
		sleep(3000);
		deleteOption.click();
	}
	
	public  void clickConfirmDeleteBtn(){
		sleep(5000);
		confirmDeleteBtn.click();
	}
	
	public String getEventAreaInnerHtml(){
		sleep(5000);
		return eventArea.getAttribute("innerHTML");
	}
}
