package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBaseFM01;
import pages.CartPageFM01;
import pages.InventoryPageFM01;
import pages.LoginPageFM01;
import utility.ReadDataFM01;
import utility.Screenshot;

public class CartPageTestFM01 extends TestBaseFM01 {
       
	  public LoginPageFM01 Login;
	  public InventoryPageFM01 Invent;
	  public CartPageFM01 Cart; 
	   
	  @BeforeMethod
	  public void setUp() throws IOException, InterruptedException
	  {
		  initialization();		  
		  Login = new LoginPageFM01();
		  Invent = new InventoryPageFM01();
		  Cart = new CartPageFM01();
		  
		  Login.verifyLoginToApplication();
		  Invent.verifyClickOnCartIcon();
		  
	  }
	  

	  
	  @Test(enabled = true, priority = 2)
	  public void verifyCartPageLableTest() throws EncryptedDocumentException, IOException
	  {
		  String exp = ReadDataFM01.readExcel(2, 1);  // Your Cart (2,1)
		  String act = Cart.verifyCartPageLable();
		  Assert.assertEquals(exp, act);
	  }
	  
	  @Test(enabled = true, priority = 0)
	  public void verifyClickOnCheckoutBtnTest() throws EncryptedDocumentException, IOException
	  {
		  String exp = ReadDataFM01.readExcel(2, 2);   // https://www.saucedemo.com/checkout-step-one.html (2,2)
		  String act = Cart.verifyClickOnCheckoutBtn();
		  Assert.assertEquals(exp, act);
	  }
	  
	  @Test(enabled = true, priority = 1)
	  public void verifyContinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	  {
		  String exp = ReadDataFM01.readExcel(2, 3); // https://www.saucedemo.com/inventory.html (2,3)
		  String act = Cart.verifyClickOnContShopBtn();
		  Assert.assertEquals(exp, act);
	  }
	  
	  @AfterMethod
	  public void closeBrowser(ITestResult itr) throws IOException
	  {
		  if(itr.FAILURE==itr.getStatus())
		  {
			  Screenshot.screenshot(itr.getName());
		  }
		  
		  driver.close();
	  }


}















