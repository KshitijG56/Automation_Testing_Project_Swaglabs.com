package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadDataFM01; 

public class TestBaseFM01 {
      
	  public static WebDriver driver; 
	  public void initialization() throws IOException, InterruptedException
      {
		  String browserrr = ReadDataFM01.readProperty("browser");
		  
		  if(browserrr.equals("chrome"))
		  {
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		  }
		  else if(browserrr.equals("edge"))
		  {
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		  }
		  else if(browserrr.equals("firefox"))
		  {
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		  }
			 
	
               driver.manage().window().maximize();
               driver.get(ReadDataFM01.readProperty("URL"));
               Thread.sleep(2000);
      }
	   // Automation swaglabs project
	  
}
