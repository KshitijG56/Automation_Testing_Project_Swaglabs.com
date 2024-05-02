package testcases;

import java.io.IOException; 

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBaseFM01;
import pages.LoginPageFM01;
import utility.ReadDataFM01;
import utility.Screenshot;

public class LoginPageTestFM01 extends TestBaseFM01{
    
	LoginPageFM01 Login;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();              
		Login = new LoginPageFM01();
	}
	
	@Test(enabled = true, priority = 3, dependsOnMethods = "verifyUrlTest")
	public void verifyLoginToApplicationTest() throws IOException
	{
		String exp = ReadDataFM01.readExcel(0, 2); // https://www.saucedemo.com/inventory.html (0,2)
		String act = Login.verifyLoginToApplication();
		Assert.assertEquals(exp, act);
		
	}
	
	@Test(enabled = true, priority = 2, dependsOnMethods = "verifyUrlTest")
	public void verifyTitleTest() throws EncryptedDocumentException, IOException
	{
	   String exp = ReadDataFM01.readExcel(0, 0);  // Swag Labs (0,0)   -- fail
	   String act = Login.verifyTitle();
	   Assert.assertEquals(exp, act);
	}
	
	@Test(enabled = true, priority = 1)
	public void verifyUrlTest() throws EncryptedDocumentException, IOException
	{
		 String exp = ReadDataFM01.readExcel(0, 1); // https://www.saucedemo.com/ (0,1)  -- pass
		 String act = Login.verifyUrl();
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



