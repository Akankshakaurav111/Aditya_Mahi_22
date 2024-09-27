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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumCreateOrgTest {
	@Test
	public void createOrgtest() throws IOException, InterruptedException {
	//Read data From CMD LINE
	String URL=System.getProperty("url");
String  BROWSER=  System.getProperty("browser");
String USERNAME = System.getProperty("username");
String PASSWORD =System.getProperty("password"); 
//generat randomNum 
Random random=new Random();
int randomInt=random.nextInt(1000);


//read the data from excel file
FileInputStream fis1=new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\testScript.xlsx");
Workbook wb= WorkbookFactory.create(fis1);
Sheet sh=wb.getSheet("org");
Row row = sh.getRow(1);
String orgName=row.getCell(2).toString()+randomInt;
wb.close();

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
Thread.sleep(2000);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
Thread.sleep(2000);
driver.findElement(By.id("submitButton")).click();
Thread.sleep(2000);
//step2: nvigate to organaization module
driver.findElement(By.linkText("Organizations")).click();  
//step3:click on "Create organization module
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//step4: enter all thedetails and create new orgnization 
driver.findElement(By.name("accountname")).sendKeys(orgName);
driver.findElement(By.name("button")).click();

driver.quit();
}

}


