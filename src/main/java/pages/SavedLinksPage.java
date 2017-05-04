package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedLinksPage extends Page{
	
	@FindBy (xpath = "//div[@id='globalContainer']//*[text() = 'Saved']")
	private WebElement titleSaved;
	@FindBy (xpath = "//div[contains(@class,'uiPopover')]//*[text()='...']")
	private WebElement dropdownBtn;
	@FindBy (xpath = "//ul//*[text()='Unsave']")
	private WebElement unsaveLink;
	
	public SavedLinksPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean titleSavedIsVizible(){
		return titleSaved.isDisplayed();
	}
	
	public void clickActions(){
		dropdownBtn.click();
	}
	
	public SavedLinksPage clickUnsaveLink(){
		unsaveLink.click();
		return new SavedLinksPage(driver);
	}

}
