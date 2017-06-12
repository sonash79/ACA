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
		 Assert.assertFalse(eventsPage.getEventAreaInnerHtml().contains(eventTitle));
		
	}	
	
	
	@Test(enabled=false)
	public void sendFriendRequestAndCancel() throws InterruptedException{
		 homePage= new HomePage(driver);	
		 FriendsPage friendsPage = homePage.clickFindFriendLink();
		 friendsPage.searchFriend("Tigran Matnishyan");
		 Assert.assertEquals("Add Friend", friendsPage.getButtonText("FriendRequestAdd"));
		 friendsPage.clickAddFriendButton();
		 Assert.assertEquals("Friend Request Sent", friendsPage.getButtonText("FriendRequestOutgoing"));
		 friendsPage.moveToFriendRequestSentButton();
		 friendsPage.clickCancelRequestLink();
		 friendsPage.clickCancelRequestBtn();
		 Assert.assertEquals("Add Friend", friendsPage.getButtonText("FriendRequestAdd"));
				 	 
	}	
		
	@Test(enabled=false)
	public void sendMessage() throws InterruptedException{
		homePage = new HomePage(driver);
		MessengerPage messengerPage = homePage.clickMessageBtn();
		messengerPage.setSearchValue("Sona Shekhyan");
		messengerPage.clickLink("Sona Shekhyan");
		String message = Util.generateRandomstring(10);
		messengerPage.inputMessage(message);
		messengerPage.clickSendBtn();
		Assert.assertTrue(messengerPage.getAllMessages().contains(message));
								 
	}	
				
	
	@Test(enabled=false)
	public void likePageSavePostUnsaveAndUnlikePage() throws InterruptedException{
		homePage = new HomePage(driver); 
		homePage.searchInfo("adme.ru");
		homePage.clickLinkByIndex("AdMe.ru",0);
		homePage.clickLikeBtn();
		Assert.assertTrue(homePage.getLikedBtnText().equals("Liked"));
		homePage.clickHomeLink();
    	driver.navigate().to(driver.getCurrentUrl());     				
        Thread.sleep(10000);
     	Assert.assertTrue(homePage.getPostsQty("www.adme.ru") > 0);
        homePage.clickPostActions(0);
        homePage.clickLinkByPartialText("Save ");
        SavedLinksPage savedLinks = homePage.goToSavedLinks();
        driver.navigate().to(driver.getCurrentUrl());     	
  		Assert.assertTrue(savedLinks.titleSavedIsVizible());
        Assert.assertTrue(savedLinks.getPostsQty("www.adme.ru") > 0);
        savedLinks.clickActions();
        Thread.sleep(5000);
        savedLinks = savedLinks.clickUnsaveLink();
        driver.navigate().to(driver.getCurrentUrl());
        Thread.sleep(2000);
        Assert.assertTrue(savedLinks.pageHasText("You do not have any saved items."));
        homePage.searchInfo("adme.ru");
        homePage.moveToLikedPageButton();
        homePage.clickLink("Unlike");
  
	}	
	
	@Test(enabled=false)
	public void createFriendsListAndDelete() throws InterruptedException{
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
		 Assert.assertFalse(friendsList.pageHasText("FirstList"));
	}
				
	@Test(enabled=false)
	public void createGroupAndDelete() throws InterruptedException{
		 homePage = new HomePage(driver);
		 GroupsPage groupsPage = homePage.goToGroups();
		 groupsPage.scrollPage("400");
		 groupsPage.createGroup();
	     groupsPage.setGroupName("Sona Group");
		 groupsPage.addGroupMember("Sona Shekhyan");
		 groupsPage.clickCreateBtn();
		 Assert.assertTrue(groupsPage.pageHasText("Karine Mesropyan created the group Sona Group."));
		 groupsPage.goToMembers();
		 Assert.assertTrue(groupsPage.isGroupMember("Karine Mesropyan"));
		 Assert.assertTrue(groupsPage.isGroupMember("Sona Shekhyan"));
		 groupsPage.clickJoinedDropdown();
		 groupsPage.clickLeaveGroupBtn();
		 groupsPage.clickLink("Home");
		 
		 
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
				
				//@Test(enabled=false)
				@Test
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
