package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotosPage extends Page{

	
	@FindBy (xpath = "//*[text()='Create Album']//div/input")
	private WebElement addAlbum;
	@FindBy (xpath = "//input[@placeholder='Album name']")
	private WebElement albumTitle;
	@FindBy (xpath = "//*[@class='scaledImage']/img")
	private WebElement photo;
	@FindBy (xpath = "//button[text()='Post']")
	private WebElement postBtn;
	@FindBy (xpath = "//*[@class = 'fbPhotoAlbumTitle']") 
	private WebElement albumTitleText;
	@FindBy (xpath = "//div[contains(@class,'fbPhotoCurationControlWrapper')]/a/img")
	private WebElement existingPhoto;
	@FindBy (xpath = "//a[contains(@class, 'fbPhotoAlbumOptionsGear')]/span/i")
	private WebElement actionBtn;
	@FindBy (linkText = "Delete Album")
	private WebElement deleteAlbumLink;
	@FindBy (xpath = "//form[@action='/photos/delete_album/']//button[contains(text(),'Delete Album')]")
	private WebElement deleteAlbumBtn;
	@FindBy (xpath = "//*[contains(@id,'collection_wrapper')]/div[@class='_4-y-']")
	private WebElement photoArea;
	
	public PhotosPage(WebDriver driver) {
		super(driver);
	}
	
	public void attachPhoto(String photo){
		 //Util.waitForElement(driver, addAlbum, 15);
		 sleep(1000);
		 File file = new File(photo);
		 String filePath = file.getAbsolutePath();
		 addAlbum.sendKeys(filePath);
		 sleep(5000);
	}
	
	public void setAlbumTitle(String albumName){
		inputValue(albumTitle, albumName);
		sleep(5000);
	}
	
	public boolean photoExists(){
		return photo.isDisplayed();
	}
	
	public void clickPostBtn(){
		sleep(5000);
		postBtn.click();
	}
	
	public String getAlbumTitleText(){
		Util.waitForElement(driver, albumTitleText, 15);
		return albumTitleText.getText();
	}
	
	public boolean addedPhotoExists(){
		return existingPhoto.isDisplayed();
	}
	
	public void clickActionBtn(){
		sleep(5000);
		actionBtn.click();
	}
	
	public void deleteAlbum(){
		deleteAlbumLink.click();
	}
	
	public void clickDeleteAlbumBtn(){
		Util.waitForElement(driver, deleteAlbumBtn, 15);
		deleteAlbumBtn.click();
	}
	
	public String getPhotoAreaText(){
		Util.waitForElement(driver, photoArea, 15);
		return photoArea.getText();
	}
}
