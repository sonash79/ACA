package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	protected WebDriver driver;

	@FindBy (xpath = "//input[@placeholder='Find friends']")
	private WebElement searchField;
	@FindBy (xpath = "//button[@data-testid='facebar_search_button']")
	private WebElement loopIcon;
	@FindBy (xpath = "//button[contains(@class,'likeButton')]")
	private WebElement likeBtn;
	@FindBy (xpath = "//a[contains(@class,'likedButton')]//span")
	private WebElement likedBtn;
    String post = "//a[contains(@href,'?')]";
    @FindBy (tagName = "body")
    private WebElement pageBody;
    
	
	public int getPostsQty(String site){
		return driver.findElements(By.xpath(post.replace("?", site))).size();
	}
	

	public Page(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputValue(WebElement field, String value){
		field.sendKeys(value);
	}
	
	public  void scrollPage(String scrollBy){
		((JavascriptExecutor)driver).executeScript("scroll(0," + scrollBy + ")");
	}
	
	public void waitForAjax(int sec)  {
	    int count = 0;
	    while (count < 10)
	    {

	        Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
	        if (ajaxIsComplete){
	            break;
	        }
	        try {
	            Thread.sleep(sec);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        count++;
	    }
	}
	
	public void moveToElement(WebElement element){
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}
	
	public void clickLink(String text){
		driver.findElement(By.linkText(text)).click();
		
	}
	
	public void clickLinkByPartialText(String text){
		driver.findElement(By.partialLinkText(text)).click();
		
	}
	
	public void clickLinkByIndex(String text, int index){
		driver.findElements(By.linkText(text)).get(index).click();
		
	}

	public void enterSearchValue(String friend){
		Util.waitForElement(driver, searchField, 30);
		searchField.sendKeys(friend);
	}
	
	public void clickLoopIcon(){
		loopIcon.click();
	}
	
	public void searchInfo(String friend) {
		enterSearchValue(friend);
		clickLoopIcon();
	}

	public void clickLikeBtn(){
		likeBtn.click();
	}
	
	public String getLikedBtnText(){
		return likedBtn.getText();
	}
	
	public boolean pageHasText(String text){
		return pageBody.getText().contains(text);
	}
	

}
