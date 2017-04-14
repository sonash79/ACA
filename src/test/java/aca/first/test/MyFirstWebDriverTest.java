package aca.first.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class MyFirstWebDriverTest {
	@Test(enabled=false)
	public void myFirstTest(){
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://aca.am");
		 driver.close();
		 driver.quit();
	}
	
//	Test Case 1
//
//	Title: User Sign Up
//
//	Description: Visitor should be able to create new user.
//
//	Precondition: N/A
//	Assumption: N/A
//
//	Test Steps:
//	Step 1: open https://www.facebook.com/ 
//	Step 2:
//	Fill in below fields :
//	- First Name -- enter valid name
//	- Last Name -- enter valid last name
//	- Mobile number or email - enter valid email
//	- New Password -- enter password
//	- Birthday data -- enter month, day, year
//	- Select Female radio button 
//	Step 3: click "Create Account" button
//	Step 4: Click "Okay" button on "Account Confirmed" popup
//	Step 5: Click account name link
//	Expected Result:
//	Step 1: assert that "Create Account" button is loaded
//	Step 3: assert that "Account Confirmed" popup appeared
//	Step 4: assert that link with text = entered name exists
//	Step 5: assert that account name and last name exist


//	Test Case 2
	
//		Title: User Sign In
	
//		Description: Visitor should be able to sign in with valid login/password
	//
//		Precondition: N/A
//		Assumption: N/A
	//
//		Test Steps:
//		Step 1: open https://www.facebook.com/ 
//		Step 2:
//		Fill in below fields :
//		- Email or Phone -- enter valid email
//		- Password -- enter valid password
//		Step 3: click "Log In" button
//		Expected Result:
//		Step 1: assert that "Email or Phone" button is loaded
//		Step 3: assert that account name and last name exist on the page
//				assert that "What's on your mind?" text area exists				

	
	
	@Test(enabled=false)
	public void signInTest(){
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver(options);
		 
		 driver.get("https://www.facebook.com");
		 
		 WebElement email = driver.findElement(By.id("email"));
		 Assert.assertTrue(email!=null);
		 email.sendKeys("annakhach7@mail.ru");
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys("annakhach7");
		 
		 WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
		 logInBtn.click();
		 driver.navigate().to(driver.getCurrentUrl());
	
		 WebElement userName = driver.findElement(By.xpath("//div[@id='userNav']//div[@class='linkWrap noCount']"));
		 Assert.assertTrue(userName.getText().equals("Anna Khachatryan"));
		 
		 WebElement pageContent = driver.findElement(By.xpath("//div[@id='pagelet_composer']//textarea"));
		 Assert.assertTrue(pageContent != null);
	 
		 driver.close();
		 driver.quit();
	}
	
	
	@Test(enabled=false)
	public void verifyLoginFields(){
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.facebook.com");
		 int elementIsPresent = driver.findElements(By.id("email")).size();
		 if (elementIsPresent>0){
			 System.out.println("'Email or Phone' field is present");
		 }
		 
		 elementIsPresent = driver.findElements(By.id("pass")).size();
		 if (elementIsPresent>0){
		 }
		 
		 Assert.assertTrue(driver.findElements(By.id("email")).size()>0);
		 Assert.assertTrue(driver.findElements(By.id("pass")).size()>0);
		 
		 driver.findElement(By.id("email")).sendKeys("Sona");
		 
	
		 
		 driver.close();
		 driver.quit();
	}
	
//	Test Case 3
//
//	Title:  Search and Adding Friend
//
//	Description: Visitor should be able to send friend request.
//
//	Precondition: N/A
//	Assumption: N/A
//
//	Test Steps:
//	Step 1: open https://www.facebook.com/
//	Step 2:
//	Fill in below fields :
//	- Email or Phone -- enter valid email
//	- Password -- enter valid password
//	Step 3: click "Log In" button
//	Step 4: Click on account name and last name link (in the left corner)
//	Step 5: Click "Friends" link
//	Step 6: Enter "Karapet Karapetyan" into "Search for your friends" field
//	Step 7: Enter "Karapet Karapetyan" into "Search Facebook" field
//	Step 8: Click "Add Friend" button
//
//	Expected Result:
//	Step 4: assert that "Friends" link exists
//	Step 5: assert that "Search for your friends" search field exists
//	Step 6: assert that "No results for: karapet karapetyan" message is reflected
//	Step 7: assert that "People" title exists
//	        assert that "Karapet Karapetyan" exists on the search result list
//	Step 8: assert that "Friend Request sent" label appeared on the button
//__________________________________________________________________________________
	
//	Test Case 4
//
//	Title:  Add Photo to New Album and Delete
//
//	Description: Visitor should be able to create an album, add photo to it and delete album.
//
//	Precondition: N/A
//	Assumption: N/A
//
//	Test Steps:
//	Step 1: open https://www.facebook.com/
//	Step 2:
//	Fill in below fields :
//	- Email or Phone -- enter valid email
//	- Password -- enter valid password
//	Step 3: click "Log In" button
//	Step 4: Click on "See More" link  (left side panel, sometimes to see photo links need to click see more )
//	Step 5: Click "Photos" link
//	Step 6: Click "Create Album" button
//	Step 7: Select photo along with adding to new album
//	Step 8: Input "New Album" into "Untitled Album" field
//	Step 9: click "Post" button.
//	Step 10: click Actions icon on the photo
//	Step 11: click "Delete this photo"
//	Step 12: click "Delete" button
//	Step 13: close browser
//	
//
//	Expected Result:
//	Step 5: assert that "Create Album" button exists
//	Step 9: assert that "New Album"  titles appeared
//	        assert that photo exists
//	Step 10: assert that Delete link exists
//	Step 11: assert that "Delete Photo" popup exists	
//	Step 12: assert that  "No photo to show" text exists
	
	@Test()
	public void addPhotoToAlbumAndDelete() throws InterruptedException{
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver", "/Users/sonash79/Downloads/chromedriver");
		 WebDriver driver = new ChromeDriver(options);
		 
		 driver.get("https://www.facebook.com");
		 
		 WebElement email = driver.findElement(By.id("email"));
		
		 email.sendKeys("annakhach7@mail.ru");
		 
		 WebElement password = driver.findElement(By.id("pass"));
		 password.sendKeys("annakhach7");
		 
		 WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
		 logInBtn.click();
			
		 WebElement seeMore = driver.findElement(By.xpath("//*[@id = 'appsNav']//a[@class='_y-c']"));
		 seeMore.click();
		 
		 WebElement photos = driver.findElement(By.xpath("//a[@data-testid='left_nav_item_Photos']//div[@dir='ltr']/span"));
		 photos.click();
		 
		 Thread.sleep(5000);
		
		 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		 WebElement addAlbum = driver.findElement(By.xpath("//*[text()='Create Album']//div/input"));
		 File file = new File("photo.png");
		 String filePath = file.getAbsolutePath();
		 addAlbum.sendKeys(filePath);
		 
		 Thread.sleep(5000);		 
		 
		 WebElement albumTitle = driver.findElement(By.xpath("//input[@placeholder='Untitled Album']"));
		 albumTitle.sendKeys("New Album");
		
		 WebElement photo = driver.findElement(By.xpath("//a[@data-tooltip-content ='Rotate this photo']"));
		 Assert.assertTrue(photo != null);
		
		 Thread.sleep(5000);
					
		 WebElement postBtn = driver.findElement(By.xpath("//button[@data-testid='album-uploader-publish-button']/*[@data-intl-translation = 'Post']"));
		 Assert.assertTrue(postBtn != null);
		
		 postBtn.click();
		
		 Thread.sleep(5000);
		
		
		WebElement albumTitleText = driver.findElement(By.xpath("//*[@class = 'fbPhotoAlbumTitle']"));
		Assert.assertTrue(albumTitleText.getText().equals("New Album"));
		
		WebElement existingPhoto = driver.findElement(By.xpath("//*[contains(@id,'pic')]//*[@class = 'uiMediaThumbImg']"));
		Assert.assertTrue(existingPhoto != null);
		
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		WebElement actionBtn = driver.findElement(By.xpath("//a[contains(@class, 'fbPhotoAlbumOptionsGear')]/span/i"));
		actionBtn.click();
		
		WebElement deleteAlbumLink = driver.findElement(By.linkText("Delete Album"));
		deleteAlbumLink.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action='/photos/delete_album/']//button[contains(text(),'Delete Album')]")));
		
		WebElement deleteAlbumBtn = driver.findElement(By.xpath("//form[@action='/photos/delete_album/']//button[contains(text(),'Delete Album')]"));
		deleteAlbumBtn.click();
		
		Thread.sleep(5000);
		
		WebElement photoArea = driver.findElement(By.xpath("//*[contains(@id,'collection_wrapper')]/div[@class='_4-y-']"));
				
		Assert.assertTrue(photoArea.getText().contains("No photos to show"));

		 driver.close();
		 driver.quit();
	}
	
	
	
	
	
}
