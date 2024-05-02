package pages;

import java.io.IOException; 

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBaseFM01;
import utility.ReadDataFM01;

public class CheckOutPage01 extends TestBaseFM01{

	// URL, Pagelable,cancelbutton,continue button test karna hai
	
		// Object Repository
		@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
		@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTxtBox;
		@FindBy(xpath="//input[@id='postal-code']") private WebElement postalCode;
		
		@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement pageLable;
		@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
		@FindBy(xpath="//button[@data-test='cancel']") private WebElement cancelBtn;
		
		public CheckOutPage01()
		{
			PageFactory.initElements(driver, this);
		}
		
		
		public String verifyContinueBtn() throws EncryptedDocumentException, IOException
		{
			firstNameTxtBox.sendKeys(ReadDataFM01.readExcel(3, 0));   
			lastNameTxtBox.sendKeys(ReadDataFM01.readExcel(3, 1));   
			postalCode.sendKeys(ReadDataFM01.readExcel(3, 2));   
			continueBtn.click();  
			
			return driver.getCurrentUrl();  
		}
		
		public String verifyPageLable() throws EncryptedDocumentException, IOException
		{
			return pageLable.getText();  
		}
		
		public String verifyClickOnCancelBtn() throws EncryptedDocumentException, IOException
		{
			cancelBtn.click();
			return driver.getCurrentUrl();
		}
		
}
