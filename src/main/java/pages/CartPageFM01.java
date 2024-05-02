package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBaseFM01;

public class CartPageFM01 extends TestBaseFM01{
	
	// Object Repository
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement cartPageLable;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutBtn;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']") private WebElement continueShoppingBtn;
	
	public CartPageFM01()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyCartPageLable()
	{
		return cartPageLable.getText();
	}
	
	public String verifyClickOnCheckoutBtn()
	{
		checkoutBtn.click();
		
		return driver.getCurrentUrl();
	}
	
	public String verifyClickOnContShopBtn()
	{
		continueShoppingBtn.click();
		
		return driver.getCurrentUrl();
	}
	
	

}















