package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFM01 {

	public static String readProperty(String value) throws IOException
	{
		Properties prop = new Properties(); // To use Properties  methods
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Framework_Model_01\\TestData\\config.properties");
	    prop.load(file);  // all properties loaded in prop obj
	    return prop.getProperty(value);  // return required value
	
	}
	
	// Parameterization
	public static String readExcel(int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Framework_Model_01\\TestData\\TestDataSheet.xlsx");
	    Sheet exSheet = WorkbookFactory.create(file).getSheet("Sheet1");
	    String data = exSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	    return data;
	}
}

// readProperty() = To read data in config.properties
// config.properties = Imp data like UN,PW,URL, Admin data

/*
- Properties prop = new Properties(); - iss class me methods hai to load and get properties
- 2nd line file ko load kiya in file

// Hum jo value bahar se bhejenge woh parameter me ayega pehle and udhar se getProperty() ke 
   parameter me jayega.
 
*/








