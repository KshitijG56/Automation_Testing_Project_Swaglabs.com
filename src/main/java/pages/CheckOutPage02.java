package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBaseFM01;

public class CheckOutPage02 extends TestBaseFM01{
	
	// Object Repository
	@FindBy(xpath = "//span[@class='title']") private WebElement pageLable;
	@FindBy(xpath = "//div[text()='Payment Information:']") private WebElement paymentInfoLable;
	@FindBy(xpath = "//div[text()='SauceCard #31337']") private WebElement paymentInfoValue;
	@FindBy(xpath = "//div[text()='Shipping Information:']") private WebElement shippingInfoLable;
	@FindBy(xpath = "//div[text()='Price Total']") private WebElement priceTotalInfoLable;
	@FindBy(xpath = "//div[text()=\"Item total: $\"]") private WebElement itemTotalLable;
	@FindBy(xpath = "//div[contains(text(),'Tax')]") private WebElement taxLable; 
	@FindBy(xpath = "//div[contains(text(),'Total: $')]") private WebElement totalLable; 
	
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium cart_cancel_link']") private WebElement cancelBtn;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']") private WebElement finishBtn;
 
	public CheckOutPage02()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyPageLable()
	{
		return pageLable.getText();
	}
	
	public String paymentInfoLable()
	{
		return paymentInfoLable.getText();
	}
	
	public String paymentInfoValue()
	{
		return paymentInfoValue.getText();
	}
	
	public String shippingInfoLable()
	{
		return shippingInfoLable.getText();
	}
	
	public String priceTotalLable()
	{
		return priceTotalInfoLable.getText();
	}
	
	public String itemTotalLable()
	{
		return itemTotalLable.getText();
	}
	
	public String taxLable()
	{
		return taxLable.getText();
	}
	
	public String totalLable()
	{
		return totalLable.getText();
	}
	
	public String cancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String finishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
	
}
