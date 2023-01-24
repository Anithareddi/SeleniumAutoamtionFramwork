package com.testng;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseTest {
	public Login() {
		super();
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException {
	
		WebDriverManager.chromedriver().setup();
		loadPropertiesFile();

           driver = intializeAndOpenBrowser(prop.getProperty("browser"));
		driver.get("https://www.carlile.com.au/location/hills-district/norwest/");
		
	}
	public  WebDriver intializeAndOpenBrowser(String property) {
		
		return driver;
	}
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
	//driver.manage().window().maximize();
	@Test(priority=1)
	public void verifHomePage() {
		//ChromeDriver chromeDriver = new ChromeDriver();
		driver.findElement(By.xpath("(//a)[2]"));
		System.out.println("click on parent portal ");
		driver.findElement(By.linkText("Carlile Swimming Team"));
		System.out.println("click on swimming team");
		driver.findElement(By.xpath("//a[10]"));
		System.out.println("locations");
		driver.findElement(By.xpath("(//a)[17]"));
		System.out.println("program");
				
	}
	@Test(priority=2)
	public void parentalPortal() {
		driver.findElement(By.linkText("Parent Portal")).click();
		//driver.findElement(By.className("title-chevron-wrap")).click();
		System.out.println("click on parent portal");
		driver.findElement(By.cssSelector(".title-chevron-wrap")).click();
		//driver.findElement(By.xpath("//span[@class='title-chevron-wrap']")).click();
		System.out.println("click on begin");
		driver.findElement(By.linkText(" Got It! ")).click();
		
	}

}
