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
import pages.CheckOutPage02;
import pages.InventoryPageFM01;
import pages.LoginPageFM01;
import utility.ReadDataFM01;
import utility.Screenshot;

public class CheckOutPage02Test extends TestBaseFM01{

	LoginPageFM01 login;
	InventoryPageFM01 invent;
	CartPageFM01 cart;           
    CheckOutPage01 check1;
    CheckOutPage02 check2;
    
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login = new LoginPageFM01();
		invent = new InventoryPageFM01();
		cart = new CartPageFM01();
		check1 = new CheckOutPage01();
		check2 = new CheckOutPage02();
		
		login.verifyLoginToApplication();
		invent.verifyClickOnCartIcon();
		cart.verifyClickOnCheckoutBtn();
		check1.verifyContinueBtn();
		
	}
	
	@Test
	public void verifyPageLableTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String exp = ReadDataFM01.readExcel(4, 0);
		String act = check2.verifyPageLable();
		Thread.sleep(2000);
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void paymentInfoLableTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(4,1);
		String act = check2.paymentInfoLable();
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void paymentInfoValueTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(4,2);
		String act = check2.paymentInfoValue();
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void shippingInfoLableTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(4,3);
		String act = check2.shippingInfoLable();
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void priceTotalLableTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(4,5);
		String act = check2.priceTotalLable();
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void cancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(4,6);
		String act = check2.cancelBtn();
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void finishBtnTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(4,7);
		String act = check2.finishBtn();
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
