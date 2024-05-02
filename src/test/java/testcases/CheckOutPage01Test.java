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
import pages.CheckOutPage01;
import pages.InventoryPageFM01;
import pages.LoginPageFM01;
import utility.ReadDataFM01;
import utility.Screenshot;

public class CheckOutPage01Test extends TestBaseFM01{
	
	  LoginPageFM01 Login;
	  InventoryPageFM01 Invent;
      CartPageFM01 Cart;
      CheckOutPage01 Check1;
	  
	  @BeforeMethod
	  public void Setup() throws IOException, InterruptedException
	  {
		  initialization();
		  Login = new LoginPageFM01();
		  Invent = new InventoryPageFM01();
		  Cart = new CartPageFM01();
		  Check1 = new CheckOutPage01();
		  
		  Login.verifyLoginToApplication();
		  Invent.verifyClickOnCartIcon();
		  Cart.verifyClickOnCheckoutBtn();
	  }
	 
	 @Test
	 public void verifyContinueBtnTest() throws EncryptedDocumentException, IOException
	 {
		 String exp = ReadDataFM01.readExcel(3,3);   // https://www.saucedemo.com/checkout-step-two.html (3,3)
		 String act = Check1.verifyContinueBtn();
		 Assert.assertEquals(exp, act);
	 }
	 
	 
	 @Test
	 public void verifyPageLableTest() throws EncryptedDocumentException, IOException
	 {
		 String exp = ReadDataFM01.readExcel(3, 4);   // Checkout: Your Information (3,4)
		 String act = Check1.verifyPageLable();
		 Assert.assertEquals(exp, act);
	 }
	 
	 
	 @Test
	 public void verifyClickOnCancelBtnTest() throws EncryptedDocumentException, IOException
	 {
		 String exp = ReadDataFM01.readExcel(2, 0);    // https://www.saucedemo.com/cart.html (2,0)
         String act = Check1.verifyClickOnCancelBtn();
         Assert.assertEquals(exp, act);
		 
	 }
	 
	 
	 @AfterMethod
     public void closeBrowser(ITestResult itr) throws IOException
     {
		 if(itr.FAILURE == itr.getStatus())
		 {
			  Screenshot.screenshot(itr.getName());
		 }
		 
		 driver.close();
     }
	 
}
