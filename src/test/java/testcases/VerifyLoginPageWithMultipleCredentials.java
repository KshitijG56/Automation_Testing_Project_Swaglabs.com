package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBaseFM01;
import pages.LoginPageFM01;
import utility.Screenshot;

public class VerifyLoginPageWithMultipleCredentials extends TestBaseFM01{
	
	public static LoginPageFM01 Login;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		 initialization();
		 Login = new LoginPageFM01();		 
	}
	
	@DataProvider(name = "Credentials")
	public Object[][] getData()
	{
		return new Object[][]       
		{                                 
			{"standard_user","secret_sauce"},
//			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"},
		};
	}

//	@DataProvider(name = "Credentials2")
//	public Object[][] getData2()
//	{ 
//		return new Object[][]
//		{
//			{"standard_user","secret_sauce"},  // CI,CP
//			{"standard_user","1secret_sauce"}, // CI,WP       // Incorrect Data
//			{"standard_user1","secret_sauce"},  // WI,CP      // Incorrect Data
//			{"standard_user1","s1ecret_sauce"},  // WI,WP     // Incorrect Data
//		};
//	}
	
	@Test(dataProvider = "Credentials2")
	public void loginToApplicationMultiCredsTest(String un, String pass)           
	{
		  SoftAssert sa = new SoftAssert();
		  String exp = "https://www.saucedemo.com/inventory.html";
		  String act = Login.loginToApplicationMultiCreds(un, pass);
		  sa.assertEquals(exp, act);
		  sa.assertAll();               
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
