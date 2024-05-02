package pages;

import java.io.IOException;  

import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;  
import org.openqa.selenium.support.PageFactory;  

import base.TestBaseFM01;
import utility.ReadDataFM01; 

public class LoginPageFM01 extends TestBaseFM01 {

	    // object repository
		@FindBy(xpath="//input[@placeholder='Username']") private WebElement userNameTxtBox;
		@FindBy(xpath="//input[@placeholder='Password']") private WebElement passwordTxtBox;
		@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
		
		public LoginPageFM01()
		{
			PageFactory.initElements(driver, this);
		}
		
		public String verifyLoginToApplication() throws IOException
		{
			userNameTxtBox.sendKeys(ReadDataFM01.readProperty("username"));
			passwordTxtBox.sendKeys(ReadDataFM01.readProperty("password"));
			loginBtn.click();
			return driver.getCurrentUrl();
		}
		
		public String loginToApplicationMultiCreds(String un, String pass)
		{
			userNameTxtBox.sendKeys(un);
			passwordTxtBox.sendKeys(pass);
			loginBtn.click();
			return driver.getCurrentUrl();
		}
		
		public String verifyTitle()
		{
			return driver.getTitle();
		}
		
		public String verifyUrl()
		{
			return driver.getCurrentUrl();
		}
		
		
}










