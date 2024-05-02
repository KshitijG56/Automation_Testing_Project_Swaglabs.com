package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBaseFM01;

public class InventoryPageFM01 extends TestBaseFM01 {
	
	// Object Repository
	
		// add product
		@FindBy(xpath="//span[text()='Products']") private WebElement productTitle;
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirtProduct;
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onsieProduct;
		@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redtshirtProduct;
		
		// remove product
		@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement backpackRemoveProduct;
		@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement bikeLightRemoveProduct;
		@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtRemoveProduct;
		@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement fleeceJacketRemoveProduct;
		@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement onsieRemoveProduct;
		@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtRemoveProduct;
		
		@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
		@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
		@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
		@FindBy(xpath="//a[text()='Facebook']") private WebElement faceBookLogo;
		@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedinLogo;
		@FindBy(xpath="//select[@class='product_sort_container']") private WebElement productDropDown;
	
    public InventoryPageFM01()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public String verifyTitle()
    {
    	return driver.getTitle();
    }
    
    // We have to check product add ho rahe hai ki nahi, cartIcon me change hona chahiye number
    public String verifyAdd6Product()
    {
    	backpackProduct.click();
    	bikeLightProduct.click();
    	boltTshirtProduct.click();
    	fleeceJacketProduct.click();
    	onsieProduct.click();
    	redtshirtProduct.click();
    	
    	return cartCount.getText();
    	
    }
    
    public boolean verifyTwitterLogo()
    {
    	return twitterLogo.isDisplayed();
    }
    
    public String remove4Product()
    {
    	verifyAdd6Product();
    	backpackRemoveProduct.click();
    	bikeLightRemoveProduct.click();
    	boltTShirtRemoveProduct.click();
    	onsieRemoveProduct.click();
    	
    	return cartCount.getText();
    }
    
    public String verifyClickOnCartIcon()
    {
    	cartIcon.click();                // To use this to open cart page, can write tc on it
        return driver.getCurrentUrl();	
    }
    
}





