package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utils.Utilites;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	WebDriver driver ;
	public Properties prop ;
	public Properties testdata;
	
	public void loadPropertiesFile() throws FileNotFoundException  {
		 new Properties();
		File propFile = new File(System.getProperty("user.dir")+"src\\main\\java\\com\\config\\config.properities");
		FileInputStream fis= new FileInputStream(propFile);
		testdata = new Properties();
		File dataFile = new File(System.getProperty("user.dir")+"src\\main\\java\\com\\testdata\\testdata.properities");
		FileInputStream fis1= new FileInputStream(dataFile);
		try {
			testdata.load(fis1);
		} catch(IOException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	
	@BeforeMethod
	public WebDriver setUp(String BrowserName) {
	
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilites.implict_wait_time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilites.page_wait_time));
		driver.get(prop.getProperty("url"));
		
		return driver; 
	}
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
	
	
	
	
}
