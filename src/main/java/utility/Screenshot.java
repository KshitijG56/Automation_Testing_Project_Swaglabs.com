package utility;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBaseFM01;

public class Screenshot extends TestBaseFM01 {
       
	  public static String getDate()           // To get current date and time
	  {
		    return new SimpleDateFormat("dd-MM-YYY ss-mm-HH").format(new Date());
	  }
	  
	  public static void screenshot(String nameOfMethod) throws IOException     
	  {
		  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);     
		  File dest = new File("C:\\Users\\Hp\\eclipse-workspace\\Framework_Model_01\\Screenshot\\"+nameOfMethod+"-----"+getDate()+".jpeg");
	      FileHandler.copy(source, dest);   
	  }
	  // nameOfMethod After method se get karenge, bas humko failed nameOfMethod chahiye
}
/*
    - we created object of SimpleDateFormat class to use format() method
    - format() = convert date which we get from new Date() into String format as specified in SimpleDtFormat parameter
    - new Date() = gives exact date and time
 */












