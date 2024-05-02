package testcases;

import java.io.IOException; 

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBaseFM01;
import pages.InventoryPageFM01;
import pages.LoginPageFM01;
import utility.ReadDataFM01;
import utility.Screenshot;

public class InventoryPageTestFM01 extends TestBaseFM01 {
	
	InventoryPageFM01 Invent;
	LoginPageFM01 Login;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		Login = new LoginPageFM01();
		Invent = new InventoryPageFM01();       
		Login.verifyLoginToApplication();
		Thread.sleep(2000);
	}
	
	@Test(enabled = true, priority = 4)
	public void verifyTitleTestIP() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(1, 0); // Swag Labs(1,0)      
		String act = Invent.verifyTitle();
		Assert.assertEquals(exp, act);
	}
	
	@Test(enabled = true, priority = 3)
	public void verifyAdd6ProductTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(1, 1);   // 6 (1,1)   
		String act = Invent.verifyAdd6Product();
		Assert.assertEquals(exp, act);
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyTwitterLogoTest()      // Dont compare exp and act in boolean
	{
		boolean result = Invent.verifyTwitterLogo();  
		Assert.assertEquals(result, true);
	}
	
	@Test(enabled = true, priority = 1)
	public void remove4ProductTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(1, 3);      // 2 (1,3) --- pass
		String act = Invent.remove4Product();
		Assert.assertEquals(exp, act);
	}
	
	@Test
	public void verifyClickOnCartIconTest() throws EncryptedDocumentException, IOException
	{
		String exp = ReadDataFM01.readExcel(2, 0);      // https://www.saucedemo.com/cart.html  (2,0)
		String act = Invent.verifyClickOnCartIcon();
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





