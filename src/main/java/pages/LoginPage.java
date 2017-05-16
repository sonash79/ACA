package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "email")
	private WebElement emailField;
	@FindBy (id = "pass")
	private WebElement passwordField;
	@FindBy (xpath = "//input[@value='Log In']")
	private WebElement loginBtn;
	
	public void setEmail(String email){
		
		inputValue(emailField,email);
	}
	
	public void setPassword(String pass){
		inputValue(passwordField,pass);
	}
	
	public HomePage clickLoginBtn(){
		sleep(1000);
		loginBtn.click();
		return new HomePage(driver);
	}

	
	

	 
}
