package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTIme {
@Test
public void seleniumTest() throws InterruptedException, IOException {
//Read the from CMD LINE
	
	
String  BROWSER= 

String URL = System.getProperty(BROWSER);
String USERNAME = 
String PASSWORD = 


WebDriver driver=null;

if(BROWSER.equals("chrome"))
{
driver=new ChromeDriver();

}else if(BROWSER.equals("firefox"))
{
driver = new FirefoxDriver();

}else if(BROWSER.equals("edge"))
{
driver=new EdgeDriver();
}else
{
driver= new ChromeDriver();
}

//step1: login to app
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get(URL);

driver.findElement(By.name("user_name")).sendKeys(USERNAME);

driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
Thread.sleep(2000);
driver.findElement(By.id("submitButton")).click();
	
}
}
