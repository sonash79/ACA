package aca.first.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ActivityLogPage;
import pages.EventsPage;
import pages.FriendsListPage;
import pages.FriendsPage;
import pages.GroupsPage;
import pages.HomePage;
import pages.MessengerPage;
import pages.PhotosPage;
import pages.ProfilePage;
import pages.SavedLinksPage;
import pages.Util;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class MyFirstWebDriverTest extends FunctionalTest {
	
	HomePage homePage;
	

//	Test Case 1
	
//		Title: Edit About > Work Section
//	
//		Description: Visitor should be able to edit his/her profile
//
//		Precondition: N/A
//		Assumption: N/A
//
//		Test Steps:
//	
//		Step 1: open https://www.facebook.com/ 
//		Step 2:
//		Fill in below fields :
//		- Email or Phone -- enter valid email
//		- Password -- enter valid password
//		Step 3: click "Log In" button
//		Step 4: go to profile page
//		Step 5: go to "About" section	
//		Step 6: click "Add Workplace" 
//		Step 7: fill in company name = "Hagusti Ashkharh" and possition = "QA Engineer"
//		Step 8: save changes
//		Step 9: click edit menu icon 	
//		Step 10: click Delete link
//		Step 11: select "Delete" option	
//		Step 12: click "Save" button	
//	
//		Expected Result:
//		Step 1: assert that "Email or Phone" button is loaded
//		Step 3: assert that account name and last name exist on the page
//				assert that "What's on your mind?" text area exists	
//		Step 8: assert that company name and position are equal to values entered
//		Step 12: assert that  "Hagusti Ashkharh" and "QA Engineer" texts are not on the page
	
	
	@Test(enabled=false)
	public void editAboutWorkSection(){
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getUserName().equals("Karine Mesropyan"));
		Assert.assertTrue(homePage.pageContentExists());
		ProfilePage profilePage = homePage.goToProfilePage();
		profilePage.goToAbout();
		profilePage.clickAddWorkPlace();
		profilePage.setCompany("Hagusti Ashkharh");
		profilePage.setPosition("QA Engineer");
		profilePage.saveChanges();
		Assert.assertTrue(profilePage.textElementExists("Hagusti Ashkharh"));
		Assert.assertTrue(profilePage.textElementExists("QA Engineer"));
		profilePage.clickEditMenuTrigger();
		profilePage.clickLink("Delete");
		profilePage.selectDeleteOption();
		profilePage.clickSaveBtn();
		Assert.assertFalse(profilePage.pageHasText("Hagusti Ashkharh"));
		Assert.assertFalse(profilePage.pageHasText("QA Engineer"));
		
		
	}
	

	
//	Test Case 2
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
//	
//
//	Expected Result:
//	Step 5: assert that "Create Album" button exists
//	Step 9: assert that "New Album"  titles appeared
//	        assert that photo exists
//	Step 10: assert that Delete link exists
//	Step 11: assert that "Delete Photo" pop up exists	
//	Step 12: assert that  "No photo to show" text exists
	
	@Test(enabled=false)
	public void addPhotoToAlbumAndDelete() throws InterruptedException{
		 homePage = new HomePage(driver);
		 homePage.clickSeeMore();
		 PhotosPage photosPage = homePage.clickPhotos();
		 photosPage.scrollPage("400");
		 photosPage.attachPhoto("photo.png");
		 photosPage.setAlbumTitle("New Album");
		 Assert.assertTrue(photosPage.photoExists());
		 photosPage.clickPostBtn();
		 Assert.assertTrue(photosPage.getAlbumTitleText().equals("New Album"));
		 Assert.assertTrue(photosPage.addedPhotoExists());
		 photosPage.clickActionBtn();
		 photosPage.deleteAlbum();
		 photosPage.clickDeleteAlbumBtn();
		 Assert.assertTrue(photosPage.getPhotoAreaText().contains("No photos to show"));
	
	}
	
//	Test Case 3
//
//	Title:  Create An Event And Delete
//
//	Description: Visitor should be able to create a new event
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
//	Step 4: click "Event" link under Create
//	Step 5: click event type dropdown toggler
//	Step 6: click "Private event" option
//	Step 7: click first image
//	Step 8: Generate random sting and fill in event name
//	Step 9: fill in event date and time
//	Step 10: fill in description
//	Step 11: Uncheck "Guests can invite friends" checkbox
//  Step 12: click creat event button 	
//	Step 13: click Edit btn
//	Step 14: click on Delete Event radio button
//	Step 15: click Confirm button
//	
//
//	Expected Result:
//	Step 4: assert that "Create Private Event" button exists
//	Step 12: assert event is created
//	Step 15: assert "No events coming up." exists
	
	
	@Test(enabled=false)
	public void addNewEventAndDelet() throws InterruptedException{
		 homePage = new HomePage(driver);
		 EventsPage eventsPage = homePage.clickCreateEvent();
		 eventsPage.clickEventToggler();
		 eventsPage.selectPrivateEvent();
		 eventsPage.selectEventImg();
		 String eventTitle = Util.generateRandomstring(7);
		 eventsPage.setEventTitle(eventTitle);
		 eventsPage.selectFromDate();
		 eventsPage.selectDay();
		 eventsPage.setTime("5");
		 eventsPage.setEventDescription();
		 eventsPage.checkOnInviteCheckbox();
		 eventsPage.clickCreateEventBtn();
		 Assert.assertTrue(eventsPage.getEventTitle().contains(eventTitle));
		 eventsPage.clickEditEventBtn();
		 eventsPage.clickCancelEvent();
		 eventsPage.selectDeleteOption();
		 eventsPage.clickConfirmDeleteBtn();
		 Assert.assertTrue(eventsPage.getEventAreaInnerHtml().contains("No events coming up."));
		
	}	
	
//	Test Case 4
//
//	Title:  Send Friend Request And Cancel
//
//		Description: Visitor should be able to send a friend request and cancel it
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
//		Step 4: click "Find Friends"
//		Step 5: fill in "Tigran Matnishyan" in search field 
//      Step 6: click Loop button	
//	    Step 7: click Add Friend button for Tigran Matnishyan
//		Step 8: click Cancel Request Link
//		Step 9: click Cancel Request button	
//	
//
//		Expected Result:
//		Step 4: wait for search field
//		Step 7: assert that "Friend Request Sent"  button is active	
//		Step 9: assert that "Add Friend" button is active	
		
		
		@Test(enabled=false)
		public void sendFriendRequestAndCancel() throws InterruptedException{
			 homePage= new HomePage(driver);	
			 FriendsPage friendsPage = homePage.clickFindFriendLink();
			 friendsPage.searchInfo("Tigran Matnishyan");
			 Assert.assertEquals("Add Friend", friendsPage.getButtonText("FriendRequestAdd"));
			 friendsPage.clickAddFriendButton();
			 Assert.assertEquals("Friend Request Sent", friendsPage.getButtonText("FriendRequestOutgoing"));
			 friendsPage.moveToFriendRequestSentButton();
			 friendsPage.clickCancelRequestLink();
			 friendsPage.clickCancelRequestBtn();
			 Assert.assertEquals("Add Friend", friendsPage.getButtonText("FriendRequestAdd"));
			 
		 	 
		}	
		
//		Test Case 5
//
//		Title:  Send Message
//
//			Description: Visitor should be able to send a message
//
//			Precondition: N/A
//			Assumption: N/A
//
//			Test Steps:
//			Step 1: open https://www.facebook.com/
//			Step 2:
//			Fill in below fields :
//			- Email or Phone -- enter valid email
//			- Password -- enter valid password
//			Step 3: click "Log In" button
//			Step 4: click on "Message" link on the left 
//			Step 5: fill in in search field "Sona Shekhyan"
//			Step 6: click on this contact
//			Step 7: fill in message
//			Step 8: click Send button
//		
//			Expected Result:
//				
			@Test()
			public void sendMessage() throws InterruptedException{
				homePage = new HomePage(driver);
				MessengerPage messengerPage = homePage.clickMessageBtn();
				messengerPage.setSearchValue("Sona Shekhyan");
				messengerPage.clickLink("Sona Shekhyan");
				messengerPage.inputMessage("Hello");
			
					 
			}	
				
//				Test Case 7
				//
//					Title:  Like a page and save a post
				//
//						Description: Visitor should be able to like a page and save a post
				//
//						Precondition: N/A
//						Assumption: N/A
				//
//						Test Steps:
//						Step 1: open https://www.facebook.com/
//						Step 2:
//						Fill in below fields :
//						- Email or Phone -- enter valid email
//						- Password -- enter valid password
//						Step 3: click "Log In" button
//						Step 4: Search for "adme.ru" page using Search field
//						Step 5: click first element with "adme.ru" link text
//						Step 6: click "Like" button
//						Step 7: click hover "Liked" button
//						Step 8: click Home link 	
//						Step 9: click on a post actions dropdown icon
//						Step 10: click "Save Link" link	
//						Step 11: click "See More" link
//						Step 12: click "Saved" link				
//						Step 13: click "Unlike this Page" link from dropdown					
				
				
//						Expected Result:
//						Step 6: assert that "Liked" button exists with "LIked" text	
//						Step 8: assert that adme.ru posts size >0			
//						Step 12: assert that link with adme.ru size >0				
//						Step 13: assert that "Like" button exists with "like" text
						
						
						
				@Test(enabled=false)
				public void likePageAndSavePost() throws InterruptedException{
					homePage = new HomePage(driver); 
					
					Thread.sleep(1000);
					
					homePage.searchInfo("adme.ru");
										     				 
     				Thread.sleep(5000);
     				
     				homePage.clickLinkByIndex("AdMe.ru",0);
     				
     				
     				Thread.sleep(5000);
     				
     				homePage.clickLikeBtn();
     				     				
     				Assert.assertTrue(homePage.getLikedBtnText().equals("Liked"));
     				
     				homePage.clickHomeLink();
     				
     				Thread.sleep(5000);
     				
    				driver.navigate().to(driver.getCurrentUrl());     				
    				Thread.sleep(5000);
     				
             		Assert.assertTrue(homePage.getPostsQty("www.adme.ru") > 0);
              		
              		homePage.clickPostActions(0);
              		Thread.sleep(2000);
              		
              		homePage.clickLinkByPartialText("Save ");
              		SavedLinksPage savedLinks = homePage.goToSavedLinks();
              		Thread.sleep(5000);
              		driver.navigate().to(driver.getCurrentUrl());     	
  		
              		
              		Assert.assertTrue(savedLinks.titleSavedIsVizible());
              		Assert.assertTrue(savedLinks.getPostsQty("www.adme.ru") > 0);
              		
              		savedLinks.clickActions();
              		Thread.sleep(5000);
              		savedLinks = savedLinks.clickUnsaveLink();
              		Thread.sleep(5000);
              		driver.navigate().to(driver.getCurrentUrl());
              		Thread.sleep(2000);
              		
              		Assert.assertTrue(savedLinks.pageHasText("You do not have any saved items."));
              		
              		//Todo: go to AdMe.ru page and unlike the page
              		
			   }	
				
		
				@Test(enabled=false)
				public void createFriendsList() throws InterruptedException{
					 homePage= new HomePage(driver);	
					 
					 FriendsListPage friendsList = homePage.goToFriendsList();
					 friendsList.clickCreateList();
					 friendsList.setListnameField("FirstList");
					 friendsList.addFriendToList("Sona Shekhyan");
					 friendsList.selectFriend("Sona Shekhyan");
					 friendsList.clickCreateBtn();
					 Assert.assertTrue(friendsList.getListNameByIndex(0).equals("FirstList"));
					 friendsList.clickManageList();
					 friendsList.clickDeleteListLink();
					 friendsList.clickDeleteListBtn();
					 // add asserthin 
					 
				}
				
				@Test(enabled=false)
				public void createGroupAndDelete() throws InterruptedException{
					 homePage = new HomePage(driver);
					 GroupsPage groupsPage = homePage.goToGroups();
					 groupsPage.createGroup();
					 groupsPage.setGroupName("My Group");
					 groupsPage.addGroupMember("Tigran Matnishyan");
					 groupsPage.clickCreateBtn();
					 Assert.assertTrue(groupsPage.pageHasText("Karine Mesropyan created the group My Group."));
					 groupsPage.goToMembers();
					 Assert.assertTrue(groupsPage.isGroupMember("Karine Mesropyan"));
					 groupsPage.goToInvitedTab();
					 Assert.assertTrue(groupsPage.isGroupInvited("Tigran  Matnishyan"));
					 groupsPage.removeInvitation();
					 groupsPage.clickRemoveInviteBtn();
					 Assert.assertTrue(groupsPage.pageHasText("No results found."));
					 groupsPage.clickJoinedDropdown();
					 groupsPage.clickLeaveAndDeleteBtn();
					 
				}
				
				@Test(enabled=false)
				public void searchOnFriendsPage() throws InterruptedException{
					 homePage = new HomePage(driver);
					 
					 ProfilePage profilePage = homePage.goToProfilePage();
					 FriendsPage friendsPage = profilePage.goToFriend();
					 friendsPage.searchInFriendList("Armen");
					 Assert.assertEquals("No results for: Armen", friendsPage.getSearchResult());
					 friendsPage.searchInFriendList("Sona Shekhyan");
					 Assert.assertEquals("Results for: Sona Shekhyan", friendsPage.getSearchResult());
					 Assert.assertTrue(friendsPage.isInFriendsList("Sona Shekhyan"));
					 Assert.assertEquals("Friends", friendsPage.getButtonText());
				}
				
				@Test(enabled=false)
				public void searchInActivityLog() throws InterruptedException{
					 homePage = new HomePage(driver);
					 ProfilePage profilePage = homePage.goToProfilePage();
					 ActivityLogPage activityLog = profilePage.goToActivityLog();
					 activityLog.searchActivity("Hello World");
					 activityLog.clickSearchBtn();
					 Assert.assertEquals("Hello World", activityLog.getSearchResult());
					 activityLog.clickLikesLink();
					 Assert.assertTrue(activityLog.isLinkPresent("likes","Little Home Kitchen- Armenia"));
					 activityLog.clickFriendsLink();
					 Assert.assertTrue(activityLog.isLinkPresent("became friends with ","Sona Shekhyan"));
				}
				
				
	
}
